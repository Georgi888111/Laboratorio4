import React, { Component } from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';

//Importar todas las cosas que usa boostrap
//En el return (envuelto en un <React.Fragment> ponemos lo que queremos que se vea en la vista)
//En las partes donde queremos modificar el contenido agregamos {this.props.nombreDeLoQueLeMandamos} para acceder
//a las props del objeto que le mandamos en la vista.

class Tarjeta extends Component {
    render() {
        return (
            <React.Fragment>
              <Card style={{ width: '18rem' }}>
              <Card.Img variant="bottom" width='175px' height='175px' src={require(`../assets/images/${this.props.imagenPath.toLowerCase()}`)} />
              <Card.Body>
              <Card.Title>{this.props.nombre}</Card.Title>
              <Card.Text>
              {this.props.precio}
             </Card.Text>
             <Button href={`detalle/${this.props.id}`} variant="primary">Detalle</Button>
             </Card.Body>
             </Card>  
            </React.Fragment>
        );
    }
}

export default Tarjeta;