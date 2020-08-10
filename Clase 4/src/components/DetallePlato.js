import React, {Component} from 'react';
import {platos} from '../datos/platos.json';
import Navigation from './Navigation';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Nav from 'react-bootstrap/Nav';

class DetallePlato extends Component{
    
    constructor(){
        super();
        this.state = {
          platos
        }
      }

    render(){
       console.log(this.props);
        const parametroId = this.props.match.params.id;
        const platoEncontrado = platos.filter(plato => plato.id === parametroId);
        const ingredientes = platoEncontrado[0].ingredientes.map((ingrediente, i)=>{return (
            <li key={i}>{ingrediente}</li>
          )
        })
        return (
            <React.Fragment>
                <Navigation></Navigation>
                <Container>
                <Row>
                    <Col><img className="minAltoImg" src={require(`../assets/images/${platoEncontrado[0].imagenPath.toLowerCase()}`)} /></Col>
                    <Col>
                        <Row>
                            <Col><h1>{platoEncontrado[0].nombre}</h1></Col>
                        </Row>
                        <Row>
                            <Col>Precio: <h2>${platoEncontrado[0].precio}</h2></Col>
                        </Row>
                        <Row>
                            <Col>Rubro: <h2>{platoEncontrado[0].rubro}</h2></Col>
                        </Row>
                        <Row>
                            <Col>Ingredientes:{ingredientes}</Col>
                        </Row>
                    </Col>
                </Row>
                
                <Row>
                    <Col><Nav.Link href="/home"><h3>Volver</h3></Nav.Link></Col>
                </Row>                
                </Container>
            </React.Fragment>
            
        );

    }
}

export default DetallePlato;