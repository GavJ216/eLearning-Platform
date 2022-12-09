<template>
  <div id="app">

    <header v-if="$store.state.token != ''">
      <img id="logo" src="../assets/star.png" alt="na" />
      <nav>
        <ul id="links" v-if="$store.state.token != ''">
          <li><router-link class="link" v-bind:to="$store.state.isAdmin ? {name: 'AHome'} : {name: 'courses'}">Home</router-link></li>
          <li><router-link class="link" v-bind:to="{ name: 'logout' }">Logout</router-link></li>
        </ul>
      </nav>
    </header>

    <!-- <div id="nav">
      <img id="logo" src="../assets/star.png" alt="na"/>
        <div class="space-control">
        </div>
        <ul id="links" v-if="$store.state.token != ''">
          <li><router-link class="link" v-bind:to="{ name: 'home' }">Home</router-link></li>
          <li><router-link class="link" v-bind:to="{ name: 'logout' }">Logout</router-link></li>
        </ul>
    </div> -->
    <router-view />
  </div>
</template>

<style scoped>
  header {
    display: flex;
    background: linear-gradient(90deg, rgba(0,212,255,1) 0%, rgb(0, 174, 255) 37%, rgba(0,104,255,1) 100%);
    align-items: center;
  }

   #logo {
    max-width: 15%;
    flex-basis: 15%;
    padding-left: 5px;
    padding-top: 5px;
    padding-bottom: 5px;
  }



  nav {
    flex-basis: 85%;
    align-content: stretch;
  }

  nav ul {
    display: flex;
    list-style: none;
    justify-content: flex-end;
  }

  nav ul li {
    font-size: 130%;
    border: 1px solid royalblue;
    background: linear-gradient(90deg, rgba(0,212,255,1) 0%, rgb(0, 174, 255) 37%, rgba(0,104,255,1) 100%);
    text-align: center;
    padding: 10px;
    border-radius: 12%;
    margin-left: 20px;
    margin-right: 20px;
  }

  li a {
    color: white;
  }


</style>
