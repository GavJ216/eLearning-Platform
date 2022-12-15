<template>
    <div>
       <table id="adminCourse">
           <thead>
               <tr>
                   <th>Username</th>
                   <th>First Name</th>
                   <th>Last Name</th>
                   <th>Course Progress</th>
                   
               </tr>
           </thead>
           
           <tbody>
               <tr v-for="dto in userCourseDtoList" v-bind:key="dto.user.id">
                    <td>{{dto.user.username}}</td>
                    <td>{{dto.user.firstName}}</td>
                    <td>{{dto.user.lastName}}</td>
                    <td>{{dto.progress}}%</td>
                    
               </tr>
           </tbody>
       </table>
    </div>
</template>

<script>
// import UserService from '../services/UserService'
export default {
props: ["course", "userCourseDtoList"],
methods: {
    // getUserCourseProgress(userId) {
    //     UserService.checkCourseProgress(this.$route.params.courseId, userId)
    //         .then(response => {
    //             return response.data
    //         })
    }
}

</script>

<style>

#app > div {
  display: flex;
  justify-content: center;
  align-content: center;
}

#adminCourse {
  background-color: white;
  opacity: 85%;
  border-radius: 10px;
  text-align: center;
}

#adminCourse th,
#adminCourse td {
  padding: 10px;
}

</style>