
import React, { Component } from 'react';
import UserService from '../../services/UserService';

class CreateUserComponent extends Component {
    constructor(props) {
        super(props);
        this.state = { 
                    username: "",
                    password: ""  
         }
         this.changeUsernameHandler = this.changeUsernameHandler.bind(this);
         this.changePasswordHandler = this.changePasswordHandler.bind(this);
         this.createUser = this.createUser.bind(this);
         this.cancel = this.cancel.bind(this);
    }

    changeUsernameHandler = (event) => {
        this.setState( {username: event.target.value} );
    }
    changePasswordHandler = (event) => {
        this.setState( {password: event.target.value} )
    }

    createUser = (event) => {
        event.preventDefault();
        let user = {username: this.state.username, password: this.state.password};
        UserService.createUser(user).then( response => {
            this.props.history.push('/admin');
            } 
        );
    }

    cancel() {
        this.props.history.push('/admin');
    }

    render() { 
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card-col-md-6 offset-md-3">
                            <h3 className="text-center">Create User</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Username : </label>
                                            <input name="username" className="form-control"
                                            value={this.state.username} onChange={this.changeUsernameHandler}>
                                            </input>
                                    </div>
                                    <div className="form-group">
                                        <label>Password : </label>
                                            <input name="password" className="form-control"
                                            value={this.state.password} onChange={this.changePasswordHandler}>
                                            </input>
                                    </div>
                                    <button className="btn btn-success" onClick={this.createUser}>create</button>
                                    <button className="btn btn-danger" onClick={this.cancel}>cancel</button>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
          );
    }
}
 
export default CreateUserComponent;