<template>
  <div>

      <h1>{{lesson.name}}</h1>
      <p>{{lesson.description}}</p>
      <p v-if="isComplete">&#x2713;</p>

  </div>
</template>

<script>

export default { 
    name: "lesson-brief",

    data () {
        return {
        lesson: {
            name: '',
            description: '',
            isComplete: false
        }
        };
    },

    created() {
        
    }

}

</script>

<style>

</style>