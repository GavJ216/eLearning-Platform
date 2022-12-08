<template>
  <div>
    <div id="add-course">
      <button id="add-course-button" v-on:click="showForm = !showForm">Add New Course</button>

      
      <div id="form-div">
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
            v-model="newCourse.courseName"
            required
          />
        </div>
        <div class="field">
          <label for="description">Description:</label>
          <input
            type="text"
            name="description"
            v-model="newCourse.courseDescription"
            required
          />
        </div>
        <div class="field">
          <label for="difficulty">Difficulty:</label>
          <select name="difficulty" v-model="newCourse.difficulty" required>
            <option value="Easy">Easy</option>
            <option value="Medium">Medium</option>
            <option value="Hard">Hard</option>
          </select>
        </div>
        <div class="field">
          <label for="cost">Cost:</label>
          <input type="text" name="cost" v-model="newCourse.cost" required />
        </div>
        <button
          type="submit"
          class="btn-save"
          value="save"
          v-on:click="saveCourse"
        >
          Save Course
        </button>
      </form>
      </div>
    </div>
    <table id="course-table">
      <thead>
        <tr>
          <th>Course ID</th>
          <th>Course Name</th>
          <th>Manage Course</th>
          <!-- <th>Assigned Date</th>
                  <th>Due Date</th>
                  <th>Completion status</th> -->
        </tr>
      </thead>
      <tbody>
        <tr v-for="course in courses" v-bind:key="course.courseId">
          <td>{{ course.courseId }}</td>
          <td>{{ course.courseName }}</td>
          <td class="manage-course"><button @click="addUsersToCourse">Add Users</button ><button @click="editCourse">Edit Course</button><button @click="deleteCourse(course.courseId)">Delete Course</button></td>
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
      newCourse: {},
      selectedUsers: []
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
    deleteCourse(courseId) {
      const confirmation = confirm('Are you sure you want to delete this course?');
      if (confirmation) {
        CourseService.deleteCourse(courseId).then(response => {
          if (response.status === 200 || response.status === 204) {
            alert("Course successfully deleted")
            this.displayList();
          }
        }).catch(error => {
          console.log(error.response)
          alert(`Error ${error.status}: Could not delete course`)
        })
      }
    },
    addUsersToCourse() {
      prompt
    },
    editCourse() {

    },
    displayList() {
      CourseService.listCourses().then((response) => {
        if (response.status === 200) {
          this.courses = response.data;
        } else {
          console.log("error");
        }
      });
    },
    resetForm() {
      this.newCourse = {};
      this.showForm = false;
    },
    saveCourse() {
      CourseService.addCourse(this.newCourse)
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
  },
  created() {
      this.displayList();
    }
};
</script>

<style>

#course-table {
  margin-top: 10px;
}
#course-table th, #course-table td {
  border: 1px solid black;
  padding: 8px;
}


#add-course-button {
  margin-top: 10px;
  margin-bottom: 10px;
}

#frmAddNewCourse {
  border: 1px solid black;
  padding: 3px;
}

.btn-save {
  justify-self: center;
}

.field {
  margin-top: 5px;
  margin-bottom: 5px;
}

</style>