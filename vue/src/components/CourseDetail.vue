<template>

    <div>
        <div id="cardDetailHead">
            <h1 id="courseName">{{course.courseName}}</h1>
            <p id="courseDifficulty">{{course.difficulty}}</p>
        </div>
        <p id="courseDescription">{{course.courseDescription}}</p>
        <p id="courseCost">{{course.cost}}</p>
    </div>
</template>

<script>
export default {
props: ["course"]
}
</script>

<style>

#courseDescription {
    display: flex;
    flex-wrap: wrap;
    color: #9991A4;
}

#courseName {
    text-align: left;
    display: flex;
    flex-basis: 100%;
}

#courseDifficulty {
    text-align: right;
    display: flex;
    color: #9991A4;
    justify-content: flex-end;
    align-content: center;
    
}

#courseCost {
     text-align: right;
      color: #9991A4;
}

#cardDetailHead {
    display: flex;
    
}


</style>