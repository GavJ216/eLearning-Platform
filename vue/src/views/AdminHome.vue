<template>
  <div >
    <div>
      <router-link v-to="">
        <button >DO THE THING</button>
      </router-link>
    </div>
    <course-overview id="AHome"/>
  </div>
</template>

<script>
import CourseOverview from '../components/CourseOverview.vue'
export default {
    components: {
        CourseOverview
    }

}
</script>

<style >


</style>