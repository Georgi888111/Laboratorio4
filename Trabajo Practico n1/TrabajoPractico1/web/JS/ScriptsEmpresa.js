/**
 * 
 * 
 */

function tomarDatos() {
    let id = document.getElementById('id').value;
    let denominacion = document.getElementById('denominacion').value;
    let telefono = document.getElementById('telefono').value;
    let horaI = document.getElementById('horaI').value;
    let horaF = document.getElementById('horaF').value;
    let descripcion = document.getElementById('descripcion').value;
    let latitud = document.getElementById('latitud').value;
    let longitud = document.getElementById('longitud').value;
    let domicilio = document.getElementById('domicilio').value;
    let email = document.getElementById('email').value;

    let datos = new Array(10);
    datos[0] = id;
    datos[1] = denominacion;
    datos[2] = telefono;
    datos[3] = horaI;
    datos[4] = horaF;
    datos[5] = descripcion;
    datos[6] = latitud;
    datos[7] = longitud;
    datos[8] = domicilio;
    datos[9] = email;
    return datos;
}

function verificarCampos() {
    let datos = tomarDatos();
    let alertas = '';
    for (let i = 0; i < datos.length; i++) {
        if (datos[i] == '' || datos[i] == null) {
            alertas += "Recuerde rellenar todos los campos\n";
            break;
        }
    }
    if (!validarEmail(datos[9])) {
        alertas += "El email ingresado no tiene el formato adecuado";
    }

    if (alertas != '') {
        alert(alertas);
        return false;
    }
    return true;
}

function validarEmail(mail)
{
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        return true;
    }
    return false;
}