<template>
  <div>
      <admin-course-detail v-bind:course="course" v-bind:userCourseDtoList="userCourseDtoList"/>
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

</style>