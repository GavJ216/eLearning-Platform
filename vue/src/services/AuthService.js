import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  getUserByUsername(username) {
    return axios.get(`/users/${username}`)
  },

  makeAdmin(username) {
    return axios.put(`users/${username}`)
  }
}
