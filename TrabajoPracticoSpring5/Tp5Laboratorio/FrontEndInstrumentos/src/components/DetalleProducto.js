import React, { Component } from "react";
import TopBar from "./TopBar";
import { instrumentos } from "../datos/instrumentos.json";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import "../assets/css/DetalleProducto.css";
import Camion from "../assets/images/camion.png";
import Blanco from "../assets/images/blanco.jpeg";
import { Instrumento } from "../service/Instrumento";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import imagenInstrumento from "../assets/images/nro1.jpg";

class DetalleProducto extends Component {
  constructor() {
    super();
    this.state = {
      instrumento: [],
    };
    this.instrumentosService = new Instrumento();
   
  }



  componentDidMount() {
    this._isMounted = true;
    const parametroId = this.props.match.params.id;
    this.instrumentosService
      .getInstrumentosxId(parametroId)
      .then((data) => this.setState({ instrumento: data }));
  }

  componentWillUnmount() {
    this._isMounted = false;
  }

  render() {
    //const parametroId = this.props.match.params.id;
    const instrumentoEncontrado = this.state.instrumento;

    if (Object.keys(instrumentoEncontrado).length === 0) {
      return "";
    }

    var envio;
    var envioClass = "";
    var rutaImagen = "";
    var ocultaImagen = "";
    var imagenurl = imagenInstrumento;
  

    if (instrumentoEncontrado.costoEnvio === "G") {
      envio = "Envío gratis";
      envioClass = "EnvioGratis";
      rutaImagen = Camion;
    } else {
      envio =
        "Costo de Envio Interior de Argentina:$" +
        instrumentoEncontrado.costoEnvio;
      envioClass = "EnvioCosto";
      rutaImagen = Blanco;
      var ocultaImagen = "OcultaImagen";
    }
    var stock = "";
    if (instrumentoEncontrado.estaHabilitado) {
      stock = "disponible";
    } else {
      stock = "Sin stock";
    }

    return (
      <React.Fragment>
        <TopBar />
        <div className="Contenedor">
          <Row>
            <div className="descripcion">
              <img className="imagen" src={imagenurl} />
              <br></br>
              <p>
                Descripción:<br></br>
                {instrumentoEncontrado.descripcion};
              </p>
            </div>
            <div className="precioCont">
              <p className="cantVendidos">
                {instrumentoEncontrado.cantidadVendida} vendidos
              </p>
              <h1>{instrumentoEncontrado.instrumento}</h1>
              <p className="precio">${instrumentoEncontrado.precio}</p>
              <p>Marca: {instrumentoEncontrado.marca}</p>
              <p>Modelo: {instrumentoEncontrado.modelo}</p>
              <br></br>
              <p>Costo envío:</p>
              <div className={envioClass} id="envioPrecio">
                <img src={rutaImagen} height="20px" width="20px"></img>
                {envio}
              </div>
              <br></br>
              <p>{stock}</p>
              <Button variant="outline-primary">Agregar al carrito</Button>
            </div>
          </Row>
          
        </div>
      </React.Fragment>
    );
  }
}

export default DetalleProducto;
