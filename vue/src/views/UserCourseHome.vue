<template>

<div>
   
    <div class="courselist">
      <course-detail class="courseDetail" v-bind:course="course" v-for="course in courseList" v-bind:key="course.courseId" />
      
    </div>

  </div>
</template>



<script>
import CourseDetail from '../components/CourseDetail.vue'
import CourseService from '../services/CourseService'
export default {
  components: {
       CourseDetail 
       },

       data(){
           return {
               courseList: [],
               course: {
                    courseName: '',
                    courseDescription: '',
                    difficulty: '',
                    cost: ''
               },
               activeUserId: this.$route.params.userId
           }
       },
       
      

       created() {
         CourseService
         .listCoursesByUserId(this.$route.params.userId)
         .then(response => {
           this.courseList = response.data;
         })
       }


 

}
</script>

<style>

</style>