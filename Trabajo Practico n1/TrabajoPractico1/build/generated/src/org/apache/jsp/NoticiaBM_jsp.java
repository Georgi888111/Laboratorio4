package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class NoticiaBM_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Gesti&oacute;n de noticias institucionales</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <script src=\"JS/ScriptsNoticia.js\"></script>\r\n");
      out.write("        <script src=\"JS/ScriptsGenerales.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.tiny.cloud/1/dbexawxwbfj0s1e11togop4bo8d37uhedmby9exdz4oaz162/tinymce/5/tinymce.min.js\"></script>\r\n");
      out.write("        <script>tinymce.init({selector: 'textarea'});</script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Gestione sus noticias</h1>\r\n");
      out.write("        <form id=\"formNoticia\" action=\"http://localhost:8080/TrabajoPractico1/ServletNoticia\" onsubmit=\"return enviarDatos();\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                    <td><input type=\"number\" name=\"id\" value=\"");
      out.print(request.getParameter("idNoticia"));
      out.write(")\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>T&iacute;tulo</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"titulo\" id=\"titulo\" maxlength=\"128\" placeholder=\"T&iacute;tulo de la noticia\" size=\"36\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Resumen</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"resumen\" id=\"resumen\" maxlength=\"1024\" placeholder=\"Resumen de la noticia\" size=\"36\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Imagen</td>\r\n");
      out.write("                    <td><input type=\"file\" name=\"imagen\" id=\"imagen\" accept=\"image/*\" size=\"36\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Contenido HTML</td>\r\n");
      out.write("                    <td><textarea name=\"contenido\" id=\"contenido\" maxlength=\"20480\" rows=\"4\" cols=\"28\" \r\n");
      out.write("                                  placeholder=\"Contenido HTML\" style=\"resize: none\"></textarea></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>¿Fue Publicada?</td>\r\n");
      out.write("                    <td><input type=\"checkbox\" name=\"publicada\" id=\"publicada\" size=\"36\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Fecha de Publicaci&oacute;n</td>\r\n");
      out.write("                    <td><input type=\"date\" name=\"fecha\" id=\"fecha\" size=\"36\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                    <td><input type=\"hidden\" name=\"idEmpresa\" value=\"");
      out.print(request.getParameter("idEmpresa"));
      out.write("\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            <br>\r\n");
      out.write("            <button type=\"submit\" name=\"accion\" value=\"B\">Baja</button>\r\n");
      out.write("            <button type=\"submit\" name=\"accion\" value=\"M\">Modificaci&oacute;n</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
