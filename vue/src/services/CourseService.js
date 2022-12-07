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

  addCourse(course) {
  //   const config = {
  //     headers: {
  //         Authorization: store.state.token
  //     }
  // };
return axios.post('/courses', course);
  }

}