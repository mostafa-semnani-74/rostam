import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';


class AuthenticationService {

    loginUser(user) {
        return axios.post(API_BASE_URL+'/authenticate',user);
    }

    logoutUser() {
        localStorage.removeItem('token');
    }

    isUserLoggedIn() {
        if(localStorage.getItem('token') === null) {
            return false;
        } else {
            return true;
        }
    }


}
export default new AuthenticationService()