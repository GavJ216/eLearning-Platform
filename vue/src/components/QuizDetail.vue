<template>
    <div>
        <h2>Score:&nbsp;{{score}}</h2>
        <div id="question-div">
        <form @submit.prevent="loadNewQuestion" v-show="quizActive">
            <h1 id="question">[{{activeQuestion.number}}/{{questions.length}}] {{activeQuestion.question}}</h1>
            
            <div id="choices">
                <div class="choice">
                <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.answers[0]">
                <label for="choice1">{{activeQuestion.answers[0]}}</label>
                </div>
                
                <div class="choice">
                <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.answers[1]">
                <label for="choice1">{{activeQuestion.answers[1]}}</label>
                </div>

                <div class="choice">
                <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.answers[2]">
                <label for="choice1">{{activeQuestion.answers[2]}}</label>
                </div>

                <div class="choice">
                <input v-model="selectedAnswer" type="radio" name="choice" v-bind:value="activeQuestion.answers[3]">
                <label for="choice1">{{activeQuestion.answers[3]}}</label>
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
            questions: [
                {
                    number: 1,
                    question: "what do you think you're doing????",
                    solution: "thing",
                    answers: [
                        'poop',
                        'ding',
                        'thing',
                        'joey'
                    ]
                
                },
                {
                    number: 2,
                    question: "Things can do what stuff?",
                    solution: "stuff",
                    answers: [
                        'donkies',
                        'kittens',
                        'blobs',
                        'stuff'
                    ]
                
                }

            ]
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
        //Todo: Implement load questions
        this.shuffle(this.questions[0].answers)
        this.activeQuestion = this.questions[0];
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
    padding-top: 7rem;
    width: 70vh;
    height: 50vh;
}

#question {
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
}

#choices > div > label {
    padding: 5px;
}

#submit-answer {
    float: right;
    width: 18rem;
    height: 10rem;
}

</style>