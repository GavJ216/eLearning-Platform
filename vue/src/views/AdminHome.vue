<template>
  <div >
    <course-overview id="AHome"/>
    <div v-if="isLoading"></div>
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