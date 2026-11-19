package edu.cwi;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface TransactionMapper {

    @Select("SELECT transaction_id as id, account_id as accountId, transaction_type as transactionType, amount, description, created_at as createdAt FROM transactions")
    List<Transaction> getAllTransactions();

    @Select("SELECT transaction_id as id, account_id as accountId, transaction_type as transactionType, amount, description, created_at as createdAt FROM transactions WHERE transaction_id = #{id}")
    Transaction getById(long id);

    @Insert("INSERT INTO transactions (account_id, transaction_type, amount, description) VALUES (#{accountId}, #{transactionType}, #{amount}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Transaction transaction);

    @Update("UPDATE transactions SET account_id = #{accountId}, transaction_type = #{transactionType}, amount = #{amount}, description = #{description} WHERE transaction_id = #{id}")
    int update(Transaction transaction);

    @Delete("DELETE FROM transactions WHERE transaction_id = #{id}")
    int delete(long id);
}