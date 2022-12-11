<template>
<div>
    <div id="add-course">
         <!-- <button v-on:click="showForm = !showForm">Add New Course</button>

    <form id="frmAddNewCourse" v-show="showForm" v-on:submit.prevent='resetForm'>
      <div class="field">
        <label for="courseName">Course Name:</label>
        <input type="text" name="courseName" v-model="course.courseName" required/>
      </div>
      <div class="field">
        <label for="description">Description:</label>
        <input type="text" name="description" v-model="course.courseDescription" required/>
      </div>
      <div class="field">
        <label for="difficulty">Difficulty:</label>
        <select name="difficulty" v-model="course.difficulty" required>
            <option value="Easy">Easy</option>
            <option value="Medium">Medium</option>
            <option value="Hard">Hard</option>
        </select>
      </div>
      <div class="field">
        <label for="cost">Cost:</label>
        <input type="text" name="cost" v-model="course.cost" required/>
      </div>
      <button type="submit" class="btn save" value="save" v-on:click="saveCourse" >Save Course</button>
    </form> -->
    </div>

    <div class="background">
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

    }
    

}
</script>

CourseDetail
<style>



/* .background {

  display: flex;
  flex-direction: column;
 

  
} */

.background::before {
    content: '';
    position: absolute;
    top: 0px;
    right: 0px;
    bottom: 0px;
    left: 0px;
    background-image: url('../../images/peoplearoundatable.webp');
    background-size: cover;
    background-repeat: no-repeat;
    opacity: .3;
   

}

#app > header {
  z-index: 2;
  gap: 50px;
}

#courseList {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  align-content: stretch;

 
 
}

.courseDetail {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  display: flex;
  flex-direction: column;
  border: #7BCED1;
  border-style: ridge;
  column-gap: 50px;
  border-radius: 10px;
  align-items: center;
  padding: 15px;
  background-color: white;
  position: relative;
}
</style>