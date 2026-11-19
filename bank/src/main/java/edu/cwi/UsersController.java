package edu.cwi;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import java.math.BigDecimal;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;

public class UsersController implements CrudHandler {

    @Override
    public void getAll(Context ctx) {

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            UserMapper mapper = session.getMapper(UserMapper.class);

            ctx.json(mapper.getAllUsers());
        }
    }

    @Override
    public void getOne(Context ctx, String resourceId) {

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            UserMapper mapper = session.getMapper(UserMapper.class);

            ctx.json(mapper.getById(Integer.parseInt(resourceId)));
        }
    }

@Override
public void create(Context ctx) { // Definitely did some google searching to get this working properly

    try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

        User user = ctx.bodyAsClass(User.class);

        UserMapper userMapper = session.getMapper(UserMapper.class);
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        TransactionMapper transactionMapper = session.getMapper(TransactionMapper.class);

        BigDecimal deposit = BigDecimal.valueOf(5.00);

        // Hash the password before storing it
        String hashedPassword =
                BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        user.setPassword(hashedPassword);

        // Insert the user
        userMapper.insert(user);

        // Insert an account for the new user
        Account account = new Account();

        account.setUserId(user.getId());
        account.setAccountType(AccountType.CHECKING);
        account.setBalance(deposit);

        accountMapper.insert(account);

        // Insert the opening transaction
        Transaction transaction = new Transaction();

        transaction.setAccountId(account.getId());
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setAmount(deposit);
        transaction.setDescription("Opening deposit.");

        transactionMapper.insert(transaction);

        // Commit all inserts
        session.commit();

        // Return the new user
        ctx.json(user);
    }
}
    @Override
    public void update(Context ctx, String resourceId) {

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            User user = ctx.bodyAsClass(User.class);

            UserMapper mapper = session.getMapper(UserMapper.class);

            user.setId(Integer.parseInt(resourceId));

            mapper.update(user);

            session.commit();

            ctx.json(user);
        }
    }

    @Override
    public void delete(Context ctx, String resourceId) {

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            UserMapper mapper = session.getMapper(UserMapper.class);

            mapper.delete(Integer.parseInt(resourceId));

            session.commit();

            ctx.json(Map.of(
                    "id", resourceId,
                    "deleted", true
            ));
        }
    }

    public User authenticateUser(Context ctx, String username, String password) { // From the example

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            UserMapper mapper = session.getMapper(UserMapper.class);

            User user = mapper.getByUsername(username);

            if (user != null) {

                if (BCrypt.checkpw(password, user.getPassword())) {
                    return user;
                }
            }

            return null;
        }
    }
}