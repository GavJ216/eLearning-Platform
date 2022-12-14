<template>

  <div id="courseOVtable">
    <div class="loading" v-if="isLoading">
        <img src="../../assets/loading.gif" />
    </div>
    <div class="main" v-show="!isLoading">
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
            <td><router-link v-bind:to="{name: 'Course', params: {courseName: course.courseName}}" id="routeLink">{{ course.courseName }} </router-link></td>
            <td class="manage-course">
              <button @click="enrollAllUsers(course.courseId)">Add Users</button
              ><button @click="editCourse">Edit Course</button>
              <button @click="deleteCourse(course.courseId)" v-if="$store.state.isAdmin == true">
                Delete Course
              </button>
            </td>
            <!-- <td>{{course.assignDate}}</td>
                  <td>{{course.dueDate}}</td>
                  <td>{{calculateCompletion}}</td> -->
          </tr>
        </tbody>
      </table>
      <div id="add-course">
        <button id="add-course-button" v-on:click="showForm = !showForm">
          Add New Course
        </button>
        <div id="form-div">
          <form
            id="frmAddNewCourse"
            v-show="showForm"
            v-on:submit.prevent="saveCourse"
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
              <textarea
                v-model="newCourse.courseDescription"
                required
              />
            </div>
            <div class="field">
              <label for="difficulty">Difficulty:</label>
              <select name="difficulty" v-model="newCourse.difficulty" required>
                <option value="Beginner">Beginner</option>
                <option value="Intermediate">Intermediate</option>
                <option value="Advanced">Advanced</option>
              </select>
            </div>
            <div class="field">
              <label for="cost">Cost:</label>
              <input
                type="text"
                name="cost"
                v-model="newCourse.cost"
                required
              />
            </div>
            <button
              type="submit"
              class="btn-save"
              value="save"
            >
              Save Course
            </button>
          </form>
        </div>
      </div>

      <!-- <admin-course-detail v-for="course in courses" v-bind:key="course.courseId" v-bind:course="course"/> -->
      </div>
    </div>
</template>

<script>
// import AdminCourseDetail from '../components/AdminCourseDetail.vue'
import CourseService from "../services/CourseService.js";
import UserService from "../services/UserService.js"
export default {
  data() {
    return {
      isLoading: false,
      courses: [],
      showForm: false,
      newCourse: {
        courseId: null,
        courseName: '',
        courseDescription: '',
        difficulty: '',
        cost: ''
      },
      
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
      const deleteConfirmation = confirm(
        "Are you sure you want to delete this course?"
      );
      if (deleteConfirmation) {
        CourseService.deleteCourse(courseId)
          .then((response) => {
            if (response.status === 200 || response.status === 204) {
              alert("Course successfully deleted");
              this.displayList();
            }
          })
          .catch((error) => {
            console.log(error.response);
            alert(`Error ${error.status}: Could not delete course`);
          });
      }
    },
    editCourse() {},
    displayList() {
      CourseService.listCourses().then((response) => {
        if (response.status === 200) {
          this.isLoading = true;
          setTimeout(() => {
           this.isLoading = false;
        }, 1000)
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
          if (response.status === 201) {

            this.enrollAllUsers(response.data.courseId)
            this.displayList();
          }
      });
      this.resetForm();
    },
    enrollAllUsers(courseId) { 
      const confirmation = confirm('Would you like to enroll all users in this course?')
      if (confirmation) {
        let allUsers = this.$store.state.managerArray.concat(this.$store.state.userArray);
        allUsers.forEach(user => {
        let idToPass = user.id
        CourseService.addUserToCourse(idToPass, courseId)
          .then(response => {
            console.log(response.status)
          })
          .catch(error => {
            console.log(error.response.data)
          })
      });
      }
    },

  },
  created() {
    this.displayList();
    let userArray = [];
    let managerArray = [];
    let adminArray = [];
    UserService.findAll().then(response => {
      if (response.status === 200) {
        response.data.forEach(user => {
          user.authorities.forEach(role => {
            if (role.name == 'ROLE_ADMIN') {
              adminArray.push(user);
            }
            else if (role.name == 'ROLE_MANAGER') {
              managerArray.push(user);
            }
            else {
              userArray.push(user);
            }
          })
        })
      }
    });
    this.$store.commit('POPULATE_ADMIN_ARRAY', adminArray);
    this.$store.commit('POPULATE_MANAGER_ARRAY', managerArray);
    this.$store.commit('POPULATE_USER_ARRAY', userArray);
  },
};
</script>

<style>


* {
  font-family: sans-serif;
}

div.main {
  /* margin-top: 7rem; */
  display: flex;
  width: 90%;
  height: 100vh;
  flex-wrap: wrap;
  align-content: center;
  flex-direction: column;
}

#add-course {
  margin-top: 10px;
  display: flex;
  flex-direction: column;
  justify-content: left;
  width: 16rem;
  font-weight: bold;
  align-items: center;
  /* background-color: white;
  border: 1px solid black; */
  /* border-radius: 5px; */
}

#routeLink {
 display: flex;
 flex-direction: column;
 justify-content: center;
 height: 100%;
 border: none; 
 color: black;
}


#frmAddNewCourse > div {
  margin: 15px;
  margin-bottom: 15px;
 
}

#frmAddNewCourse > div > input[type=text], 
#frmAddNewCourse > div:nth-child(3) > select,
textarea
 {
   margin-left: 5px;
}

#frmAddNewCourse > div > label {
  margin: 5px;
}

/* description */
textarea {
  width: 170px;
}
/* cost field */
#frmAddNewCourse > div:nth-child(4) > input[type=text] {
  width: 92px;
  margin-left: 37px;
}

.btn-save {
  margin-top: 7px;
  margin-bottom: 10px;
  margin-left: 3.5rem;
}

/* original button styling */
/* #links > li {
  background-color: #7BCED1;
  border: none;
  border-radius: 6px;
  width: 7rem;
  height: 0.5rem;
  display: flex;
  flex-wrap: wrap;
  align-content: center;
  justify-content: center;
} */

 hr {
    border: 1px solid #4cb9bd;
  }

 #links > li {
  font-family: sans-serif;
  font-weight: 300;
  border-radius: 2px;
  background-color: transparent;
  padding: 6px 12px;
  transition: all 0.5s ease;
  cursor:pointer;
  border-radius: 5px;
}

#links > li {
  background: linear-gradient(to bottom, #4cb9bd 60%, #d2fcec 100%);
  background-size: 100% 200%;
  background-position: left bottom;
}
#links > li:hover {
  background-position: right top;
}

#links > li > a {
  color: rgb(0, 0, 0);
  text-decoration: none;
  text-transform: uppercase;
  letter-spacing: 2px;
}


button {
  background: linear-gradient(to bottom, #26abaf 50%, transparent 100%);
  background-size: 100% 200%;
  background-position: left bottom;
  color: rgb(0, 0, 0);
  font-weight: bold;
  border-radius: 6px;
  border: none;
  width: 50%;
  height: 30%;
  background-color: #7BCED1;
  letter-spacing: .8px;
}

button:hover {
  background-size: 100% 200%;
  background-position: left bottom;
  cursor: pointer;
  background: #7BCED1;
}

#add-course-button {
  white-space: nowrap;
  height: 30%;
  height: 2.5rem;
  width: 8.7rem;
}

#course-table {
  width: 65%;
  border-collapse: collapse;
  border-radius: 5px;
}

#course-table td {
  text-align: center;
}

#course-table td button {
  padding: 5px;
  margin: 5px;
}

#course-table th,
#course-table td {
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

.field {
  margin-top: 5px;
  margin-bottom: 5px;
}

#routeLink {
 display: flex;
 flex-direction: column;
 justify-content: center;
 /* height: 100%; */
 border: none;
 
 
}

.loading {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

#AHome {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-grow: 1;
}

</style>