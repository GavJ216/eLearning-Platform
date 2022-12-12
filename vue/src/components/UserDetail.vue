<template>
  <div>
      <div id="userDetailHead">
         <h1>{{user.username}}</h1> 
         <p></p>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>{{user.firstName}}'s Progress</th>
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

</style>