import React, { Component } from "react";
import Card from "react-bootstrap/Card";
import Camion from "../assets/images/camion.png";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import "../assets/css/Tarjeta.css";
import Blanco from "../assets/images/blanco.jpeg";
import imagenInstrumento from "../assets/images/nro1.jpg";


class Tarjeta extends Component {
  render() {
 
    var envio;
    var envioClass = "";
    var rutaImagen = "";
    var ocultaImagen = "";
    if (this.props.costoEnvio === "G") {
      envio = "Envío gratis a todo el país";
      envioClass = "EnvioGratis";
      rutaImagen = Camion;
    } else {
      envio = "Costo de Envio Interior de Argentina:$" + this.props.costoEnvio;
      envioClass = "EnvioCosto";
      rutaImagen = Blanco;
      var ocultaImagen = "OcultaImagen";
    }
    return (
      <React.Fragment>
        <Card class="Card" border="light">
          <Row xs={5}>
            <Col xs={2}>
              <a href={`detalleProducto/${this.props.id}`}>
                <Card.Img variant="bottom" src={imagenInstrumento} />
              </a>
            </Col>
            <Col xs={10}>
              <Card.Body>
                <Card.Title class="Title">{this.props.instru}</Card.Title>
                <Card.Subtitle class="Precio">
                  ${this.props.precio}
                </Card.Subtitle>

                <Card.Text className={envioClass} id="envioPrecio">
                  <img src={rutaImagen} height="20px" width="20px"></img>
                  {envio}
                </Card.Text>

                <Card.Text>{this.props.cantVendida} vendidos</Card.Text>
              </Card.Body>
            </Col>
          </Row>
        </Card>
      </React.Fragment>
    );
  }
}

export default Tarjeta;
