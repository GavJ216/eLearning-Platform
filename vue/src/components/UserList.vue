<template>
    <div>
        <button @click="showForm = !showForm">Create User</button>
        <form v-show="showForm" @submit.prevent="register">
            <label for="firstName">First Name:&nbsp;</label>
            <input type="text" name="firstName" v-model="newUser.firstName" required>

            <label for="lastName">Last Name:&nbsp;</label>
            <input type="text" name="lastName" v-model="newUser.lastName" required>

            <button type="submit">Register</button>
        </form>
        <div v-if="$store.state.isAdmin" id="managers">
             <h1>Manager list</h1>
  <table>
      <thead>
        <tr>
            <th>User ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Total Course Progress</th>
            <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in $store.state.managerArray" v-bind:key="user.id">
            <td>{{user.id}}</td>
            <td>{{user.firstName}}</td>
            <td>{{user.lastName}}</td>
            <td>{{user.username}}</td>
            <td>Progress</td>
        </tr>
      </tbody>
  </table>
        </div>
        <div id="users">
            <h1>User list</h1>
  <table>
      <thead>
        <tr>
            <th>User ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Total Course Progress</th>
            <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in $store.state.userArray" v-bind:key="user.id">
            <td>{{user.id}}</td>
            <td>{{user.firstName}}</td>
            <td>{{user.lastName}}</td>
            <td>{{user.username}}</td>
            <td>Progress</td>
        </tr>
      </tbody>
  </table>
        </div>
    </div>
</template>

<script>
import AuthService from '../services/AuthService'
export default {
    data() {
        return {
            newUser: {
                firstName: '',
                lastName: '',
                password: '',
                role: 'user'
            },
            showForm: false,
            registrationErrors: false,
            registrationErrorMsg: 'There were problems registering this user.'
        }
    },
    methods: {
        clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
        register() {
            this.newUser.password = this.newUser.firstName;
            AuthService.register(this.newUser).then (response => {
                if (response.status === 201) {
                    alert('Successfully registered ' + this.newUser.firstName + ' ' + this.newUser.lastName
                    + '. Username: ' + response.data.username )
                }
            })
        },
        created() {
            console.log(this.$store.state.userArray)
        }
    }

}
</script>

<style>

</style>