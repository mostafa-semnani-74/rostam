import React, { Component } from 'react';

class FooterComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        return (
                <footer className="footer">
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark justify-content-center">
                    <span>Mostafa semnani e-commerce project for practice 2021</span>
                    </nav>
                </footer>
          );
    }
}
 
export default FooterComponent;