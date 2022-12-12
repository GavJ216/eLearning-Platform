<template>
  <div>
      <h1>Test</h1>
      <user-detail v-bind:user="viewedUser" v-bind:courses="userCourses"/>
  </div>
</template>

<script>
import UserDetail from '../components/UserDetail.vue';
import CourseService from '../services/CourseService';
import UserService from '../services/UserService.js';

export default {
    data() {
        return {
            viewedUser: {

            },
            userCourses: []
        }
    },
    components: {
        UserDetail
    },
    created() {
        UserService.getUserByUsername(this.$route.params.username).then(response => {
            if (response.status === 200) {
                console.log(response.data)
                this.viewedUser = response.data
            }
        })
        CourseService.getCoursesByUsername(this.$route.params.username).then(response => {
            if (response.status === 200) {
                console.log(response.data)
                this.userCourses = response.data
            }
        })
    }
}
</script>

<style>

</style>