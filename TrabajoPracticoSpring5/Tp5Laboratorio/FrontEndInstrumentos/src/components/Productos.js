import React, { Component } from "react";
import Tarjeta from "./Tarjeta";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import TopBar from "./TopBar";
import { Instrumento } from "../service/Instrumento";

class Productos extends Component {
  _isMounted = false;

  constructor() {
    super();
    this.state = {
      db: [],
    };
    this.instrumentosService = new Instrumento();
  }

  componentDidMount() {
    this.instrumentosService
      .getInstrumentos()
      .then((data) => this.setState({ db: data }));
  }

  componentWillUnmount() {
    this._isMounted = false;
  }

  render() {
    const instrumentos = this.state.db.map((instrumento, i) => {
      return (
        <Tarjeta
          key={instrumento.id}
          id={instrumento.id}
          instru={instrumento.instrumento}
          marca={instrumento.marca}
          modelo={instrumento.modelo}
          imagen={instrumento.urlImagen}
          precio={instrumento.precio}
          costoEnvio={instrumento.precioEnvio}
          cantVendida={instrumento.cantidadVendida}
          descripcion={instrumento.descripcion}
        ></Tarjeta>
      );
    });

    return (
      <React.Fragment>
        <TopBar />
        <Container>
          <Row>
            <Col>{instrumentos}</Col>
          </Row>
        </Container>
      </React.Fragment>
    );
  }
}

export default Productos;
