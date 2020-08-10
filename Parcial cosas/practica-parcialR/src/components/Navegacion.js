import React, { Component } from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import '../assets/css/navegacion.css';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';



//Se importan las cosas que componen el NavBar para que funcione, entre ella boostrap.
//Solo se agregan los que queremos que aparezcan en el navBar
class Navegacion extends Component {

  state = {};

  submitBusqueda() {
    const busqueda = document.getElementById("busqueda").value;
    console.log('El texto buscado es : ', busqueda);
    this.props.datosBusqueda(busqueda);
  };

  render() {
    return (
      <React.Fragment>
        <Navbar className="barraNavegacion">
          <Navbar.Brand href="/">Inicio</Navbar.Brand>
          <Nav className="mr-auto">
            <Nav.Link href="/home">Home</Nav.Link>
            <Nav.Link href="/productos">Platos</Nav.Link>
            <Nav.Link href="/productosInstru">Intrumentos</Nav.Link>
            <Nav.Link href="/paises">Paises</Nav.Link>
            <Nav.Link href="/a">Componente A</Nav.Link>


          </Nav>
          <Form inline>
            <FormControl type="text" placeholder="Search" className="mr-sm-2" id="busqueda" />
            <Button variant="outline-light" type="submit" onClick={() => this.submitBusqueda()}>Search</Button>
          </Form>
        </Navbar>
      </React.Fragment>

    );
  }
}

export default Navegacion;