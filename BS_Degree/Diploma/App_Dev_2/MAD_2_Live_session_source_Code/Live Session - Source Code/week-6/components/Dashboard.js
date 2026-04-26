export default {
    template: `<div>
                    <h1>Welcome to {{$route.params.user}}'s Dashboard</h1>
                    <h2>Your role is {{$route.query.role}}!</h2>
                </div>`
}
