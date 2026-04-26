const app = new Vue({ // options object >well defined object
    el: "#app",
    data: {//independent
        message: "Hello MAD 2 Students",
        myClass: 'green',
        seen: false,
        // seen: true,
        myArr: ["mad1", "mad2", "dbms", "pdsa2", "SC"],
        // movie: "abc", 
        movie: "", 
        firstname: "Shivani",
        lastname: "Varma",
        // fullname: "Shivani Varma"
    },
    // methods:{//manually triggered functions
    //     logMovie: function(){
    //         console.log(this.movie)
    //     }
    // },
    computed: { //derived properties
        fullname: function(){
            return this.firstname + " " + this.lastname
        },
        sequel: function(){
            return this.movie+" "+ 2 
        }
    },
    watch:{
        // movie(){
        //     console.log("movie has changed")
        // },
        movie(new_value,old_value){
        // movie(old_value,new_value){
            console.log(`movie has changed from ${old_value} to ${new_value}`)
        }

    } 

})
// const app =new Vue({}) >>> app = Flask()

// const myObj = {
//         name:"Vishal",       >custom object(data structure)
//         age:20
//     }
    

//such properties which are dependent on existing data properties are called as computed properties, they get re-rendered as and when the dependent data property changes,UI reacts to it 

//UI = F(current state)= F(current values of data property)> Reactivity- ability of HTML to react, as and when the data property changes
//maths> y=x+2, y=f(x) 
//watcher looks for a change in the existing property