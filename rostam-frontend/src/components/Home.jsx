import React, { Component } from 'react';

class Home extends Component {
    
    componentDidMount() {
    console.log(localStorage.getItem('token'));
    }

    render() {
        return (
            <div>
                <h1>Home Page</h1>
                <div>
                    <ul>
                        <li><a href="/admin">Admin page</a></li>
                        <li><a href="/login">login</a></li>
                        <li><a href="/signup">signup</a></li>
                    </ul>
                </div>
            </div>
          );
    }
}
 
export default Home;