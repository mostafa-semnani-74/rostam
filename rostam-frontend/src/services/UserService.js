import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/admin/rest/user/";

export default {

   getUserList() {
        return axios.get(USER_API_BASE_URL);
    }
    ,
    getUserById(userId) {
        return axios.get(USER_API_BASE_URL + userId)
    }
    ,
    createUser(user) {
        return axios.post(USER_API_BASE_URL, user);
    }
    ,
    updateUser(user, userId) {
        return axios.put(USER_API_BASE_URL + userId , user);
    }
    ,
    deleteUser(userId) {
        return axios.delete(USER_API_BASE_URL + userId);
    }

}
