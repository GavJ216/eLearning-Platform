import axios from 'axios';


export default {

    getLessonsByCourseId(courseId){
        return axios.get(`/course/${courseId}/lessons`)
    },

    getAllLessons(){
        return axios.get('/lessons')
    }

}