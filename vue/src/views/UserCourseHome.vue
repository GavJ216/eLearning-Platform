<template>
    <div id="main">
        <div class="lessonList">
            <lesson-brief class="lessonDetail"/>
        </div>
    </div>
</template>

<script>
import LessonBrief from '../components/LessonBrief.vue'
export default {
    components: {
        LessonBrief
    }

}
</script>

<style scoped>

main {
 background-image: url('../../images/Checkershirt.jpg');
  background-attachment: fixed;
  background-size: cover;
  height: 100%vh;
  width: 100%vw;

}



</style>