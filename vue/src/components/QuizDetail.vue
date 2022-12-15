<template>
    <div>
        <h2>Score:&nbsp;{{score}}</h2>
        <div id="question-div">
        <form @submit.prevent="loadNewQuestion" v-show="quizActive">
            <h1 id="question">[{{activeQuestion.number}}/{{questions.length}}] {{activeQuestion.question}}</h1>

            <div id="choices">

            <div class="choice">
            <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.options[0]">
            <label for="choice1">{{activeQuestion.options[0]}}</label>
            </div>

            <div class="choice">
            <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.options[1]">
            <label for="choice1">{{activeQuestion.options[1]}}</label>
            </div>

            <div class="choice">
            <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.options[2]">
            <label for="choice1">{{activeQuestion.options[2]}}</label>
            </div>

            <div class="choice">
            <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.options[3]">
            <label for="choice1">{{activeQuestion.options[3]}}</label>
            </div>

            </div>

            <div id="submit-answer">
            <button
              type="submit"
              class="btn-save"
              value="save"
            >
             Submit Answer
            </button>
            </div>
        </form>
        </div>
    </div>
</template>

<script>
import QuizService from '../services/QuizService.js'
import LessonService from '../services/LessonService.js'
import CourseService from '../services/CourseService.js'

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
                options: []
            },
            questions: []
        }
    },
    methods: {
        loadNewQuestion() {
            this.checkSolution();

            if (this.activeQuestion.number == this.questions.length) {
                console.log(this.score)
                console.log(this.$store.state.workingUser.id)
                this.quizActive = false;
                //Todo: Implement checking score, showing pass/fail graphic, if pass, change student_lesson's progress to Completed
                if ((this.score / this.questions.length) * 100 >= 90) {
                    LessonService.markCompleted(this.$route.params.lessonId, this.$store.state.workingUser.id)
                        .then(response => {
                            if (response.status === 201 || response.status === 200) {
                                CourseService.updateUserCourseProgress(this.$store.state.workingUser.id)
                            }
                        })
                    
                }
            }
            else {
                this.activeQuestion = this.questions.find(question => { return question.number == (this.activeQuestion.number +1) })
                this.shuffle(this.activeQuestion.options);
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
        },
        setQuestions() {
            QuizService.getQuestionsByLessonId(this.$route.params.lessonId)
            .then(response => {
                console.log(response)
                this.questions = response.data
                this.beginQuiz();
            });
        },
        beginQuiz() {
            this.activeQuestion = this.questions[0]
            this.shuffle(this.activeQuestion.options)
        },

        completeQuiz() {
            if (this.score >= 9) {
                LessonService.markCompleted(this.$route.params.lessonId, this.$store.state.workingUser)
            }
        },
        updateUserCourseProgress() {
            CourseService.updateUserCourseProgress(this.$store.state.workingUser.id)
        }
    },
    created() {
        this.setQuestions();
    }
}
</script>

<style>

#question-div {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    background-color: #b5ebe6;
    margin: 20px;
    padding-top: 5rem;
    width: 90vh;
    height: 75vh;
}

#question {
    font-size: 30px;
    padding: 25px;
    background-color: #b5ebe6;
    color: black;
}

#choices {
    margin-top: 20px;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    flex-direction: column;
}

.choice {
    padding: 20px;
    font-weight: bold;
}

#choices > div > label {
    padding: 5px;
}

#submit-answer {
    float: right;
    width: 18rem;
    height: 10rem;
}

#submit-answer button {
    color: black;
    font-size: 15px;
    font-family: Optima, sans-serif;
    letter-spacing:1px;
}

</style>