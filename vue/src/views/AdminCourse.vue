<template>
  <div>
    <div  id="main">
      <h1>Course Progress</h1>
      <admin-course-detail id="mainAdminCourse" v-bind:course="course" v-bind:userCourseDtoList="userCourseDtoList"/>
    </div>
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

<style scoped>

#main {
   background-image: url('../../images/businessmeeting.jpg');
  background-attachment: fixed;
  background-size: cover;
  height: 100%;
  width: 100%;
 
  
}


</style>