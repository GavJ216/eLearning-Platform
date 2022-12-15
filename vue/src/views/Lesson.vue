<template>
    <div>
    
        <lesson-full/>
    </div>
</template>

<script>
import LessonFull from '../components/LessonFull.vue'
export default {
    data() {
        
        return {
        isLoading: false
        }
        
    },
    components: {
        LessonFull
    }

}
</script>

<style>

.lessonList {
    display: flex;

}

</style>