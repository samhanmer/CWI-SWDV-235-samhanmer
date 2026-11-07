package gg.jte.generated.ondemand.jte;
import gg.jte.Content;
@SuppressWarnings("unchecked")
public final class JteaccountLayoutGenerated {
	public static final String JTE_NAME = "jte/accountLayout.jte";
	public static final int[] JTE_LINE_INFO = {1,1,4,4,4,4,13,13,13,13,20,20,20,23,23,23,29,29,29,4,5,6,6,6,6};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, Content account, Content detail) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n  <head>\r\n    <meta charset=\"utf-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB\" crossorigin=\"anonymous\">\r\n  </head>\r\n  <body>\r\n    <div class=\"container\">\r\n        <div class=\"row align-items-start\">\r\n\t\t\t<div class=\"col\">\r\n\t\t\t\t");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(account);
		jteOutput.writeContent("\r\n\t\t\t</div>\r\n\t\t\t<div class=\"col\">\r\n\t\t\t\t");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(detail);
		jteOutput.writeContent("\r\n\t\t\t</div>\r\n\t\t</div>\r\n    </div\r\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI\" crossorigin=\"anonymous\"></script>\r\n  </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.getOrDefault("title", "My Bank");
		Content account = (Content)params.get("account");
		Content detail = (Content)params.get("detail");
		render(jteOutput, jteHtmlInterceptor, title, account, detail);
	}
}
