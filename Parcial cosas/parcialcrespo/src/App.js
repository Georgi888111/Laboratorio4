
import React, {Component} from 'react';
import './assets/css/App.css';
import {Switch, Route } from 'react-router-dom';
import Home from './components/Home';
import Detalle from './components/Detalle';


class App extends Component{
    
  
  render(){
    return(
     
      <Switch>
        <Route exact path="/" component ={Home} ></Route>
        <Route exact path="/home" component={Home} ></Route>
        <Route path="/detalle/:id" component={Detalle} ></Route>
        
        

      </Switch>
      
    ); 
  }
}

export default App;