<template>
  <div class="mainLessonBrief">
     
      <div class="lessonBrief">
       <h1>Lessons</h1>
       <div class="briefDetail" :key="lesson.lessonId">
             <router-link :to="{name: 'wifi', params: {lessonId: lesson.lessonId}}" class="link" >

          <h2 class="lessonBriefName">Wi-Fi Safety</h2>
          <p class="lessonBriefDesc">Practice safe web surfing wherever you are by checking for the “green lock” or padlock icon in your browser bar—this signifies a secure connection. When you find yourself out in the great “wild Wi-Fi West,” avoid free internet access with no encryption.'</p>
          <p v-if="lesson.lessonCompletion" class="lessonBriefComp">&#x2713;</p>

        
        </router-link>
        </div>
          <div v-for="lesson in lessons" :key="lesson.lessonId" class="briefDetail">
             <router-link :to="{name: 'Lesson', params: {lessonId: lesson.lessonId}}" class="link" >

          <h2 class="lessonBriefName">{{lesson.lessonName}}</h2>
          <p class="lessonBriefDesc">{{lesson.lessonDescription}}</p>
          <p v-if="lesson.lessonCompletion" class="lessonBriefComp">&#x2713;</p>

        
        </router-link>
        </div>
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

/* .mainLessonBrief {

  background-image: url('../../images/Checkershirt.jpg');
  background-attachment: fixed;
  background-size: cover;
  height: 100%vh;
  width: 100%vw;

} */

.link{
  display: flex;
  flex-direction: column;
  justify-content: center;
  text-decoration: none;
  gap: 20px;
}

.lessonBriefName {
    color: black;
    padding-top: 20px;
}

.lessonBriefDesc {
     color: #9991A4;
     padding-bottom: 20px;
}

.lessonBrief {
  display: flex;
  flex-direction: column;
  align-items: center;  
  background-image: url('../../images/Checkershirt.jpg');
  background-attachment: fixed;
  background-size: cover;
  gap: 20px;
  height: 100%vh;
  width: 100%vw;
 
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
  /* flex-shrink: 1; */
  border-radius: 10px;
  padding: 15px;
  background-color: white;
  position: sticky;
  z-index: 5;
  width:33%;
  margin: 10px;
}

</style>