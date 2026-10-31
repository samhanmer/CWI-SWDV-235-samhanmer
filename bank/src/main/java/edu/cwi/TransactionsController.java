package edu.cwi;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import static j2html.TagCreator.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionsController implements CrudHandler {

    private final Map<String, String> transactions = new ConcurrentHashMap<>();

    public TransactionsController() {
        this.transactions.put("1", "Transaction 1");
        this.transactions.put("2", "Transaction 2");

    }
    @Override
    public void getAll(Context ctx) {
        // Use ctx to render all transactions html
        ctx.render("jte/transactionsPage.jte", Map.of("transactions", transactions));
    }

    @Override
    public void getOne(Context ctx, String resourceId) {

        String transaction = transactions.get(resourceId);
        // Forms put here so they only display on individual items. After scanning my notes and material outside of class, I am lost on how to make this part work right now.
        if (transaction != null) {
            // Use ctx to render transaction html
            String view = html(
                body(h1("Transaction"),
                p("ID: " + resourceId),
                p(transaction),
                form().withMethod("POST").withAction("/transactions/" + resourceId).with(input().withType("text").withName("transaction"), button("Update").withType("submit")),
                form().withMethod("POST").withAction("/transactions/" + resourceId).with(button("Delete").withType("submit")))
            ).render();

            ctx.html(view);
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void create(Context ctx) {

        String body = ctx.body();
        String id = String.valueOf(transactions.size() + 1);

        transactions.put(id, body);

		// Use ctx to render all transactions html
        String view = this.renderTransactions();

        ctx.html(view);
    }

    @Override
    public void update(Context ctx, String resourceId) {

        if (transactions.containsKey(resourceId)) {
            transactions.put(resourceId, ctx.body());

            // Use ctx to render all transactions html
        String view = this.renderTransactions();

        ctx.html(view);
            
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void delete(Context ctx, String resourceId) {

        transactions.remove(resourceId);

		// Use ctx to render all transactions html
        String view = this.renderTransactions();

        ctx.html(view);
    }

    private String renderTransactions() {
    return html(
        body(
            h1("Transactions"),

            p("1: " + transactions.get("1")),
            p("2: " + transactions.get("2")),
            // This form works properly. It does create new stuff. Delete and update do not work.
            form().withMethod("POST").with(input().withType("text").withName("transaction"), button("Create").withType("submit"))
        )
    ).render();
}
}

