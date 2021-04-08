
import React, { Component } from 'react';
import AuthenticationService from '../../services/AuthenticationService';


class Login extends Component {
    

    handleSubmit = (e) => {
        e.preventDefault();
        const user = {
                username: this.username,
                password: this.password
        }
        AuthenticationService.loginUser(user).then( (res) => {
            localStorage.setItem('token', res.data.token);
            this.props.history.push('/');
        })
    }
    

    render() { 
        return ( 
            <div>
                <div className="container">
                        <form onSubmit={this.handleSubmit}>
                            <h3>Login</h3>
                                <div className="form-group">
                                    <label>username :</label>
                                    <input type="text" className="form-group"
                                        onChange={e => this.username = e.target.value}></input>
                                </div>
                                <div className="form-group">
                                    <label>Password :</label>
                                    <input type="password" className="form-group"
                                        onChange={e => this.password = e.target.value}></input>
                                </div>
                            <button className="btn btn-primary btn-block">Login</button>
                        </form>
                </div>
            </div>
         );
    }
}
 
export default Login;