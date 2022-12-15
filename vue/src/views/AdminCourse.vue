<template>
  <div id="main">
    <h1>Course Progress</h1>
      <admin-course-detail id="mainAdminCourse" v-bind:course="course" v-bind:userCourseDtoList="userCourseDtoList"/>
  </div>
</template>

<script>
import AdminCourseDetail from '../components/AdminCourseDetail.vue'
import CourseService from '../services/CourseService'
import UserService from '../services/UserService'
export default {
  components: { AdminCourseDetail },
  data() {
      return {
          course: {},
          userCourseDtoList: []
      }
  },
  created() {
      CourseService.getCourseByCourseId(this.$route.params.courseId)
        .then(response => {
            this.course = response.data
        });
      UserService.getUsersByCourseId(this.$route.params.courseId)
        .then(response => {
            this.userCourseDtoList = response.data
        });
  }

}
</script>

<style>

#mainAdminCourse {

  background-image: url('../../images/busyburgerboy.jpg');
  background-attachment: fixed;
  background-size: cover;
  background-position-x: -500px;
  background-position-y: 100px;
  height: 100vh;
  width: 100vw;
  justify-content: flex-start; 

} 


</style>