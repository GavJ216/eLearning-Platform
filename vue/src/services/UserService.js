import axios from 'axios';

export default {
    getUserByUsername(username) {
      console.log(username)
        return axios.get(`/user/${username}`)
      },
    findAll() {
        return axios.get('/users')
      },
      getUserByUserId(id) {
        return axios.get(`/users/${id}`)
      }
}