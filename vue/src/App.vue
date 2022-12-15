<template>
  <div id="app">
    <header v-if="$store.state.token != ''">
      <img id="logo" src="../images/Myproject2.png" alt="na" />
      <nav>
        <ul id="links" v-if="$store.state.token != ''">
          <li><router-link class="link" v-bind:to="$store.state.isManager ? {name: 'AHome'} : {name: 'UserHome', params: {userId: $store.state.workingUser.id }}">Home</router-link></li>
          <li><router-link class="link" v-bind:to="{ name: 'logout' }">Logout</router-link></li>
          <li v-if="$store.state.isManager || $store.state.isAdmin"><router-link class="link"  v-bind:to="{name: 'Users'}">Users</router-link></li>
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
    <footer>
      <div id="GUMBA">Powered by GUMBA &copy;</div>
      </footer>
  </div>
</template>
<style scoped>

  header {
    display: flex;
    background-color: white;
    border-radius: 5px;
    gap: 10px;
    align-items: center;
    position: relative;
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
    text-align: center;
    padding: 10px;
    border-radius: 12%;
    margin-left: 20px;
    margin-right: 20px;
  }

  #GUMBA {
    font-size: 12px;
    text-align: center;
    color: gray;
    margin-bottom: 0px;
    position: absolute;
  }

  button {
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  }

</style>
