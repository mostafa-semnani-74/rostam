import React, { Component } from 'react';
import './App.css';
import UserListComponent from './components/user/UserListComponent';
import 'bootstrap/dist/css/bootstrap.min.css'
import HeaderComponent from './components/common/HeaderComponent';
import FooterComponent from './components/common/FooterComponent';
import {BrowserRouter as Router , Route , Switch} from 'react-router-dom'
import CreateUserComponent from './components/user/CreateUserComponent';

class App extends Component {
  render() {
    return (
      <div className="App">
          <Router>
            <div>
                <HeaderComponent></HeaderComponent>
                    <Switch>
                          <Route path="/" exact component = {UserListComponent}></Route>
                          <Route path="/createUser" component = {CreateUserComponent}></Route>
                    </Switch>
                <FooterComponent></FooterComponent>
            </div>
          </Router>
      </div>
        
        );
  }
}

export default App;
