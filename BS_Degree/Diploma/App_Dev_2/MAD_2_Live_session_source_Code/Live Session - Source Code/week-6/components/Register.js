export default {
    template: `<div>
                <h1>This  is a Register Component</h1>
                <h2>Your credentials are added, click on register</h2>
                <button @click="register">Register</button>
               </div>`,
    data: function(){
        return {
            username: "Adarsh",
            role: "Admin"
        }
    },
    methods:{
        register: function(){
            // actual addition of data to db happens
            // this.$router.push(`/home/${this.username}/dashboard`)
            this.$router.push({name: 'dash', params: {user: this.username}, query: {role: this.role}})
            // '/home/Adarsh/dashboard?role=admin'
        }
    }
}