/**
 * 
 * 
 */

function enviarDatos(btn) {
    if (verificarCampos()) {
        /*   let datos = tomarDatos();
         if (tomarAccion(btn) == 1) {
         datos.shift();
         }*/
        document.getElementById('formEmpresa').submit();
    }
}

function tomarDatos() {
    let id = document.getElementById('id').value;
    let denominacion = document.getElementById('denominacion').value;
    let telefono = document.getElementById('telefono').value;
    let horaI = document.getElementById('horaI').value;
    let horaF = document.getElementById('horaF').value;
    let horario = horaI.concat(' - ').concat(horaF);
    let descripcion = document.getElementById('descripcion').value;
    let latitud = document.getElementById('latitud').value;
    let longitud = document.getElementById('longitud').value;
    let domicilio = document.getElementById('domicilio').value;
    let email = document.getElementById('email').value;

    let datos = new Array(9);
    datos[0] = id;
    datos[1] = denominacion;
    datos[2] = telefono;
    datos[3] = horario;
    datos[4] = descripcion;
    datos[5] = latitud;
    datos[6] = longitud;
    datos[7] = domicilio;
    datos[8] = email;
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
    if (!validarEmail(datos[8])) {
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

/*function formatearHora(hI, mI, hF, mF) {
 if (hI < 10) {
 hI = "0".concat(hI);
 }
 if (mI < 10) {
 mI = "0".concat(mI);
 }
 if (hF < 10) {
 hF = "0".concat(hF);
 }
 if (mF < 10) {
 mF = "0".concat(mF);
 }
 return hI + ":" + mI + " - " + hF + ":" + mF;
 }*/