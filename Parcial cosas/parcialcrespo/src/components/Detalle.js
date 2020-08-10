import heroes from '../assets/datos/heroes.json';
import React, { Component } from 'react';
import Navegacion from './Navegacion';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Nav from 'react-bootstrap/Nav';
import '../assets/css/App.css';

class Detalle extends Component {

    constructor(){
        super();
        this.state = {
          heroes
        }
      }
      render(){
        console.log(this.props);
         const parametroId = this.props.match.params.id;
         const heroeEncontrado = heroes.filter(heroe => heroe.id === parametroId);
         console.log(heroeEncontrado);
         const poderes = heroeEncontrado[0].poderes.map((poder, i)=>{return (
             <li key={i}>{poder}</li>
           )
         })
         return (
             <React.Fragment>
                 <Navegacion></Navegacion>
                 <Container className="detalle">
                 <Row>
                     <Col><img  className="imagenSuper" alt="" src={require(`../assets/images/${heroeEncontrado[0].img.toLowerCase()}`)} /></Col>
                     <Col>
                         <Row>
                             <Col><h1>{heroeEncontrado[0].nombre}</h1></Col>
                         </Row>
                         <Row>
                             <Col></Col>
                         </Row>
                         <Row>
                             <Col>Aparicion: <h2> {heroeEncontrado[0].casa} {heroeEncontrado[0].aparicion}</h2>
                                  
                             </Col>
                         </Row>
                         <Row>
                             <Col>
                             
                            
                             <div>Biografia: {heroeEncontrado[0].bio}</div>

                             <div className="divPoderes">Poderes:{poderes}</div>
                             <Nav.Link href="/home"><p className="volver">Volver</p></Nav.Link>
                             </Col>
                         </Row>
                     </Col>
                 </Row>
                 
                 <Row>
                    
                 </Row>                
                 </Container>
             </React.Fragment>
             
         );
 
     }
 }
 
 export default Detalle;