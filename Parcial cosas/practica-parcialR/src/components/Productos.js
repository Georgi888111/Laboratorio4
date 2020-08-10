import React, { Component } from 'react';
import {platos} from '../assets/datos/platos.json';
import Tarjeta from './Tarjeta';
import Navigation from './Navegacion';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import '../assets/css/home.css'

//Importar el archivo json con {} para que lo tome como array. En el contructor se especifica el estado inicial 
//de los platos y lo ponemos como state de ese componente.
//en render ponemos las cosas con las que vamos a trabajar, la lógica antes de que se muestre.
//Se asigna a una variable el array que se importó y se recorre asignando un atributo para cada 
//indice del array y se le pasa al componente que lo recibe en su clase y lo renderiza.
class Productos extends Component {

    constructor(){
        super();
        this.state = {
          platos
        }
      }  
    render() {
        const platos = this.state.platos.map((plato, i)=>{
            return ( <Tarjeta key={plato.id}
                              id={plato.id} 
                              nombre={plato.nombre} 
                              precio={plato.precio} 
                              rubro={plato.rubro} 
                              imagenPath={plato.imagenPath}></Tarjeta>)
        
           
            })
            //En el return especificamos como se verá lo que pasamos 
            return (
                <React.Fragment>
                    <Navigation></Navigation>
                    <Container fluid="md" className="fondoPlatos">
                        <Row>
                      {platos}
                        
                        </Row>
                    </Container>
                </React.Fragment>
                );
      
    };
}

export default Productos;