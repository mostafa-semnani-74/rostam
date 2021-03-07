import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/admin/rest/user/";

export default {

   getUserList() {
        return axios.get(USER_API_BASE_URL);
    }
    ,
    createUser(user) {
        return axios.post(USER_API_BASE_URL,user);
    }

}
