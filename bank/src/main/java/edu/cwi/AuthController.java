package edu.cwi;

import io.javalin.http.Context;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class AuthController {

    record Pair(String username, String password) {}

    private static final Map<Pair, UserAccount> userMap = Map.of(
        new Pair("ajones", "weak"),
        new UserAccount(
            "94f6901f-cd0f-4c90-81dc-3601a071c077",
            "Alice Jones",
            AppRole.CUSTOMER,
            750.00,
            Map.of("1", "Deposited $750.00")
        ),

        new Pair("bjones", "weak"),
        new UserAccount(
            "99377dc1-617d-45bd-b5fe-ac6418f06f43",
            "Bob Jones",
            AppRole.CUSTOMER,
            500.00,
            Map.of("1", "Deposited $500.00")
        )
    );

    public static Optional<UserAccount> getUser(String id) {

        Collection<UserAccount> accounts = userMap.values();

        for (UserAccount account : accounts) {
            if (account.id().equals(id)) {
                return Optional.of(account);
            }
        }

        return Optional.empty();
    }

    public static void authenticate(Context ctx) { // Straight from the example.

        UsersController usersController = new UsersController();

        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        User user = usersController.authenticateUser(ctx, username, password);

        if (user != null) {

            ctx.cookieStore().set("user-id", user.getId());
            ctx.cookieStore().set("user-role", user.getRole());

            ctx.redirect("/account");
        }
        else {

            ctx.cookieStore().clear();

            ctx.redirect("/unauthorized.html");
        }
    }

    public static void logout(Context ctx) {

        ctx.cookieStore().clear();

        ctx.redirect("/");
    }
}