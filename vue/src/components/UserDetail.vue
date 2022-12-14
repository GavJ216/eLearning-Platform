<template>
  <div>
      <div id="userDetailHead">
         <h1 id="username-h1">{{user.username}}</h1> 
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
                    <td>N/A</td>
                </tr>
            </tbody>
        </table>
  </div>
</template>

<script>
export default {
    props: ["user", "courses"]
}
</script>

<style>

#username-h1 {
    text-transform: capitalize;
}

#user-detail-table tr, #user-detail-table td, #user-detail-table th {
    padding: 15px;
}
</style>