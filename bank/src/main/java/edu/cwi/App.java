package edu.cwi;

import io.javalin.Javalin;
import io.javalin.http.UnauthorizedResponse;
import io.javalin.rendering.template.JavalinJte;

import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {

    public static void main(String[] args) {

        var app = Javalin.create(config -> {

            config.fileRenderer(new JavalinJte());

        config.routes.apiBuilder(() -> {

            crud("transactions/{id}", new TransactionsController());

            crud("users/{id}", new UsersController());

            path("/account", List.of(AppRole.CUSTOMER), () -> {
                get(AccountController::renderAccount);
            });

            path("/login", () -> {
                get(ctx -> ctx.render("jte/loginPage.jte"));
                post(AuthController::authenticate);
            });

            path("/logout", () -> {
                get(AuthController::logout);
            });
        });

            config.routes.beforeMatched(ctx -> {

                if (ctx.routeRoles().isEmpty()) {
                    return;
                }

                String role = ctx.cookieStore().get("user-role");

                if (role == null) {
                    throw new UnauthorizedResponse();
                }

                AppRole appRole = AppRole.valueOf(role);

                if (!ctx.routeRoles().contains(appRole)) {
                    throw new UnauthorizedResponse();
                }
            });

            config.routes.get("/", ctx -> ctx.redirect("/login"));

        }).start(7070);
    }
}

