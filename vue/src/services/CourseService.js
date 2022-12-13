import axios from 'axios';
import store from '../store/index.js'

export default {

  listCourses() {
      const config = {
          headers: {
              Authorization: store.state.token
          }
      };
    return axios.get('/courses', config);
  },

  listCoursesByUserId(userId) {
    return axios.get(`courses/user/${userId}`)
  },

  addCourse(course) {
  //   const config = {
  //     headers: {
  //         Authorization: store.state.token
  //     }
  // };
return axios.post('/courses', course);
  },

  editCourse(course){
    return axios.put(`/course/${course.id}`, course);
  },

  deleteCourse(courseId){
    return axios.delete(`/course/${courseId}`)

  },

  addUserToCourse(userId, courseId){
    return axios.post(`/courses/${courseId}/${userId}`, userId)
  },

  getCoursesByUsername(username) {
    return axios.get(`/${username}/courses`)
  }

}