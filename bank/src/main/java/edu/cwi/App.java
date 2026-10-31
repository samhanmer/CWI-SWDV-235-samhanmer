package edu.cwi;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;


public class App 
{
    public static void main( String[] args )
    {
        var app = Javalin.create(config -> {

			config.routes.apiBuilder(() -> {
				crud("transactions/{id}", new TransactionsController());
			});

            config.routes.get("/", ctx -> ctx.redirect("/transactions"));
            
        }).start(7070);
    }
}


