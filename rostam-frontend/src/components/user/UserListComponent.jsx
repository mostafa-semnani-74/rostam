
import React , {Component} from 'react';
import UserService from '../../services/UserService';


class UserListComponent extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            userList: []
         }
         this.createUser = this.createUser.bind(this);
         this.updateUser = this.updateUser.bind(this);
         this.deleteUser = this.deleteUser.bind(this);
    }

    componentDidMount() {
        UserService.getUserList()
        .then( response => {
            this.setState( {userList: response.data} );
            }
        );
    }

    deleteUser(userId) {
        UserService.deleteUser(userId).then( response => {
            this.setState( { userList: this.state.userList.filter(user => user.userId !== userId) } );
            } 
        );
    }

    updateUser(userId) {
        this.props.history.push('/updateUser/'+ userId);
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
                                    <th>User ID</th>
                                    <th>Username</th>
                                    <th>Password</th>
                                    <th>Status</th>
                                    <th>Update</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                                <tbody>
                                    {
                                        this.state.userList.map(
                                            user => 
                                            <tr key={user.userId}>
                                                    <td>{user.userId}</td>
                                                    <td>{user.username}</td>
                                                    <td>{user.password}</td>
                                                    <td>{user.status}</td>
                                                    <td>
                                                        <button onClick={ () => this.updateUser(user.userId) } className="btn btn-info" >Update</button>
                                                    </td>
                                                    <td>
                                                        <button onClick={ () => this.deleteUser(user.userId) } className="btn btn-danger" >Delete</button>
                                                    </td>
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