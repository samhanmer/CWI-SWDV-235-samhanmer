package edu.cwi;

import io.javalin.http.Context;

import java.util.Map;
import java.util.Optional;

public class AccountController {

    public static void renderAccount(Context ctx) {

        String userId = ctx.cookieStore().get("user-id");

        Optional<UserAccount> user = AuthController.getUser(userId);

        if (user.isPresent()) {

            ctx.render("jte/accountPage.jte", Map.of(
                "title", "User Account",
                "account", user.get()
            ));

        } else {

            ctx.redirect("/login");
        }
    }
}