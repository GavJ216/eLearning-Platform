<template>
    <div>
        <button @click="showForm = !showForm">Create User</button>
        <form id="new_user_form" v-show="showForm" @submit.prevent="register">
            <label for="firstName">First Name:&nbsp;</label>
            <input type="text" name="firstName" v-model="newUser.firstName" required>

            <label for="lastName">Last Name:&nbsp;</label>
            <input type="text" name="lastName" v-model="newUser.lastName" required>
            
            <div v-if="$store.state.isAdmin">
                <label for="managerCheck">Make Manager:&nbsp;</label>
                <input type="checkbox" name="managerCheck" @click="changeRole($event)">
            </div>

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
                    if (this.newUser.role == 'manager') {
                        this.$store.commit("ADD_TO_MANAGER_ARRAY", response.data )
                    }
                    else {
                        this.$store.commit("ADD_TO_USER_ARRAY", response.data )
                    }
                    
                }
            })

        },
        changeRole(event) {
            if (event.target.checked === true) {
                console.log(event.target.checked)
                this.newUser.role = 'manager'
                console.log(this.newUser.role)
            }
            if (event.target.checked === false) {
                 console.log(event.target.checked)
                this.newUser.role = 'user'
                console.log(this.newUser.role)

            }
            
        }
        
    }

}
</script>

<style>

#new_user_form {
    display: flex;
    flex-direction: column;
}

</style>