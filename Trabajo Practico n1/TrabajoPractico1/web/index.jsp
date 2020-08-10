<%-- 
    Document   : index
    Created on : 15/03/2020, 21:00:09
    Author     : rocio
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Empresa"%>
<%@page import="Controlador.ServletEmpresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <table style="width: 80%; text-align: center; margin-left: auto;margin-right: auto;">
            <tr>
                <td style="font-weight: bold">Empresas</td>
            <td style="font-weight: bold">Ver Página</td>
            </tr>
            <%
               ServletEmpresa servlet = new ServletEmpresa();
               List<Empresa> empresas = new ArrayList();
               empresas=servlet.traeEmpresa();
               if(empresas !=null) {
               for(Empresa e : empresas){
                   
            %><tr>
                <td><%=e.getDenominacion()%></td>
                <td><a href="home.jsp?idEmpresa=<%=e.getId()%>"><%=e.getDenominacion()%></a> </td>
              </tr>
              <%
                
                }
                }else{
                    %>
                    No se encontraron empresas cargadas
                    <%
                }

          %>  
            
        </table>
          <section class="well1">
                    <div class="container"> 
                        <p class="rights" style="padding-left: 10%">
                            <a href="EmpresaAlta.jsp">Agregar nueva Empresa</a>
                            
                        </p>          
                    </div> 
                </section>   
    </body>
</html>