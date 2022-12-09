<template>
    <div>
        
        <h1 class="courseName">{{course.courseId}}&nbsp;-&nbsp;{{course.courseName}}</h1>
        <p>{{course.courseDescription}}</p>
        <p>{{course.difficulty}}</p>
        <p>{{course.cost}}</p>
        
       
    </div>
</template>

<script>
export default {
props: ["course"]
}
</script>

<style>



</style>