import React from "react";
import TopBar from "./TopBar";
import "react-bootstrap";
import fondo from "../assets/images/fondo2.jpg";
import "../assets/css/home.css";

const Home = () => {
  return (
    <div>
      <TopBar />
      <div className="contenedorHome">
        <img src={fondo} alt="" width="100%" height="100%"></img>
        <p className="titulo">
          <strong>Musical Hendrix</strong> es una tienda de instrumentos
          musicales con ya más de 15 años de experiencia.
          <br />
          Tenemos el conocimiento y la capacidad como para informarte acerca de
          las mejores elecciones para tu compra musical.
        </p>
      </div>
    </div>
  );
};

export default Home;
