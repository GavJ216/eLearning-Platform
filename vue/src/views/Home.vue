<template>
  <div class="home">
    <course-list />
  </div>
</template>

<script>
import CourseList from "../components/CourseList.vue"

export default {
  components: {
    CourseList
  },
  name: "home"
};
</script>
