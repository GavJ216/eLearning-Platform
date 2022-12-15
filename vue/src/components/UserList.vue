<template>
  <div>
    <aside>
      <div id="create-user-button">
        <button @click="showForm = !showForm">Create User</button>
      </div>
      <form id="new_user_form" v-show="showForm" @submit.prevent="register">
        <label for="firstName">First Name:&nbsp;</label>
        <input
          type="text"
          name="firstName"
          v-model="newUser.firstName"
          required
        />

        <label for="lastName">Last Name:&nbsp;</label>
        <input
          type="text"
          name="lastName"
          v-model="newUser.lastName"
          required
        />

        <div id="make-manager-div" v-if="$store.state.isAdmin">
          <label for="managerCheck">Make Manager:&nbsp;</label>
          <input
            type="checkbox"
            name="managerCheck"
            @click="changeRole($event)"
          />
        </div>
        <div id="register-button">
          <button type="submit">Register</button>
        </div>
      </form>
    </aside>
    <div id="content-div">
      <div v-if="$store.state.isAdmin" id="managers">
        <h1>Manager list</h1>
        <hr />
        <table class="user-table">
          <thead>
            <tr>
              <th>User ID</th>
              <th>Username</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Total Course Progress</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="user in $store.state.managerArray" v-bind:key="user.id">
              <td>{{ user.id }}</td>
              <router-link
                v-bind:to="{
                  name: 'UserView',
                  params: { username: user.username },
                }"
              >
                <td>{{ user.username }}</td>
              </router-link>
              <td>{{ user.firstName }}</td>
              <td>{{ user.lastName }}</td>
              <td>Progress</td>
            </tr>
          </tbody>
        </table>
        </div>
        <div id="users">
          <h1>User list</h1>
          <hr />
          <table class="user-table">
            <thead>
              <tr>
                <th>User ID</th>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Total Course Progress</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="user in $store.state.userArray" v-bind:key="user.id">
                <td>{{ user.id }}</td>
                <router-link
                  v-bind:to="{
                    name: 'UserView',
                    params: { username: user.username },
                  }"
                >
                  <td>{{ user.username }}</td>
                </router-link>
                <td>{{ user.firstName }}</td>
                <td>{{ user.lastName }}</td>
                <td>Progress</td>
              </tr>
            </tbody>
          </table>
        </div>
    </div>
  </div>
</template>

<script>
import AuthService from "../services/AuthService";
export default {
  data() {
    return {
      newUser: {
        firstName: "",
        lastName: "",
        password: "",
        role: "user",
      },
      showForm: false,
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
    register() {
      this.newUser.password = this.newUser.firstName;
      AuthService.register(this.newUser).then((response) => {
        if (response.status === 201) {
          alert(
            "Successfully registered " +
              this.newUser.firstName +
              " " +
              this.newUser.lastName +
              ". Username: " +
              response.data.username
          );
          if (this.newUser.role == "manager") {
            this.$store.commit("ADD_TO_MANAGER_ARRAY", response.data);
          } else {
            this.$store.commit("ADD_TO_USER_ARRAY", response.data);
          }
        }
      });
    },
    changeRole(event) {
      if (event.target.checked === true) {
        console.log(event.target.checked);
        this.newUser.role = "manager";
        console.log(this.newUser.role);
      }
      if (event.target.checked === false) {
        console.log(event.target.checked);
        this.newUser.role = "user";
        console.log(this.newUser.role);
      }
    },
  },
};
</script>

<style>
#app > div {
  display: flex;
  justify-content: center;
  align-content: center;
}

#managers {
  background-color: white;
  opacity: 85%;
  border-radius: 10px;
  text-align: center;
  margin-top: 5px;
}

#users {
  background-color: white;
  opacity: 85%;
  border-radius: 10px;
  text-align: center;
}

#create-user-button {
  padding-top: 10px;
  padding-bottom: 20px;
}

#create-user-button button {
  height: 30px;
  width: 10rem;
}

#new_user_form {
  display: flex;
  flex-direction: column;
}

#users th,
#managers th,
#users td,
#managers td {
  padding: 10px;
}

#users a,
#managers a {
  color: black;
}

#make-manager-div {
  margin: 10px;
}

#new_user_form > label,
input,
#register-button {
  padding: 10px;
}

#new_user_form > input[type="text"] {
  width: 14rem;
}

#register-button {
  height: 100px;
  width: 10rem;
}
</style>