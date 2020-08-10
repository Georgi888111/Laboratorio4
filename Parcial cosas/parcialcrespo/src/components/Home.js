import React, { Component } from 'react';
import Navegacion from './Navegacion';
import heroes from '../assets/datos/heroes.json';
import Tarjeta from '../components/Tarjeta';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import { Col } from 'react-bootstrap';


class Home extends Component {

    constructor(){
        super();
        this.state = {
          heroes,
          filtro: "",
        }
      }  
      render() {
        const parametro = this.props.match.params.casa;
        console.log(parametro);
        
        
        const heroes = this.state.heroes.map((heroe, i)=>{
            return ( <Tarjeta key={heroe.id}
                              id={heroe.id} 
                              nombre={heroe.nombre} 
                              poderes={heroe.poderes} 
                              bio={heroe.bio} 
                              img={heroe.img}
                              aparicion={heroe.aparicion}
                              casa={heroe.casa}
                              ></Tarjeta>)
        
           
            })
            
            return (
                <React.Fragment>
                    <Navegacion></Navegacion>
                    <Container fluid="md" className="fondoPlatos">
                        <Row>
                        <Col>
                      {heroes}
                      </Col>
                        </Row>
                    </Container>
                </React.Fragment>
                );
      
    };
}
export default Home;