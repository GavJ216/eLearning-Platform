<template>
  <div>
    <div id="add-course">
      <button v-on:click="showForm = !showForm">Add New Course</button>

      <form
        id="frmAddNewCourse"
        v-show="showForm"
        v-on:submit.prevent="resetForm"
      >
        <div class="field">
          <label for="courseName">Course Name:</label>
          <input
            type="text"
            name="courseName"
            v-model="course.courseName"
            required
          />
        </div>
        <div class="field">
          <label for="description">Description:</label>
          <input
            type="text"
            name="description"
            v-model="course.courseDescription"
            required
          />
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
          <input type="text" name="cost" v-model="course.cost" required />
        </div>
        <button
          type="submit"
          class="btn save"
          value="save"
          v-on:click="saveCourse"
        >
          Save Course
        </button>
      </form>
    </div>
    <table>
      <thead>
        <tr>
          <th>Course ID</th>
          <th>Course Name</th>
          <!-- <th>Assigned Date</th>
                  <th>Due Date</th>
                  <th>Completion status</th> -->
        </tr>
      </thead>
      <tbody>
        <tr v-for="course in courses" v-bind:key="course.courseId">
          <td>{{ course.courseId }}</td>
          <td>{{ course.courseName }}</td>
          <!-- <td>{{course.assignDate}}</td>
                <td>{{course.dueDate}}</td>
                <td>{{calculateCompletion}}</td> -->
        </tr>
      </tbody>
    </table>

    <!-- <admin-course-detail v-for="course in courses" v-bind:key="course.courseId" v-bind:course="course"/> -->
  </div>
</template>

<script>
// import AdminCourseDetail from '../components/AdminCourseDetail.vue'
import CourseService from "../services/CourseService.js";
export default {
  data() {
    return {
      courses: [],
      showForm: false,
      course: {}
    };
  },
  // components: {
  //     AdminCourseDetail
  // },
  computed: {
    // calculateCompletion() {
    // *usersCompleted / usersAssigned
    // }
  },
  methods: {
    displayList() {
      CourseService.listCourses().then((response) => {
        if (response.status === 200) {
          this.courseList = response.data;
        } else {
          console.log("error");
        }
      });
    },
    resetForm() {
      this.course = {};
      this.showForm = false;
    },
    saveCourse() {
      CourseService.addCourse(this.course)
        .then((response) => {
          console.log(response.status);
          if (response.status === 201) {
            alert("Success!");
            this.displayList();
          }
        })
        .catch((error) => {
          console.log(error.response.data);
        });
    },
    created() {
      this.displayList();
    },
  },
};
</script>

<style>
</style>