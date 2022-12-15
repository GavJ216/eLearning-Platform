<template>
  <div>
      <div id="userDetailHead">
          <h1 id="user-full-name-h1">{{user.firstName}}&nbsp;{{user.lastName}}</h1>
         <h2 id="username-h2">{{user.username}}</h2> 
         <hr>
         <p></p>
        </div>
        <table id="user-detail-table">
            <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>
                        <!-- {{user.firstName}}'s  -->
                        Progress</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="course in courses" v-bind:key="course.courseId">
                    <td>{{course.courseId}}</td>
                    <td>{{course.courseName}}</td>
                    <td>{{courseProgressMap[course.courseId]}}%</td>
                </tr>
            </tbody>
        </table>
  </div>
</template>

<script>
import UserService from '../services/UserService.js'
export default {
    props: ["user", "courses"],
    data() {
        return {
            courseProgressMap: null
        }
    },
    methods: {
        // getCourseProgress(courseId) {
            
        // }
    },
    created() {

        UserService.listCourseProgresses(this.$route.params.username)
            .then(response => {
                this.courseProgressMap = response.data
            })
    }
}
</script>

<style>

#user-full-name-h1 {
    text-transform: capitalize;
}

#username-h2 {
    text-transform: capitalize;
}

#user-detail-table tr, #user-detail-table td, #user-detail-table th {
    padding: 15px;
}
</style>