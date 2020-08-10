import React, { Component } from "react";
import TopBar from "./TopBar";

import "../assets/css/formulario.css";

import { Instrumento } from "../service/Instrumento";
import { Table, Button, ButtonGroup } from "reactstrap";
import { Modal, ModalHeader, ModalBody, ModalFooter, Alert } from "reactstrap";
import { Form, FormGroup, Label, Input } from "reactstrap";

class Formulario extends Component {
  constructor() {
    super();

    this.state = {
      visible: false,
      accion: null,
      idSeleccionado: null,
      selected: [ ],
      instrumentoState: { 
        id: 0,
        instrumento: "",
        marca: "",
        modelo: "",
        precio: "",
        precioEnvio: "",
        cantidadVendida: "",
        descripcion: "",
        urlImagen: "",
        estaHabilitado: true,
      },
      instrumentos: [],
      idEdit:0,
    };
    this.onCheck = this.onCheck.bind(this);
   this.doParentControl = (name, selected) => {
      console.log('doParentControl name: ',name);
      console.log('doParentControl selected: ',selected);
      this.setState({ name: name, selected: selected })
   }
    this.instrumentoService = new Instrumento();
    this.handleChange = this.handleChange.bind(this);
    this.showEditDialog = this.showEditDialog.bind(this);
    this.showSaveDialog = this.showSaveDialog.bind(this);
  }

  componentDidMount() {
    this.instrumentoService
      .getInstrumentosAllAll()
      .then((res) => this.setState({ instrumentos: res }));
  }

  componentWillUnmount() {
    this._isMounted = false;
  }

  onCheck(e) {
    let i = e.indexof(e);
    this.setState({ rBtnSelected: i });
  }

  showSaveDialog() {
    console.log("show save dialog");  
    this.setState({
      visible: true,
      accion: "insertar",
      instrumento: {
        instrumento: null,
        marca: null,
        modelo: null,
        precio: null,
        descripcion: null,
        imagen: null,
        cantidadVendida: null,
        estaHabilitado: null,
        precioEnvio: null,
      },
    });
  }

  

  

  showEditDialog(e) {
    console.log("show update dialog");
    this.setState({
      visible: true,
      accion: "actualizar",
      idSeleccionado: e.target.id,
    });
    console.log(e.target.id);
    this.instrumentoService
      .getInstrumentosxId(e.target.id)
      .then((data) => this.setState({ instrumentoState: data }));
  }

  handleChange(event) {
    let variable = event.target.id;
    let valor = event.target.value;
    var instru = this.state.instrumentoState;    
    if (variable === "urlImagen") {
      valor = event.target.value.slice(12);
    }else if(variable === "precioEnvio" && valor ==="0"){        
          valor="G";        
    }
    instru[variable]=valor;
    this.setState({instru});

  }

  delete(e) {    
    const parametroId = e.target.id;
    //console.log(parametroId);
    const ins = new Instrumento();
    ins.delete(parametroId);
      window.location.reload();      
  }; 


  render() {
    
    const onSave = () => {
      this.setState({ visible: false });
      if (this.state.accion === "insertar") {
        console.log(this.state.accion);
        console.log(this.state.instrumentoState);
        
        this.instrumentoService.save(this.state.instrumentoState);
      } else if (this.state.accion === "actualizar") {
        console.log(this.state.accion);
        console.log(this.state.instrumentoState);
        this.instrumentoService.update(this.state.instrumentoState, this.state.instrumentoState.id);
      }
      window.location.reload();
    };

   
  
    return (
      <div style={{ width: "90%", margin: "0 auto", marginTop: "20px" }}>
        <section>
          <TopBar />
          <br />
          <Button onClick={this.showSaveDialog}>Nuevo</Button>
          <Table striped hover responsive>
            <thead>
              <tr>
                <th>Seleccionar</th>
                <th>Instrumento</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Precio</th>
                <th>Descripcion</th>
                <th>Imagen</th>
                <th>Vendidos</th>
                <th>Stock</th>
                <th>Costo de Envio</th>
              </tr>
            </thead>
            <tbody>
              {this.state.instrumentos.map((instrumento, i) => {
                return (
                  <tr>
                    <td> <Button id={i+1} onClick={this.showEditDialog} style={{margin:"5px"}}>
                          Editar
                        </Button> &nbsp;
                        <Button id={i+1} onClick={this.delete}>
                          Eliminar
                        </Button></td>                       
                    
                    <td>{instrumento.instrumento}</td>
                    <td>{instrumento.marca}</td>
                    <td>{instrumento.modelo}</td>
                    <td>{instrumento.precio}</td>
                    <td>{instrumento.descripcion}</td>
                    <td>{instrumento.imagen}</td>
                    <td>{instrumento.cantidadVendida}</td>
                    <td>{instrumento.estaHabilitado ? "SI" : "NO"}</td>
                    <td>{instrumento.precioEnvio}</td>
                  </tr>
                );
              }

              )}
            </tbody>
          </Table>
        </section>
        <section>
          <Modal isOpen={this.state.visible} footer={this.confirmarBtn}>
            <ModalHeader>Insertar Instrumento</ModalHeader>
            <ModalBody>
              <Form id="form">
                <span className="p-float-label">
                  <FormGroup>
                    <Input
                      type="hidden"
                      value={this.state.instrumentoState.id}
                      style={{ width: "100%" }}
                      id="id"
                      onChange={this.handleChange}
                    />
                  </FormGroup>
                </span>
                <span className="p-float-label">
                  <FormGroup>
                    <Label htmlFor="instrumento">Nombre</Label>
                    <Input
                      type="text"
                      defaultValue={this.state.instrumentoState.instrumento}
                      style={{ width: "100%" }}
                      id="instrumento"
                      onChange={this.handleChange}
                    />
                  </FormGroup>
                </span>

                <br />

                <span className="p-float-label">
                  <FormGroup>
                    <Label htmlFor="marca">Marca</Label>
                    <Input
                      type="text"
                      defaultValue={this.state.instrumentoState.marca}
                      style={{ width: "100%" }}
                      id="marca"
                      onChange={this.handleChange}
                    />
                  </FormGroup>
                </span>

                <br />

                <span className="p-float-label">
                  <FormGroup>
                    <Label>Modelo</Label>
                    <Input
                      type="text"
                      defaultValue={this.state.instrumentoState.modelo}
                      style={{ width: "100%" }}
                      id="modelo"
                      onChange={this.handleChange}
                    />
                  </FormGroup>
                </span>

                <br />

                <span className="p-float-label">
                  <FormGroup>
                    {" "}
                    <Label>Precio</Label>
                    <Input
                      type="number"
                      defaultValue={this.state.instrumentoState.precio}
                      style={{ width: "100%" }}
                      id="precio"
                      onChange={this.handleChange}
                    />
                  </FormGroup>
                </span>

                <br />

                <span className="p-float-label">
                  <FormGroup>
                    {" "}
                    <Label>Descripcion</Label>
                    <Input
                      type="textarea"
                      defaultValue={this.state.instrumentoState.descripcion}
                      style={{ width: "100%" }}
                      id="descripcion"
                      onChange={this.handleChange}
                    />
                  </FormGroup>
                </span>

                <br />

                <span className="p-float-label">
                  <FormGroup>
                    <Label>Costo de Envio</Label>
                    <Input
                      type="text"
                      defaultValue={this.state.instrumentoState.precioEnvio}
                      style={{ width: "100%" }}
                      id="precioEnvio"
                      onChange={this.handleChange}
                    />
                  </FormGroup>
                </span>

                <br />

                <span className="p-float-label">
                  <FormGroup>
                    <Label>Imagen Representativa</Label>
                    <Input
                      type="file"
                      accept=".jpg, .jpeg, .png"
                      style={{ width: "100%" }}
                      id="urlImagen"
                      src={this.state.instrumentoState.urlImagen}
                      onChange={this.handleChange}
                    />
                  </FormGroup>
                </span>

                <br />

                <span className="p-float-label">
                  <FormGroup>
                    <Label>Cantidad Vendida</Label>
                    <Input
                      type="number"
                      defaultValue={this.state.instrumentoState.cantidadVendida}
                      style={{ width: "100%" }}
                      id="cantidadVendida"
                      onChange={this.handleChange}
                    />
                  </FormGroup>
                </span>

                <br />
              </Form>
            </ModalBody>
            <ModalFooter>
              <Button
                color="primary"
                onClick={() => {
                  onSave();
                }}
              >
                Aceptar
              </Button>
              <Button
                color="secondary"
                onClick={() => {
                  this.setState({
                    visible: false,
                  });
                }}
              >
                Cancelar
              </Button>
            </ModalFooter>
          </Modal>
        </section>
      </div>
      
    );
  }
}

export default Formulario;
