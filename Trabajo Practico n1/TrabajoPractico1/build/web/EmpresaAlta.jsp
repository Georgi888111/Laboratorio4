<%-- 
    Document   : EmpresaAlta
    Created on : 21 mar. 2020, 21:34:17
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gest&oacute;n de datos institucionales</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="JS/ScriptsEmpresa.js"></script>
        <script type="text/javascript" src="JS/ScriptsGenerales.js"></script>
    </head>

    <body>
        <h1>Carga de datos de la empresa</h1>
        <form id="formEmpresa" action="http://localhost:8080/TrabajoPractico1/ServletEmpresa" onsubmit="return enviarDatos();">
            <table>
                <tr>
                    <td>Denominaci&oacute;n</td>
                    <td><input type="text" name="denominacion" id="denominacion" maxlength="128" size="36"
                               placeholder="Nombre de fantas&iacute;a de su empresa"></td>
                </tr>
                <tr>
                    <td>Tel&eacute;fono</td>
                    <td><input type="tel" name="telefono" id="telefono" maxlength="50" size="36" placeholder="Tel&eacute;fono de su empresa">
                    </td>
                </tr>
                <tr>
                    <td>Horario de inicio de atenci&oacute;n</td>
                    <td>
                        <input type="time" name="horaI" id="horaI" size="25"><br>
                    </td>
                </tr>

                <tr>
                    <td>Horario de fin de atenci&oacute;n</td>
                    <td>
                        <input type="time" name="horaF" id="horaF" size="25">
                    </td>
                </tr>
                <tr>
                    <td>Quiénes somos</td>
                    <td><textarea id="descripcion" name="descripcion" maxlength="1024" rows="4" cols="28"
                                  placeholder="Una descripci&oacute;n de su empresa" style="resize: none"></textarea></td>
                </tr>
                <tr>
                    <td>Latitud</td>
                    <td><input id="latitud" name="latitud" type="text" size="36" placeholder="Latitud de la ubicaci&oacute;n"></td>
                </tr>
                <tr>
                    <td>Longitud</td>
                    <td><input id="longitud" name="longitud" type="text" size="36" placeholder="Longitud de la ubicaci&oacute;n"></td>
                </tr>
                <tr>
                    <td>Domicilio</td>
                    <td><input id="domicilio" name="domicilio" type="text" maxlength="256" size="36" placeholder="Domicilio de su empresa">
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input id="email" name="email" type="email" maxlength="75" size="36"
                               placeholder="E-mail de contacto de la empresa"></td>
                </tr>
            </table>
            <br>
            <button type="submit" name="accion" id="A" value="A">Alta</button>
        </form>
    </body>
</html>