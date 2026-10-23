package edu.cwi;
import io.javalin.Javalin;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var app = Javalin.create(config -> {

            config.routes.get("/", ctx -> ctx.result("In the URL, enter http://localhost:7070/{your name here} and then after seeing that, add /html to it!"));

            config.routes.get("/hello/{name}", ctx -> { 
                ctx.result("Hello: " + ctx.pathParam("name"));
            });

            config.routes.get("/hello/{name}/html", ctx -> {
                ctx.html("<html><head><title>Javalin Intro</title></head><body><h1>Hello, " + ctx.pathParam("name") + "</h1></body></html>");
            });
    }).start(7070);
}
}
