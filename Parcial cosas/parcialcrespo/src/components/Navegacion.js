import React, { Component } from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import '../assets/css/App.css';




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
            <Nav.Link href="/home/casa:DC">Heroes DC</Nav.Link>
            <Nav.Link href="/home/casa:Marvel">Heroes Marvel</Nav.Link>
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