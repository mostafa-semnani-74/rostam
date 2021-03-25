import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import AuthenticationService from '../../services/AuthenticationService';


class HeaderComponent extends Component {

    render() { 
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return ( 
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div><Link to={'/'} className="navbar-brand">Rostam</Link></div>    
                        <ul className="navbar-nav navbar-collapse justify-content-end">
                           <li className="nav-item">
                           {!isUserLoggedIn&&<Link to={'/login'} className="nav-link">Login</Link>}
                           </li>
                           <li className="nav-item">
                           {isUserLoggedIn&&<Link to={'/logout'} className="nav-link" onClick={AuthenticationService.logoutUser}>Logout</Link>}
                           </li>
                        </ul>
                    </nav>
                </header>
         );
    }
}
 
export default HeaderComponent;