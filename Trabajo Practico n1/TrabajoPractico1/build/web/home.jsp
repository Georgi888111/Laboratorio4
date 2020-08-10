<%-- 
    Document   : home
    Created on : 15/03/2020, 22:27:39
    Author     : rocio
--%>

<%@page import="Modelo.Noticia"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Controlador.ServletEmpresa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Empresa"%>
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
        <script src="https://code.jquery.com/jquery-3.4.1.slim.js" integrity="sha256-BTlTdQO9/fascB1drekrDVkaKd9PkwBymMlHOiG+qLI="crossorigin="anonymous"></script>


        <script src="JS/device.min.js" type="text/javascript"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <title>HOME</title>

        <!-- Bootstrap -->

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <!-- Pruebas -->


        <!-- Links -->
        <link href="css/camera.css" rel="stylesheet" type="text/css"/>
        <link href="css/search.css" rel="stylesheet" type="text/css"/>
        <link href="css/google-map.css" rel="stylesheet" type="text/css"/>


        <!--JS-->




        <!--[if lt IE 9]>
        <div style=' clear: both; text-align:center; position: relative;'>
            <a href="http://windows.microsoft.com/en-US/internet-explorer/..">
                <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820"
                     alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."/>
            </a>
        </div>
        <script src="js/html5shiv.js"></script>
        <![endif]-->


    </head>
    <body>

        <div class="page">
            <!--=======================================================
                                      HEADER
            =========================================================-->
            <header>  
                <%
                    ServletEmpresa servlet = new ServletEmpresa();
                    Empresa empresa = new Empresa();
                    if (request.getParameter("idEmpresa") != null) {

                        empresa = servlet.traeUnaEmpresa(Integer.parseInt(request.getParameter("idEmpresa")));
                        empresa.setNoticias(servlet.cargaNoticias(empresa.getId()));

                    } else {
                        String id = String.valueOf(request.getAttribute("idEmpresa"));

                        empresa = servlet.traeUnaEmpresa(Integer.parseInt(id));
                        empresa.setNoticias(servlet.cargaNoticias(empresa.getId()));
                    }
                %>
                <div class="container top-sect">

                    <div class="navbar-header">
                        <h1 class="navbar-brand">
                            <a data-type='rd-navbar-brand'  href="./"><small><%=empresa.getDenominacion()%></small></a>
                        </h1>
                        <a class="search-form_toggle" href="#"></a>
                    </div>

                    <div class="help-box text-right">
                        <p>Telefono</p>
                        <a href="callto:#"><%=empresa.getTelefono()%></a>

                        <small><span>Horario:</span><%=empresa.getHorarioAtencion()%></small>
                    </div>
                </div>

                <div id="stuck_container" class="stuck_container">
                    <div class="container">   

                        <form class="search-form" action="http://localhost:8080/TrabajoPractico1/ServletNoticia" method="GET" accept-charset="utf-8">
                            <label class="search-form_label">
                                <input class="search-form_input" type="text" name="s" autocomplete="off" placeholder=""/>
                                <span class="search-form_liveout"></span>
                                <input type="hidden" name="idEmpresa" value="<%=empresa.getId()%>">
                            </label>
                            <button class="search-form_submit fa-search" name="accion" value="buscar" type="submit"></button>
                        </form>

                    </div>

                </div>  

            </header>

            <!--========================================================
                                      CONTENT
            =========================================================-->

            <main>        


                <section class="well well1 well1_ins1">

                    <div class="camera_container">

                        <div id="camera" class="camera_wrap"> 

                            <div id="slider-1" class="carousel slide" data-ride="carousel">

                                <div class="carousel-inner" role="listbox">
                                    <%if (!empresa.getNoticias().isEmpty()) {

                                            for (Noticia n : empresa.getNoticias()) {

                                                if (n.getId() == empresa.getNoticias().get(0).getId()) {

                                    %>
                                    <div class="item active">
                                        <div class="item">
                                            <a href="detalle.jsp"><img src="<%=n.getImagen()%>" alt="" class="img-responsive" style="width: 100%;"/></a>
                                            <div class="camera_caption fadeIn">
                                                <div class="jumbotron jumbotron1">
                                                    <em>
                                                        <a href="detalle.jsp?idNoticia=<%=n.getId()%>"><%=n.getTitulo()%></a>
                                                    </em>
                                                    <div class="wrap">
                                                        <p>
                                                            <%=n.getResumen()%>
                                                        </p>
                                                        <a href="#slider-1" class="btn-link fa-angle-right" data-slide="next"></a>
                                                    </div>  
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                    } else {
                                    %>
                                    <div class="item">
                                        <div class="item">
                                            <img src="<%=n.getImagen()%>" alt="" class="img-responsive" style="width: 100%;"/>
                                            <div class="camera_caption fadeIn">
                                                <div class="jumbotron jumbotron1">
                                                    <em>
                                                        <a href="detalle.jsp?idNoticia=<%=n.getId()%>"><%=n.getTitulo()%></a>
                                                    </em>
                                                    <div class="wrap">
                                                        <p>
                                                            <%=n.getResumen()%>
                                                        </p>
                                                        <a href="#slider-1" class="btn-link fa-angle-right" data-slide="next"></a>
                                                    </div>  
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                                    }

                                                }
                                            } else {
                                            %>
                                            <hr>
                                            <div style="margin-left: 50%">
                                                <p>
                                                    NO HAY NOTICIAS PUBLICADAS AÚN
                                                </p>
                                            </div>
                                            <hr>
                                            <%
                                            }
                                        
                                    %>
                                </div>
                            </div>
                        </div>
                    </div>

                </section>

                <section class="well well2 wow fadeIn  bg1" data-wow-duration='3s'>
                    <div class="container">
                        <h2 class="txt-pr">
                            Quienes Somos
                        </h2>
                        <div class="row">
                            <div class="col">
                                <p style="text-align:justify;padding-left: 10%;padding-right:10%;">
                                    <%=empresa.getQuienesSomos()%>
                                </p>
                            </div>
                        </div>
                    </div>
                </section>

            </main>

            <!--========================================================
                                    FOOTER
          =========================================================-->
            <footer class="top-border">
                <section class="well well2 wow fadeIn  bg1" data-wow-duration='3s'>
                    <div class="container">
                        <h2 class="txt-pr">
                            Donde estamos
                        </h2>
                    </div>
                </section>

                <div class="map">
                    <input type="hidden" id="denominacion" value="<%=empresa.getDenominacion()%>">
                    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css">
                    <script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>	  
                    <div id="map" class="map map-home" style="margin:12px 0 12px 0;height:400px;">

                        <script>
                            let denominacion = document.getElementById('denominacion').value;
                            let osmUrl = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
                                    osmAttrib = '&copy; <a href="http://openstreetmap.org/copyright">OpenStreetMap</a> contributors',
                                    osm = L.tileLayer(osmUrl, {maxZoom: 18, attribution: osmAttrib});
                            let map = L.map('map').setView([<%=empresa.getLatitud()%>, <%=empresa.getLongitud()%>], 17).addLayer(osm);
                            L.marker([<%=empresa.getLatitud()%>, <%=empresa.getLongitud()%>])
                                    .addTo(map)
                                    .bindPopup("<div class=\"location\"><h3 class=\"txt-clr1\" style=\"color:black\"><small><%=empresa.getDenominacion()%></small></h3><address><dl><dt>Telefono: </dt><dd class=\"phone\" style=\"color:black\"><a href=\"callto:<%=empresa.getTelefono()%>\"><%=empresa.getTelefono()%></a></dd></dl><dl><dt>Domicilio: </dt><dd style=\"color:black\"><%=empresa.getDomicilio()%></dd></dl><dl><dt> E-mail: </dt><dd style=\"color:black\"><a href=\"mailto:<%=empresa.getEmail()%>\"><%=empresa.getEmail()%></a></dd></dl></address></div>")
                                    .openPopup();
                        </script>
                    </div>



                </div>

                <section class="well1">
                    <div class="container"> 
                        <p class="rights">
                            <a href="NoticiaAlta.jsp?idEmpresa=<%=empresa.getId()%>">Agregar Noticia</a>
                            <br>
                            <a href="EmpresaModificacion.jsp?idEmpresa=<%=empresa.getId()%>">Modificar Empresa</a>
                            <br>
                            <a href="ServletEmpresa?idEmpresa=<%=empresa.getId()%>&accion=B">Eliminar Empresa</a>
                            <br>
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


        <!-- </script> -->

    </body>
</html>