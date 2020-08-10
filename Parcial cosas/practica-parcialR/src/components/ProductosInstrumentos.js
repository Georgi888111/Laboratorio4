import React, { Component } from 'react';
import {instrumentos} from '../assets/datos/instrumentos.json';
import TarjetaInstrumento from '../components/TarjetaInstrumentos';
import { Container, Row,Col } from 'react-bootstrap';
import Navegacion from './Navegacion';

class ProductosInstrumentos extends Component {
  constructor() {
    super();
    this.state = {
      instrumentos
    }
  }
  render() {
    const instrumentos = this.state.instrumentos.map((instrumento, i) => {
      return (
        <TarjetaInstrumento
          key={instrumento.id}
          id={instrumento.id}
          instru={instrumento.instrumento}
          marca={instrumento.marca}
          modelo={instrumento.modelo}
          imagen={instrumento.imagen}
          precio={instrumento.precio}
          costoEnvio={instrumento.costoEnvio}
          cantVendida={instrumento.cantidadVendida}
          descripcion={instrumento.descripcion}
        ></TarjetaInstrumento>)
    })
    return (
      <React.Fragment>
        <Navegacion />
        <Container>
          <Row>
            <Col>{instrumentos}</Col>
          </Row>
        </Container>
      </React.Fragment>
    );
  };
}
export default ProductosInstrumentos;