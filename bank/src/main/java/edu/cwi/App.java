package edu.cwi;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.apibuilder.ApiBuilder.*;


public class App 
{
    public static void main( String[] args )
    {
        var app = Javalin.create(config -> {

            config.fileRenderer(new JavalinJte());

			config.routes.apiBuilder(() -> {
				crud("transactions/{id}", new TransactionsController());
			});

            config.routes.get("/", ctx -> ctx.redirect("/transactions"));
            
        }).start(7070);
    }
}


