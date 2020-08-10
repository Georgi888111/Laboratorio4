import React, { Component } from 'react';
import Card from 'react-bootstrap/Card';

import '../assets/css/home.css';
import {Row,Col } from 'react-bootstrap';
import Blanco from '../assets/images/blanco.jpeg';
import Camion from '../assets/images/camion.png';

class TarjetaInstrumentos extends Component {
    render() {
      
      var envio;
      var envioClass = "";
      var rutaImagen = "";
     
      if (this.props.costoEnvio === "G") {
          envio = "Envío gratis a todo el país";
          envioClass = "EnvioGratis";
          rutaImagen = Camion;
      } else {
          envio = "Costo de Envio Interior de Argentina:$" + this.props.costoEnvio;
          envioClass = "EnvioCosto";
          rutaImagen = Blanco;
        

      }

      function incrementaVendidos(){
       console.log(this.props.cantVendida);
      }
        return (
        <React.Fragment>
         <Card className="tarjeta" border="light">
                    <Row xs={5}>
                        <Col xs={2}>
                            <a href={`detalleInstrumento/${this.props.id}`}>
                            <Card.Img
                                variant="bottom" alt="" 
                                 src={require(`../assets/images/${this.props.imagen.toLowerCase()}`)}
                                
                            /></a>
                        </Col>
                        <Col xs={10}>
                            <Card.Body>
                                <Card.Title className="Title">{this.props.instru}</Card.Title>
                                <Card.Subtitle className="Precio">
                                    ${this.props.precio}
                                </Card.Subtitle>

                                <Card.Text className={envioClass} id="envioPrecio">
                                <img src={rutaImagen} height="20px" width="20px" alt=""></img>{envio}</Card.Text>

                                <Card.Text onClick={incrementaVendidos}>{this.props.cantVendida} vendidos</Card.Text>
                            </Card.Body>
                        </Col>
                    </Row>
                </Card>
          </React.Fragment>
        );
    }
}

export default TarjetaInstrumentos;