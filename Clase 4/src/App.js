import React, {Component} from 'react';
import Home from './components/Home';
import { Switch, Route } from 'react-router-dom';
import Cliente from './components/Cliente';
import Cocina from './components/Cocina';
import DetallePlato from './components/DetallePlato';

class App extends Component{
    
  
  render(){
    return(
      <Switch>
        <Route exact path="/" component={Home} ></Route>
        <Route exact path="/home" component={Home} ></Route>
        <Route path="/cocina" component={Cocina} ></Route>
        <Route path="/cliente" component={Cliente} ></Route>
        <Route path="/detallePlato/:id" component={DetallePlato} ></Route>
      </Switch>
    ) 
  }
}

export default App;