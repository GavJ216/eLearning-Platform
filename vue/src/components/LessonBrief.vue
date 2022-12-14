<template>
  <div>
     
      <div class="lessonBrief">
       <h1>Lessons</h1>
       <router-link :to="{name: 'Lesson', params: {lessonId: lesson.lessonId }}" class="link" >
        <div v-for="lesson in lessons" :key="lesson.lessonId" class="briefDetail">
      
          <h2 class="lessonBriefName">{{lesson.lessonName}}</h2>
          <p class="lessonBriefDesc">{{lesson.lessonDescription}}</p>
          <p v-if="lesson.lessonCompletion" class="lessonBriefComp">&#x2713;</p>

        </div>
        </router-link>
    </div>
  </div>
</template>

<script>
import lessonService from '../services/LessonService';

export default { 
    name: "lesson-brief",

    data () {
        return {
        lesson: {
        },
        lessons: []
        };
    },

    created() {
        lessonService
        .getLessonsByCourseId(this.$route.params.courseId)
        .then(response => { 
            this.lessons = response.data;
        })   
    }

}
</script>

<style>

.link{
  display: flex;
  flex-direction: column;
  text-decoration: none;
  align-items: center;
  gap: 20px;
}

.lessonBriefName {
    color: black;
}

.lessonBriefDesc {
     color: #9991A4;
}

#app > div {
  display: flex;
  }

.lessonBrief {
  display: flex;
  flex-direction: column;
  gap: 20px;
  align-items: center;  
  /* justify-content: center; */
  background-image: url('../../images/Checkershirt.jpg');
  background-attachment: fixed;
  background-size: cover;
  height: 100vh;
 
}
.briefDetail:first-child {
   margin-top: 20px;
  
}

.briefDetail:last-child {
   margin-bottom: 20px;
  
}

.briefDetail {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  display: flex;
  flex-direction: column;
  border: #7BCED1;
  align-content: center;
  flex-shrink: 1;
  border-radius: 10px;
  padding: 15px;
  background-color: white;
  position: sticky;
  z-index: 5;
  width:33%;
}

</style>