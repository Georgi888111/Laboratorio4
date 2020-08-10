import React, { Component } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import '../assets/css/App.css';
import Navegacion from './Navegacion';

class ComponenteA extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email:'',
            password:''
        }

    }

      cambioEnEmail(email){
          console.log(email);
        this.setState({email:email})
      }

      submitForm(){
      console.log(this.state);
      }
    render() {
        return (
            <React.Fragment>
                <Navegacion></Navegacion>
                <div className="formContenedor">
                    <Form className="formularioA">
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control type="email" value={this.state.email} placeholder="Enter email" onChange={(ev)=>{this.cambioEnEmail(ev.target.value)}}/>
                            <Form.Text className="text-muted">
                                We'll never share your email with anyone else.
    </Form.Text>
                        </Form.Group>

                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" value={this.state.password} placeholder="Password" autoComplete="on" />
                        </Form.Group>
                        <Form.Group controlId="formBasicCheckbox">
                            <Form.Check type="checkbox" label="Check me out" />
                        </Form.Group>
                        <Button variant="primary" type="submit" onClick={()=> this.submitForm()}>
                            Submit
  </Button>
                    </Form>
                </div>
            </React.Fragment>
        );
    }
}

export default ComponenteA;