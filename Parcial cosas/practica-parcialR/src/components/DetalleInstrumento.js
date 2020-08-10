import React, { Component } from 'react';
import {instrumentos} from '../assets/datos/instrumentos.json';
import Navegacion from '../components/Navegacion';
import { Container } from 'react-bootstrap';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';


class DetalleInstrumento extends Component {
  constructor() {
      super();
    this.state = {
        instrumentos
    }  
  }
  
    render() {
        const parametroId = this.props.match.params.id;
        const instrumentoEncontrado = instrumentos.filter(instrumento => instrumento.id === parametroId);

        return (
            <div>
            <React.Fragment>
                <Navegacion></Navegacion>
                <Container>
                <Row>
                <Col>
                <img alt="" src={require(`../assets/images/${instrumentoEncontrado[0].imagen.toLowerCase()}`)}></img>
                </Col>
                <Col>
                <p>{instrumentoEncontrado[0].cantidadVendida} vendidos</p>  
                <p></p>  
                </Col>
                </Row> 
                <Row>
                    
                </Row>     
                </Container>
            </React.Fragment>
            </div>
        );
    }
}

export default DetalleInstrumento;