// ================== Mock questions ====================
// Q1
// const a = {
//     x1: 10,
//     func1: function(){
//         let arrowF = () => {
//             console.log(this.x1)
//         }
//         let x1 = 20;
//         console.log(this.x1)   
//     }
// }


// console.log(a.func1()) context is retained

// let c = a.func1 // context is lost
// console.log(c) // this will not work
// c()

// const b = {
//     x1: 20,
//     func2: function(){
//         let c =  a.func1; // --> function
//         c(20)
//         // c.apply(b) // --> context, [parameters]   this.x1 ===> b.x1 == 20
//         // c.bind(d, 30)() // --> context, comma separated parameters , call the function
//         // c.bind(d)(30) // --> context, comma separated parameters , call the function
//         // c.call(d, 30)
//     }
// }

// b.func2()


// const d = {
//     x1: 40
// }

// let c = a.func1
// c.apply(d)

// b.func2()



// Q2 

// var x1 = 25;

// const a = {
//     x1: 10,
//     func1: function(){
//         console.log("1 ", this.x1)
//         console.log("2 ", x1)
//     }
    
// }

// a.func1()
// let c =  a.func1;
// c.apply(a)

// const b = {
//     x1: 20,
//     func2: function(){
//         let c =  a.func1;
//         c.apply()
//     }
// }

// b.func2()

// Q3
// let global = {
//     x: 5
// }

// var x = 5; //---> global variable and it is also stored as property of gobal this
// // let x = 10; //--> global variable

// function abd(){
//     var y = 10;
// }

// let obj1 = {
//     'x': 10,
//     func : (x)=>{ // --> global object
//         this.x = x; // ==> uses the property
//     }
// }

// let obj2 = {
//     'x': 30,
//     func : (x)=>{ // --> global object
//         this.x = x; // ==> uses the property
//     }
// }

// let c = obj2.func 
// c.apply([25]) //do not apply for arrow function

// in case of an arrow function, the "this" refers to global object

// obj1.func(20); // context is not lost
// let c = obj.func // context is lost
// console.log(x, 'and', obj1.x)  // 20 and 10, 5 and 10, 5 and 20,
// console.log(window.x) 

// const obj = {
//     name: "abc",
//     arrowFunc: null,
//     normalFunc: function (){
//         this.arrowFunc = ()=> {
//             console.log(this.name)
//         }
//         this.arrowFunc()
//     }

// }
// obj.normalFunc();
// console.log("hello")

// Q5

// {
//     var x = 5;
//     console.log(x);
//     var x = 10;
//     console.log(x)
// }

// Q6
// const a = new Vue({
//     el: '#app1',
//     data: {
//         message1: "Abhishek",
//         message2: "{{ message2 }}",
//     }
//   })

// const b = new Vue({
//     el: '#app2',
//     data: {
//         message2: "Rajput",
//     }
//   })
// var c = 100
// var b = "Happy Diwali"

// let x1 = {
//     'a': 5,
//     'b': 'hello',
//     'add': function () {
//         return this.b +" Diya";
//     }
// }

// let x2 = {
//     'a': 5,
//     'b': 'Welcome',
//     'add': function (x) {
//         return this.a + " "  + x;
//     }
// }
// let y = x1.add // context lost
// console.log(y.call());
// console.log(y.apply());
// console.log(x2.add("Diya"))
// y.call(x2, "Diya")

// Welcome Diya

// const apple = {
//     template: "<h1>Apple Count: {{apple_count}}, {{banana_count}}</h1>",
//     props: ["apple_count"],
//     data: function(){
//         return {
//             banana_count : 100
//         }
//     }
// }

// Vue.component('apple', {
//     template: "<h1>Apple Count: {{apple_count}}, {{banana_count}}</h1>",
//     props: ["apple_count"],
//     data: function(){
//         return {
//             banana_count : 100
//         }
//     }
// })

// const app = new Vue({
//     el: '#app',
    // components: {
    //     apple: apple
    // }
// })

// condition ? do this : do that
{/* <apple v-bind="apple_count"></apple> */}

// total_fruits 10 click 21 click 32 click 43 (21, 22)





// Q7

// let x1 = {
//     'a': 5,
//     'b': 'Hello',
//     'add': (x, z)=>{
//         return this.b + " " + x + " " + z;
//     }
// }

// let x2 = {
//     'a': 5,
//     'b': 'Welcome',
//     'add': function(x){
//         return this.a + " " + x;
//     }
// }

// let y = x1.add;
// console.log(y.call(x2, "Diya", "home"))
// console.log(y.apply(x2, ["Diya", "home"]))

// Q8

// let x = {
//     a: [1, 2, 3, 4, 5],
//     b: function(){
//         return [...this.a, 6, 7, 8]
//     }
// }

// // let c = x.b;
// // console.log(c.call(x))

// console.log(x.b())

// Q9
// const courses = [
//     {name:'MAD-I', description:'CSS, HTML, FLASK, API, SQLITE'},
//     {name:'MAD-II', description:'JS, VUEJS, FLASK, API'}
// ]

// function getCourse(){
//     setTimeout(()=>{
//         let allCourses = [];
//         courses.forEach((course, index)=>{
//             allCourses.push(course)
//         })
//         console.log(allCourses)
//     })
// }

// function addCourse(course){
//     setTimeout(()=>{
//         courses.push(course);
//     }, 2000)
// }
// addCourse({name: 'MAD-III', description: "Watch this space!"})
// getCourse()



// var var1 = 20;

// var func = function(){
//   var var2 = 30;
// } 
  
// const var3 = 20;


// p , n , r

// let obj = {
//   si : function simIn(n, r, p){
//     return (p * n * r)/100
//   }
// }

// si_common = obj.si;

// si_common.bind(obj,10)(3, 300000)

// let a = "mad1";
// let b = ""

// let obj1 = {
//   a: 20,
//   b: 30
// }

// let obj2 = {a: 10}

// // // Is ...(a && !b && {obj1}) ==  ...(a && !b && obj1)


// {obj}

// console.log("script starts here")

// console.log(a)
// console.log(c)

// let a = true
// let b = false
// var c = "hello"
// let obj1 = {
//   a: 20,
//   b: 30
// }


// console.log({c: 40, ...(a && !b && {obj1})})
// console.log({c: 40, ...(a && !b && obj1)})

// let arr = [1, 2, 3, 4, 5]

// arr.forEach((ele) => console.log(ele));
// arr.map((ele) => console.log(ele));

// for (let ele of arr){
//     console.log(ele)
// }

// let x2 = {
//     'a': 5,
//     'b': 'Welcome',
//     'add': function(x){
//         return this.a + " " + x;
//     }
// }

// function x2() {
//     let a = 5;
//     function add10() {
//         a += 10;
//         return a;
//     }
//     return add10;
// }

// let addTen = x2();
// console.log(addTen())
// console.log(addTen())
// console.log(addTen())

// let obj = {
//     a: "animal",
//     b: "blogs"
// }

// Object.keys(obj) => ['a', 'b']
// Object.values(obj) => ['animal', 'blogs']
// Object.entries(obj) <>
// for [key, val] of Object.entries(obj):

// let { a: A } = obj;
// console.log(obj.a)
// console.log(a)

// let obj2 = {
//     c: "Cat",
//     __proto__: obj,
//     set setName() {

//     },
//     get getName() {

//     }
// }

// obj2.a

// let vuObj = {
//     el: "#app",
//     template: "<h1>Hello Vue!</h1>",
//     data: {
//         key: "value",
//         variable: 10
//     },
//     methods: {
//         myFunc: function() {
//             return this.key
//         }
//     },
//     // myOwn: cannor be done
//     components: {
//         "my-comp": obj2
//     }
// }
// const app = new Vue(vuObj)

// Vue.component("my-comp", {
//     props: [attr],
//     template: "<h1>{{attr}}</h1>",
//     data: function() {
        
//         return {
//             data1: "data1",
//             data2: "data2",
//             data3: "data3"
//         }
//     }
// })

// vuObj.el

var current = [0]

console.log(current[3])
console.log(a)
console.log(`hello this is ${this.current[1]}`)