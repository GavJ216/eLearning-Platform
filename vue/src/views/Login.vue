<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            authService.getUserByUsername(this.user.username)
              .then(response => {
                console.log(response.data)
                if (response.data == true) {
                  this.$store.state.isAdmin = true;
                  this.$router.push({name: 'AHome'});
                }
                else {
                  this.$router.push("/");
                }
              })
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>

#login {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

.form-signin {
  display: flex;
  flex-direction: column;
  border: 2px solid black;
  border-radius: 10px;
  padding: 15px;
  background-color: rgb(190, 190, 190);
}

form > h1 {
  background-color: lightskyblue;
  margin-top: .5px;
  margin-bottom: 10px;
  padding: 0, px, 0, 5px;
  border-radius: 10px;
}

</style>
