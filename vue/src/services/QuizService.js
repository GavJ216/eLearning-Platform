import axios from 'axios';


export default {

    getQuestionsByLessonId(id) {
        return axios.get(`/lessons/${id}/questions`)
    }

}