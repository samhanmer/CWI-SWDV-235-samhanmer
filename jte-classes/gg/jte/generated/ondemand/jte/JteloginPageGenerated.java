package gg.jte.generated.ondemand.jte;
@SuppressWarnings("unchecked")
public final class JteloginPageGenerated {
	public static final String JTE_NAME = "jte/loginPage.jte";
	public static final int[] JTE_LINE_INFO = {25,25,25,25,25,25,25,25,25,25,25,25};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\r\n\r\n<html lang=\"en\">\r\n<head>\r\n    <title>Login</title>\r\n    <meta charset=\"UTF-8\">\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB\" crossorigin=\"anonymous\">\r\n</head>\r\n\r\n<body>\r\n\r\n<h1>Login</h1>\r\n\r\n<form action=\"/login\" method=\"POST\">\r\n    <label>Username:</label>\r\n    <input type=\"text\" name=\"username\">\r\n\r\n    <label>Password:</label>\r\n    <input type=\"password\" name=\"password\">\r\n\r\n    <button type=\"submit\">Login</button>\r\n</form>\r\n\r\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI\" crossorigin=\"anonymous\"></script>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
