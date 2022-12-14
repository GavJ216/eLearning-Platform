<template>
<div>
   <!-- <div class="loading" v-if="isLoading">
        <img src="../../assets/loading.gif" />
    </div> -->
    <div class="courselist">
      <course-detail class="courseDetail" v-bind:course="course" v-for="course in courseList" v-bind:key="course.courseId" />
    </div>
  </div>
</template>

<script>
import CourseDetail from './CourseDetail.vue'
import CourseService from "../services/CourseService"

export default {
    components: {
        CourseDetail 
    },
    data() {
        return {
            // isLoading: false,
            courseList: [],
            course: {
                // id: '',
                courseName: '',
                courseDescription: '',
                difficulty: '',
                cost: ''
            },
            showForm: false
        }
    },
    methods: {
        resetForm() {
      this.course = {};
      this.showForm = false;
    },
        saveCourse() {
            CourseService.addCourse(this.course).then(response => {
                console.log(response.status);
                if (response.status === 201) {
                   alert("Success!");
                   this.displayList();
                }
            })
            .catch(error => {
          console.log(error.response.data);
        
      });
        },
        displayList() {
            CourseService.listCourses().then(response => {
           if (response.status === 200) {
        //       this.isLoading = true;
        //   setTimeout(() => {
        //    this.isLoading = false;
        // }, 1000)
           this.courseList = response.data;
           }
           else {
               console.log("error");
           }
        })
        }
    },
    created() {
        this.displayList();

    },

    
    
    

}
</script>


<style>

.courselist {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  gap: 20px;
  align-items: center;  
  justify-content: center;
  background-image: url('../../images/officepeople.jpg');
  background-attachment: fixed;
  background-size: cover;
  height: 100vh;
  
  
}

/* .courselist::before {
    content: '';
    position: absolute;
    top: 0px;
    right: 0px;
    bottom: 0px;
    left: 0px;
    background-image: url('../../images/peoplearoundatable.webp');
    background-attachment: fixed;
    background-size: cover;
    flex-shrink: 0;
    opacity: .3;
    height: 100vh;


} */

#app > header {
  z-index: 2;
  gap: 50px;
}

.courseDetail:first-child {
   margin-top: 20px;
  
}

.courseDetail:last-child {
   margin-bottom: 20px;
  
}

.courseDetail {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  display: flex;
  flex-direction: column;
  border: #7BCED1;
  flex-wrap: wrap;
  flex-shrink: 1;
  border-radius: 10px;
  padding: 15px;
  background-color: white;
  position: sticky;
  z-index: 5;
  width:33%;
}
</style>