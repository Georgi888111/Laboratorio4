import React, { Component } from 'react';
import axios from 'axios';
import Table from 'react-bootstrap/Table'
import Navegacion from './Navegacion';


class PaisesApi extends Component {
    _isMounted = false;
    constructor() {
        super();
        this.state = ({
            paises:[],
        });
    }
    
    componentDidMount(){
        this._isMounted = true;
        this.getPaises();   
    }
    componentWillUnmount(){
        this._isMounted = false;
       
      }
      getPaises(){
        axios.get('https://restcountries.eu/rest/v2/')
        .then(res => {
            const paises = res.data;
            console.log(paises);
            this.setState({ paises });
          })
      
        
       }   
      
    render() {
        return (
    <React.Fragment> 
    <Navegacion></Navegacion>    
    <Table responsive="sm">
    <thead>
      <tr>
       
        <th>Nombre</th>
        <th>Region</th>
        <th>Capital</th>
        <th>Poblacion</th>
        <th>Lenguajes</th>
       </tr>
    </thead>
    <tbody>{this.state.paises.slice(0,10).map((pais,i)=>{
      return(
      <tr key = {pais.callingCodes}>
      <a href={`detallePais/${pais.callingCodes}`}><td>{pais.name}</td></a>
      <td>{pais.region}</td>
      <td>{pais.capital}</td>
      <td>{pais.population}</td>
      <td>{pais.languages.map((language,i)=>{
          return( <li key={i}>{language.name}</li>)
      })}</td>
     
      </tr>
      )
    
    })}</tbody>
  </Table>
  </React.Fragment>   
        ) 
        }
      }

export default PaisesApi;