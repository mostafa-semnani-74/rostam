import React, { Component } from 'react';

class Home extends Component {
    
    componentDidMount() {
    console.log(localStorage.getItem('token'));
    }

    render() {
        return (
            <div>
                <h1>Home Page</h1>
                <a href="/admin">Admin page</a>
                <a href="/login">login</a>
                <a href="/signup">signup</a>
            </div>
          );
    }
}
 
export default Home;