package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import Modelo.Empresa;
import Controlador.ServletEmpresa;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Index</title>\r\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <table style=\"width: 80%; text-align: center; margin-left: auto;margin-right: auto;\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td style=\"font-weight: bold\">Empresas</td>\r\n");
      out.write("            <td style=\"font-weight: bold\">Ver Página</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

               ServletEmpresa servlet = new ServletEmpresa();
               List<Empresa> empresas = new ArrayList();
               empresas=servlet.traeEmpresa();
               if(empresas !=null) {
               for(Empresa e : empresas){
                   
            
      out.write("<tr>\r\n");
      out.write("                <td>");
      out.print(e.getDenominacion());
      out.write("</td>\r\n");
      out.write("                <td><a href=\"home.jsp?idEmpresa=");
      out.print(e.getId());
      out.write('"');
      out.write('>');
      out.print(e.getDenominacion());
      out.write("</a> </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              ");

                
                }
                }else{
                    
      out.write("\r\n");
      out.write("                    No se encontraron empresas cargadas\r\n");
      out.write("                    ");

                }

          
      out.write("  \r\n");
      out.write("            \r\n");
      out.write("        </table>\r\n");
      out.write("          <section class=\"well1\">\r\n");
      out.write("                    <div class=\"container\"> \r\n");
      out.write("                        <p class=\"rights\" style=\"padding-left: 10%\">\r\n");
      out.write("                            <a href=\"EmpresaAlta.jsp\">Agregar nueva Empresa</a>\r\n");
      out.write("                            \r\n");
      out.write("                        </p>          \r\n");
      out.write("                    </div> \r\n");
      out.write("                </section>   \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
