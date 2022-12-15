import axios from 'axios';

export default {
    getUserByUsername(username) {
        return axios.get(`/user/${username}`)
      },
    findAll() {
        return axios.get('/users')
    },
    getUserByUserId(id) {
      return axios.get(`/users/${id}`)
    },

    checkCourseProgress(courseId, userId) {
      return axios.get(`/courses/${courseId}/users/${userId}`)
    },

    listCourseProgresses(username) {
      return axios.get(`/courses/progress/${username}`)
    },

    getUsersByCourseId(courseId) {
      return axios.get(`/${courseId}/users`)
    }


    
}