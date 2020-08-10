import axios from "axios";

export class Instrumento {
  baseUrl = "http://localhost:9001/api/v1/instrumento";

  getInstrumentos() {
    return axios
      .get(this.baseUrl + "/")
      .then((res) => res.data)
      .catch((error) => {
        console.log(error);
      });
  }

  getInstrumentosAllAll() {
    return axios
      .get(this.baseUrl + "/all")
      .then((res) => res.data)
      .catch((error) => {
        console.log(error);
      });
  }

  getInstrumentosxId(id) {
    return axios
      .get(this.baseUrl + "/" + id)
      .then((res) => res.data)
      .catch((error) => {
        //   alert("Error en la consulta a la base de datos");
        console.log(error);
      });
  }

  save(instrumento) {
    return axios
      .post(this.baseUrl + "/", instrumento)
      .then((res) => res.data)
      .catch((error) => {
        //   alert("Error en la consulta a la base de datos");
        console.log(error);
      });
  }

  update(instrumento, id) {
    return axios
      .put(this.baseUrl + "/" + id, instrumento)
      .then((res) => res.data)
      .catch((error) => {
        //   alert("Error en la consulta a la base de datos");
        console.log(error);
      });
  }

  delete(id) {
    return axios.delete(this.baseUrl + "/" + id).then((res) => res.data);
  }
}
export default Instrumento;
