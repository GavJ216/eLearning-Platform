<template>
    <div>
        <h2>Score:&nbsp;{{score}}</h2>
        <form @submit.prevent="loadNewQuestion" v-show="quizActive">
            <h1>[{{activeQuestion.number}}/{{questions.length}}] {{activeQuestion.question}}</h1>

            <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.answers[0]">
            <label for="choice1">{{activeQuestion.answers[0]}}</label>

            <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.answers[1]">
            <label for="choice1">{{activeQuestion.answers[1]}}</label>

            <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.answers[2]">
            <label for="choice1">{{activeQuestion.answers[2]}}</label>

            <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.answers[3]">
            <label for="choice1">{{activeQuestion.answers[3]}}</label>

            <button
              type="submit"
              class="btn-save"
              value="save"
            >
             Submit Answer
            </button>
            
        </form>
    </div>
</template>

<script>
import QuizService from '../services/QuizService.js'

export default {
    data() {
        return {
            quizActive: true,
            score: 0,
            selectedAnswer: '',
            activeQuestion: {
                number: null,
                question: '',
                solution: '',
                answers: []
            },
            questions: []
        }
    },
    methods: {
        loadNewQuestion() {
            this.checkSolution();

            if (this.activeQuestion.number == this.questions.length) {
                console.log(this.score)
                this.quizActive = false;
                //Todo: Implement checking score, showing pass/fail graphic, if pass, change student_lesson's progress to Completed
            }
            else {
                this.activeQuestion = this.questions.find(question => { return question.number == (this.activeQuestion.number +1) })
                this.shuffle(this.activeQuestion.answers);
            }
        },
        checkSolution() {
            if(this.selectedAnswer == this.activeQuestion.solution) {
                this.score++
            }
        },
        increaseScore() {
            this.score++
        },
        shuffle(array) {
            let currentIndex = array.length,  randomIndex;

            // While there remain elements to shuffle.
            while (currentIndex != 0) {

                // Pick a remaining element.
                randomIndex = Math.floor(Math.random() * currentIndex);
                currentIndex--;

                // And swap it with the current element.
                [array[currentIndex], array[randomIndex]] = 
                [array[randomIndex], array[currentIndex]];
            }

            return array;
        }
    },
    created() {
        QuizService.getQuestionsByLessonId(this.$route.params.lessonId)
            .then(response => {
                this.questions = response.data
            });
        this.shuffle(this.questions[0].answers)
        this.activeQuestion = this.questions[0];
    }
}
</script>

<style>

</style>