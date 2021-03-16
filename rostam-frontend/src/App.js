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

class App extends Component {
  render() {
    return (
      <div className="App">
          <Router>
            <div>
                <HeaderComponent></HeaderComponent>
                    <Switch>
                          <Route path="/" exact component = {Home}></Route>
                          <Route path="/admin" component = {UserListComponent}></Route>
                          <Route path="/createUser" component = {CreateUserComponent}></Route>
                          <Route path="/updateUser/:userId" component = {UpdateUserComponent}></Route>
                    </Switch>
                <FooterComponent></FooterComponent>
            </div>
          </Router>
      </div>
        
        );
  }
}

export default App;
