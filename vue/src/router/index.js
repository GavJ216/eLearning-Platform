import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import CourseDetail from '../components/CourseDetail.vue'
import CourseList from '../components/CourseList.vue'
import AdminHome from '../views/AdminHome.vue'
import ManageUsers from '../views/ManageUsers.vue'
import Course from '../views/Course.vue'
import UserView from '../views/UserView.vue'
import UserHome from '../views/UserHome.vue'
import UserCourseHome from '../views/UserCourseHome'
import Lesson from '../views/Lesson.vue'
import Quiz from '../views/Quiz.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/course",
      name: "course",
      component: CourseDetail,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/courses",
      name: "courses",
      component: CourseList,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/adminhome",
      name: "AHome",
      component: AdminHome,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/users",
      name: "Users",
      component: ManageUsers
    },
    {
      path: "/courses/:courseName",
      name: "Course",
      component: Course
    },
    {
      path: "/users/:username",
      name: "UserView",
      component: UserView
    },
    {
      path: "/courses/user/:userId",
      name: "UserHome",
      component: UserHome
    },
    {
      path: "/courses/:courseId/lessons/",
      name: "UserCourseHome",
      component: UserCourseHome
    },
    {
      path: "/courses/:courseId/lessons/:lessonId",
      name: "Lesson",
      component: Lesson
    },
    {
      path: "/quiz/:lessonId",
      name: "Quiz",
      component: Quiz
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
