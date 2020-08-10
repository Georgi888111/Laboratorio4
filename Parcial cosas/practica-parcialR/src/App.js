
import React, {Component} from 'react';
import './assets/css/App.css';
import {Switch, Route } from 'react-router-dom';
import Home from './components/Home';
import Productos from './components/Productos';
import Detalle from './components/Detalle';
import ProductosInstrumentos from './components/ProductosInstrumentos';
import DetalleInstrumento from './components/DetalleInstrumento';
import PaisesApi from './components/PaisesApi';
import DetallePais from './components/DetallePais';
import ComponenteA from './components/ComponenteA';

//App es la base de ntra aplicacion, si queremos usar router podemos especificar acá como será el camino.
//Importar en index.js para el navBar. 
//Importar todos los componentes a los que se va según la ruta que se ponga
//Importar Switch y Route que son las librerias para Router


class App extends Component{
    
  
  render(){
    return(
     
      <Switch>
        <Route exact path="/" component ={Home} ></Route>
        <Route exact path="/home" component={Home} ></Route>
        <Route exact path="/productos" component={Productos} ></Route>
        <Route path="/detalle/:id" component={Detalle} ></Route>
        <Route path="/productosInstru" component={ProductosInstrumentos} ></Route>
        <Route path="/detalleInstrumento/:id" component={DetalleInstrumento} ></Route>
        <Route path="/paises" component={PaisesApi} ></Route>
        <Route path="/detallePais/:callingCode" component={DetallePais} ></Route>
        <Route path="/a" component={ComponenteA} ></Route>

      </Switch>
      
    ); 
  }
}

export default App;