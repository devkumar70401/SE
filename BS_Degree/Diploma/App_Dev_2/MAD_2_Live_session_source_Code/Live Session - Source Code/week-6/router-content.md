# Vue Router 3

## Getting Started and Installation

- Add Vue 2 and Vue Router 3 CDN to the document
  - `<script src="https://unpkg.com/vue@2/dist/vue.js"></script>`
  - `<script src="https://unpkg.com/vue-router@3/dist/vue-router.js"></script>`
- Create simple components (preferably external exported)
- Register them as components of Router
  - `const routes = [array of routes]`
- Create Router Instance
  - `const router = new VueRouter({routes})`
- Embed Router instance to the App
  - `const app = new Vue({router}).$mount('#app')`

## Dynamic Route Matching

- Used for passing parameters to the routes
- Can be used in doc or used programmatically
- route parameters are provide using colon `:` followed by parameter name.
  - e.g. `'/user/:username/profile`  where 'username' is the parameter
- Accessed using `$route` object
  - Within Template: `$route.params`
  - Wihthin Script: `this.$route.params` 

## Nested Routes

- Routes within routes
- comes in handy when you want to use components within components and most part of the url is same except for some part.
  - e.g. `user/:id/profile` and `user/:id/dashboard`
  
## Programmatic Navigation
- Used to go to a route programmatically, Accesses `$router` e.g. 
  - with a click of a button
  - Used for redirecting to a different route
  - Used for creating `Go Back` or `Home` Button
  - literal string path
  - When used as object: `this.$router.push({ path: 'home' })`
  - When used as object passing query parameters: `this.$router.push({path:'register', query:{plan:'private'}})`

## Named Routes
- Used for provding route parameters and/or query parameters programatically.
- Accesses `$router` object
- When used as object passing parameters: `this.$router.push({name:'user', params:{ userId:'123'}})`

## Named Views
- Used to display multiple views at the same time instead of nesting them
- Uses `default` keyword to render the unnamed component
- Uses `name` attribute to render a particular component at a specific place e.g. `<router-view name="helper"/>`  

*further reading at: https://v3.router.vuejs.org/guide/#javascript*

