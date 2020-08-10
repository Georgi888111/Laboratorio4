<%-- 
    Document   : buscador
    Created on : 17 mar. 2020, 03:55:35
    Author     : franc
--%>

<%@page import="Modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Noticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="format-detection" content="telephone=no"/>
        <link rel="icon" href="images/favicon.ico" type="image/x-icon">
        <title>PRIVACY</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Links -->
        <link rel="stylesheet" href="css/search.css">

        <!--JS-->
        <script src="js/jquery.js"></script>
        <script src="js/jquery-migrate-1.2.1.min.js"></script>
        <script src="js/rd-smoothscroll.min.js"></script>


        <!--[if lt IE 9]>
        <div style=' clear: both; text-align:center; position: relative;'>
            <a href="http://windows.microsoft.com/en-US/internet-explorer/..">
                <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820"
                     alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."/>
            </a>
        </div>
        <script src="js/html5shiv.js"></script>
        <![endif]-->
        <script src='js/device.min.js'></script>
    </head>
    <body>
        <%Empresa empresa = (Empresa) request.getAttribute("empresa");%>
        <div class="page">
            <!--========================================================
                                      HEADER
            =========================================================-->
            <header>  
                <div class="container top-sect">
                    <div class="navbar-header">
                        <h1 class="navbar-brand">
                            <a data-type='rd-navbar-brand'  href="./"><small><%=empresa.getDenominacion()%></small></a>
                        </h1>
                        <a class="search-form_toggle" href="#"></a>
                    </div>

                    <div class="help-box text-right">
                        <p>Telefono</p>
                        <a href="callto:#"><%=empresa.getTelefono()%> </a>
                        <small><span>Horario:</span>  <%=empresa.getHorarioAtencion()%></small>
                    </div>
                </div>
                <script src="JS/ScriptsBusqueda.js"></script>

                <div id="stuck_container" class="stuck_container">
                    <div class="container">   
                        <form class="search-form" action="http://localhost:8080/TrabajoPractico1/ServletNoticia"
                              method="GET" accept-charset="utf-8"
                              <label class="search-form_label">
                                <input class="search-form_input"  id="ingresoUsuario" type="text" name="s" autocomplete="off" placeholder=""/>
                                <input type="hidden" id="ocultoBusqueda" name="idEmpresa" value="<%=request.getParameter("idEmpresa")%>">
                                <span class="search-form_liveout"></span>
                            </label>
                            <button class="search-form_submit fa-search" type="submit" name="accion" value="buscar"></button>
                        </form>

                    </div>

                </div>  

            </header>

            <!--========================================================
                                      CONTENT
            =========================================================-->

            <main>        

                <section class="well well4">

                    <div class="container">

                        <h2>
                            <%=request.getParameter("s")%>
                        </h2>
                        <div class="row offs2">
                            <%
                                List<Noticia> noticias = (List<Noticia>) request.getAttribute("resultados");
                                if (noticias != null && !noticias.isEmpty()) {
                                    for (Noticia noticia : noticias) {
                            %>
                            <table width="90%" align="center">
                                <tbody>
                                    <tr>
                                        <td>
                                            <a href="http://localhost:8080/TrabajoPractico1/detalle.jsp?idNoticia=<%=noticia.getId()%>">
                                                <img width="250px" class="imgNoticia" src="<%=noticia.getImagen()%>" alt="">
                                            </a>
                                        </td>
                                        <td width="25"></td>
                                        <td style="text-align:justify;" valign="top">
                                            <a style="text-align:justify; font-size:20px" 
                                               href="http://localhost:8080/TrabajoPractico1/detalle.jsp?idNoticia=<%=noticia.getId()%>" class="banner">
                                                <%=noticia.getTitulo()%>								
                                            </a>
                                            <div class="verOcultar">
                                                <%=noticia.getResumen()%>
                                                <a href="http://localhost:8080/TrabajoPractico1/detalle.jsp?idNoticia=<%=noticia.getId()%>" 
                                                   style="color:blue"> Leer Mas - <%=noticia.getFechaPublicacion()%></a>											
                                            </div>
                                        </td>

                                    </tr>
                                </tbody>
                            </table>
                            <hr>
                            <%
                                }
                            } else {
                            %>

                            <table width="60%" align="right">
                                <td style="text-align:justify;" valign="top">
                                    <a style="text-align:justify; font-size:20px" class="banner">
                                        &nbsp; No existen noticias con la descripción solicitada.</a>
                                </td>
                            </table>

                            <%
                                }
                            %>
                            <hr>
                        </div>
                    </div>
                </section>   
            </main>

            <!--========================================================
                                    FOOTER
          =========================================================-->
            <footer>
                <section class="well">
                    <div class="container"> 
                        <p class="rights">
                            <%=empresa.getDenominacion()%>  &#169; <span id="copyright-year"></span>
                            <a href="index-5.html">Privacy Policy</a>
                            <!-- {%FOOTER_LINK} -->
                        </p>        
                    </div> 
                </section>    
            </footer>
        </div>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <!-- Include all compiled plugins (below), or include individual files as needed -->         
        <script src="js/bootstrap.min.js"></script>
        <script src="js/tm-scripts.js"></script>    
        <!-- </script> -->

        <!-- coded by vitlex -->

    </body>
</html>