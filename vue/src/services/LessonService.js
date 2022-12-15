import axios from 'axios';


export default {

    getLessonsByCourseId(courseId){
        return axios.get(`/course/${courseId}/lessons`)
    },

    getAllLessons(){
        return axios.get('/lessons')
    },

    markCompleted(lessonId, userId) {
        return axios.post(`/${lessonId}/${userId}`)
    },

    checkCompletion(lessonId, userId) {
        return axios.get(`/${lessonId}/${userId}`)
    },

}