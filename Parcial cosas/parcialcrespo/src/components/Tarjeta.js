import React, { Component } from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import '../assets/css/App.css';

import { Row, Col } from 'react-bootstrap';

class Tarjeta extends Component {
    render() {
        return (
            <React.Fragment>
                <Card className="tarjeta" >
                    <Row xs={3}>
                        <Col xs={2} className="divCol2">
                            <Card.Title style={{color: 'green'}}>{this.props.nombre}</Card.Title>
                            <Card.Img
                                variant="bottom" alt=""
                                src={require(`../assets/images/${this.props.img.toLowerCase()}`)}

                            />
                            <div className="divBoton">
                            <a href={`detalle/${this.props.id}`}><Button variant="primary">Detalle</Button></a>
                            </div>
                        </Col>
                        <Col xs={8} className="divCol8">
                        <Card.Title style={{color: 'red'}}>Poderes</Card.Title>
                            <Card.Body>
                                

                                <Card.Text >
                                 {this.props.poderes.map((poder,i)=>{
                                  return(<li key ={i}>{poder}</li>)   
                                 })}
                                </Card.Text>





                            </Card.Body>
                        </Col>
                    </Row>
                </Card>
            </React.Fragment>
        );
    }
}

export default Tarjeta;