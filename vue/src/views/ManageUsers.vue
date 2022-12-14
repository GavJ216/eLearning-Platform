<template>
  <div id="main">
    <user-list />
  </div>
</template>

<script>
import UserList from '../components/UserList.vue'
export default {
    components: {

        UserList

    }

}
</script>

<style scoped>

#main {
   background-image: url('../../images/busyburgerboy.jpg');
  background-attachment: fixed;
  background-size: cover;
  background-position-x: -500px;
  background-position-y: 100px;
  
}

</style>