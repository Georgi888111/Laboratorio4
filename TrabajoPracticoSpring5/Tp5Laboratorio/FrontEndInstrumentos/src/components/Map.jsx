import React from "react";
import "../assets/css/ss.css";

const Mapa = () => {
  return (
    <iframe
      class="gMap"
      src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3344.1260718696176!2d-68.55775388506241!3d-33.05314758461693!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x967e698e8ef0f277%3A0xe83fc184d183c106!2sSan%20Mart%C3%ADn%20%26%20Las%20Heras%2C%20San%20Mart%C3%ADn%2C%20Mendoza!5e0!3m2!1ses-419!2sar!4v1587339316593!5m2!1ses-419!2sar"
      frameborder="0"
      allowfullscreen="false"
      aria-hidden="false"
      tabindex="0"
    ></iframe>
  );
};

export default Mapa;
