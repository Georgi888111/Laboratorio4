import React, { Component } from 'react';
import axios from 'axios';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Navegacion from '../components/Navegacion';

class DetallePais extends Component {
    _isMounted = false;
    constructor() {
        super();
       this.state = ({

        paisEncontrado: []
       });
    }
    
    componentDidMount(){
        this._isMounted = true;
        this.getPaisXId();
        
    }
    
    componentWillUnmount(){
        this._isMounted = false;
    }
    
    getPaisXId(){
        const parametroId = this.props.match.params.callingCode;
       
        axios.get('https://restcountries.eu/rest/v2/callingcode/' + parametroId)
        .then(res => {
            const pais = res.data;
            this.setState({ paisEncontrado:pais });
            
           
          })
      
        
       }   
    
    
    render() {
        
            
         
        return (

             
            <div>
            <Navegacion></Navegacion>
              <Row>
              <Col>
              <img alt="" src={require('../assets/images/descarga.jpg')} width="100%" height="100%" />
              </Col>
              <Col>
              {this.state.paisEncontrado.map((pais,i)=>{
                   return(
                       <p key={i}>{pais.name}</p>
                      
                   )
              })
              }
              </Col>
             
            
              </Row>
            </div>
       
             )
         }  
        
    }


export default DetallePais;