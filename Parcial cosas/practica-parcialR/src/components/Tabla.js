import React, { Component } from 'react';
import Table from 'react-bootstrap/Table';

class Tabla extends Component {
    render() {
        return (
            <React.Fragment>
                <Table striped bordered hover>
  <thead>
    <tr>
      <th>Nombre</th>
      <th>Region</th>
      <th>Capital</th>
      <th>Poblacion</th>
      <th>Lenguajes</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>{this.props.nombre}</td>
      <td>{this.props.region}</td>
      <td>{this.props.capital}</td>
      <td>{this.props.poblacion}</td>
     
    </tr>
   
  </tbody>
</Table>
            </React.Fragment>
        );
    }
}

export default Tabla;