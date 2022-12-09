import axios from 'axios';

export default {
    getUserByUsername(username) {
        return axios.get(`/users/${username}`)
      },
    findAll() {
        return axios.get('/users')
      }
}