
import React , {Component} from 'react';
import UserService from '../../services/UserService';


class UserListComponent extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            userList: []
         }
         this.createUser = this.createUser.bind(this);
    }

    componentDidMount() {
        UserService.getUserList()
        .then( response => {
            this.setState( {userList: response.data} );
            }
        );
    }

    createUser() {
        this.props.history.push('/createUser');
    }

    render() { 
        return (
            <div>
                    <h2 className="text-center">User List</h2>
                    <div>
                        <button className="btn btn-primary" onClick={this.createUser}>Create User</button>
                    </div>
                    <div className="container">
                        <table className="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Username</th>
                                    <th>Password</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                                <tbody>
                                    {
                                        this.state.userList.map(
                                            user => 
                                            <tr key={user.userId}>
                                                    <td>{user.username}</td>
                                                    <td>{user.password}</td>
                                                    <td>{user.status}</td>
                                            </tr>
                                        )
                                    }

                                </tbody>

                        </table>
                    </div>
            </div>
          );
    }
}
 
export default UserListComponent;