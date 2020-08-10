import React, { Component } from 'react';
import '../assets/css/home.css';
import Navegacion from './Navegacion';
import "react-bootstrap";
import fondo from '../assets/images/fondo.jpg';

class Home extends Component {
    render() {
        
        return (
            <React.Fragment>
            <Navegacion></Navegacion>
            <div className="homeEstilo">
            <img src={fondo} alt="" width="100%" height="100%"></img>
            </div>
            </React.Fragment>
        );
    }
}

export default Home;