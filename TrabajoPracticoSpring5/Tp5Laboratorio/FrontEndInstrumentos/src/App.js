import React, { Component } from "react";
import "./assets/css/App.css";
import { Switch, Route } from "react-router-dom";
import Productos from "./components/Productos";
import Home from "./components/Home";
import Ubicacion from "./components/Ubicacion";
import DetalleProducto from "./components/DetalleProducto";
import Formulario from "./components/Formulario";

class App extends Component {
  render() {
    return (
      <Switch>
        <Route exact path="/" component={Home}></Route>
        <Route exact path="/home" component={Home}></Route>
        <Route exact path="/where" component={Ubicacion}></Route>
        <Route exact path="/productos" component={Productos}></Route>
        <Route
          exact
          path="/detalleProducto/:id"
          component={DetalleProducto}
        ></Route>
        <Route exact path="/formulario/:id" component={Formulario}></Route>
        <Route exact path="/formulario" component={Formulario}></Route>
      </Switch>
    );
  }
}

export default App;
