package gg.jte.generated.ondemand.jte;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtetransactionsPageGenerated {
	public static final String JTE_NAME = "jte/transactionsPage.jte";
	public static final int[] JTE_LINE_INFO = {1,1,4,4,4,4,18,18,19,19,20,20,20,20,20,20,21,21,25,25,25,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, String> transactions) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n  <head>\r\n    <meta charset=\"utf-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n    <title>Transactions</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n    <link rel=\"stylesheet\" href=\"/css/styles.css\">\r\n  </head>\r\n  <body>\r\n    <h1>Transactions</h1>\r\n    <ul>\r\n\t\t");
		jteOutput.writeContent("\r\n\t\t");
		for (var entry : transactions.entrySet()) {
			jteOutput.writeContent("\r\n\t\t\t<li>");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.writeContent(": ");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(entry.getValue());
			jteOutput.writeContent("</li>\r\n\t\t");
		}
		jteOutput.writeContent("\r\n    </ul>\r\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js\"></script>\r\n  </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String, String> transactions = (Map<String, String>)params.get("transactions");
		render(jteOutput, jteHtmlInterceptor, transactions);
	}
}
