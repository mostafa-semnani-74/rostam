import React, { Component } from 'react';
import './App.css';
import UserListComponent from './components/user/UserListComponent';
import 'bootstrap/dist/css/bootstrap.min.css'
import HeaderComponent from './components/common/HeaderComponent';
import FooterComponent from './components/common/FooterComponent';
import {BrowserRouter as Router , Route , Switch} from 'react-router-dom'
import CreateUserComponent from './components/user/CreateUserComponent';
import UpdateUserComponent from './components/user/UpdateUserComponent';
import Home from './components/Home';
import Login from './components/common/Login';
import Logout from './components/common/Logout';
import AuthenticatedRoute from './components/common/AuthenticateRoute';

class App extends Component {
  render() {
    return (
      <div className="App">
          <Router>
            <div>
                <HeaderComponent></HeaderComponent>
                    <Switch>
                          <Route path="/" exact component = {Home}></Route>
                          <Route path="/login" component = {Login}></Route>
                          <Route path="/logout" component={Logout}/>
                          <AuthenticatedRoute path="/admin" component = {UserListComponent}></AuthenticatedRoute>
                          <AuthenticatedRoute path="/createUser" component = {CreateUserComponent}></AuthenticatedRoute>
                          <AuthenticatedRoute path="/updateUser/:userId" component = {UpdateUserComponent}></AuthenticatedRoute>
                    </Switch>
                <FooterComponent></FooterComponent>
            </div>
          </Router>
      </div>
        
        );
  }
}

export default App;
