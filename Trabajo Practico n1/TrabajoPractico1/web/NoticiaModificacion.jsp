<%-- 
    Document   : NoticiaBm
    Created on : 21 mar. 2020, 21:36:23
    Author     : franc
--%>

<%@page import="Modelo.Noticia"%>
<%@page import="Modelo.Empresa"%>
<%@page import="Controlador.ServletNoticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gesti&oacute;n de noticias institucionales</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="JS/ScriptsNoticia.js"></script>
        <script src="JS/ScriptsGenerales.js"></script>
        <script src="https://cdn.tiny.cloud/1/dbexawxwbfj0s1e11togop4bo8d37uhedmby9exdz4oaz162/tinymce/5/tinymce.min.js"></script>
        <script>tinymce.init({selector: 'textarea'});</script>
    </head>
    <body>
        <%
            ServletNoticia noti = new ServletNoticia();
            int id = Integer.valueOf(request.getParameter("idNoticia"));
            Empresa empresa = noti.traeEmpresaXidNot(id);
            Noticia noticia = noti.traeNoticia(id);
        %>
        <h1>Gestione sus noticias</h1>
        <input type="hidden" name="idEmpresa" value="">
        <form id="formNoticia" action="http://localhost:8080/TrabajoPractico1/ServletNoticia" 
              onsubmit="return enviarDatos();">
            <table>
                <tr>
                    <td>T&iacute;tulo</td>
                    <td><input type="text" name="titulo" id="titulo" maxlength="128" placeholder="T&iacute;tulo de la noticia" size="36"></td>
                </tr>
                <tr>
                    <td>Resumen</td>
                    <td><input type="text" name="resumen" id="resumen" maxlength="1024" placeholder="Resumen de la noticia" size="36"></td>
                </tr>
                <tr>
                    <td>Imagen</td>
                    <td><input type="file" name="imagen" id="imagen" accept="image/*" size="36"></td>
                </tr>
                <tr>
                    <td>Contenido HTML</td>
                    <td><textarea name="contenido" id="contenido" maxlength="20480" rows="4" cols="28" 
                                  placeholder="Contenido HTML" style="resize: none"></textarea></td>
                </tr>
                <tr>
                    <td>¿Fue Publicada?</td>
                    <td><input type="checkbox" name="publicada" id="publicada" size="36"></td>
                </tr>
                <tr>
                    <td>Fecha de Publicaci&oacute;n</td>
                    <td><input type="date" name="fecha" id="fecha" size="36"></td>
                </tr>

            </table>
            <br>
            <input type="hidden" name="idEmpresa" value="<%=empresa.getId()%>">
            <input type="hidden" name="idNoticia" value="<%=noticia.getId()%>">
            <button type="submit" name="accion" value="M">Modificaci&oacute;n</button>
        </form>
    </body>
</html>
