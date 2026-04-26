import Register from './components/Register.js';
import Profile from './components/Profile.js';
import Home from './components/Home.js';
import Dashboard from './components/Dashboard.js';
import NotFound from './components/NotFound.js';

const routes = [
    {
        path: '/home/:user', 
        name: 'home',
        component: Home,
        children: [
            {path: 'dashboard', name:'dash', component: Dashboard},
            {path: 'register', name:'reg' , component: Register}
        ]
    },
    {path: '/profile/:username', component: Profile},
    {path: '*', component: NotFound},
]

const router = new VueRouter({
    routes
})

const app = new Vue({
    data: {
        myName: ""
    },
    methods: {
        goBack: function(){
            this.$router.go(0)
        }
    },
    router
}).$mount('#app')

// const app = new Vue({router}).$mount('#app')
// some page to render ---> component ---> /home
// Home ---> /home 
// Dashboard(HTML) ---> /dashboard/<myName> (endpoint)
// Profile ---> /profile?role=admin
// /profile/mad2 ---> mad2's profile
// /profile/himanshu
// /profile/<username> 

// home.html ----> /api/home

// @app.route('/profile/<username>')
// def profile(username):
//     # fetch info based on username
//     return render_template(profile.html)

// '/home/user' ---> C1
// '/home/user/dashboard' ---> C2 
// '/home/user/register' ---> C3

// {path: '/home/user/:name', component: C1}
// {path: '/home/user/dahsb', component: C2}
// {path: '/home/user/reg', component: C3}

// url:  /home/<user> ---> Home
// url:  /home/<user>/dashboard ---> Dashboard
// url:  /home/<user>/register ---> Register
// url:  /profile/<username> ---> Profile
// url: anything ---> NotFound


// url: /home/register/register

// {
//     user: "Adarsh",
//     role: "admin"
// }