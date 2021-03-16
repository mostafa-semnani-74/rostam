import React, { Component } from 'react';

class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        return (
            <div>
                <h1>Home Page</h1>
                <a href="/admin">Admin page</a>
            </div>
          );
    }
}
 
export default Home;