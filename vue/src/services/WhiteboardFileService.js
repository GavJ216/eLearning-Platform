import axios from 'axios'

export default {
    getFileById(id) {
        return axios.get('/file', id)
    },

    getFileByName(name) {
        return axios.get('/files', name)
    },

    addFile(file) {
        return axios.post('/files', file)
    }


}