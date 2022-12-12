import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    isAdmin: false,
    isManager: false,
    isUser: false,
    userArray: [],
    managerArray: [],
    adminArray: [],
    
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      state.isAdmin = false;
      state.isManager = false;
      state.isUser = false;
      state.adminArray = [];
      state.managerArray = [];
      state.userArray = [];
      axios.defaults.headers.common = {};
    },
    POPULATE_USER_ARRAY(state, users) {
      state.userArray = users
    },
    POPULATE_MANAGER_ARRAY(state, managers) {
      state.managerArray = managers;
    },
    POPULATE_ADMIN_ARRAY(state, admins) {
      state.adminArray = admins
    },
    ADD_TO_USER_ARRAY(state, user) {
      state.userArray.push(user)
    },
    ADD_TO_MANAGER_ARRAY(state, manager) {
      state.managerArray.push(manager)
    },
    ADD_TO_ADMIN_ARRAY(state, admin) {
      state.adminArray.push(admin)
    }

  }
})
