import React from "react";
import TopBar from "./TopBar";
import Mapa from "./Map";
import "../assets/css/Ubicacion.css";

const Ubicacion = () => {
  return (
    <div className="location">
      <TopBar />
      <div className="contenedor">
        Donde estamos
        <Mapa />
      </div>
    </div>
  );
};

export default Ubicacion;
