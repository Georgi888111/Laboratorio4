/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function enviarDatos(btn) {
    if (verificarCampos()) {
        /*   let datos = tomarDatos();
         if (tomarAccion(btn) == 1) {
         datos.shift();
         }*/
        document.getElementById('formNoticia').submit();
    }
}

function tomarDatos() {
    let id = document.getElementById('id').value;
    let titulo = document.getElementById('titulo').value;
    let resumen = document.getElementById('resumen').value;
    let imagen = document.getElementById('imagen').value;
    let contenido = document.getElementById('contenido').value;
    let fecha = document.getElementById('fecha').value;
    let idEmpresa = document.getElementById('idEmpresa').value;

    let datos = new Array(7);
    datos[0] = id;
    datos[1] = titulo;
    datos[2] = resumen;
    datos[3] = imagen;
    datos[4] = contenido;
    datos[5] = fecha;
    datos[6] = idEmpresa;

    return datos;
}

function verificarCampos() {
    let datos = tomarDatos();

    for (let i = 0; i < datos.length; i++) {
        if (datos[i] == '' || datos[i] == null) {
            alert("Recuerde rellenar todos los campos");
            return false;
        }
    }
    return true;
}
