package edu.cwi;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;


public class App 
{
    public static void main( String[] args ) {
        Javalin.create(config -> {
            config.jetty.port=7070;
            config.jetty.host = "localhost";
            config.staticFiles.add("/public", Location.CLASSPATH);
            config.routes.get("/account", ctx -> {
                ctx.redirect("/account.html");
            });
            config.routes.get("/logout", ctx -> {
                ctx.redirect("/");
            });
        }).start();
    }
}
