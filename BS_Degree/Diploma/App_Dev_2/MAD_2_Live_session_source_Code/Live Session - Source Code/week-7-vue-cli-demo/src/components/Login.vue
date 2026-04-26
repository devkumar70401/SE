<script>
export default {
    name: "Login",
    data: function() {
        return {
            formData: { username: "", password: "" }
        }
    },
    methods: {
        login: function() {
            // console.log("Login button clicked");
            // console.log("Username: " + this.formData.username);
            fetch('http://127.0.0.1:5000/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.formData)
            }).then(response => response.json())
                .then(data => {
                    localStorage.setItem('token', data.access_token);
                    this.dashboard();
                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        },
        dashboard: function() {
            fetch('http://127.0.0.1:5000/dashboard', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + localStorage.getItem('token')
                }
            }).then(response => response.json())
            .then(data => {
                console.log(data);
            })
        }
    }
}
</script>

<template>
    <div id="login-form">
        <h1>login Form</h1>
        <div>
            <label for="username">Username:</label> <br>
            <input type="text" id="username" v-model="formData.username" />
        </div>
        <div>
            <label for="password">Password:</label> <br>
            <input type="text" id="password" v-model="formData.password" />
        </div>
        <button @click="login">Login</button>
    </div>
</template>

<style scoped>
    #login-form{
        border: 2px solid lightgray;
        border-radius: 10px;
        padding: 5px;
        width: 500px;
    }
</style>