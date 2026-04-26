<script>
import SubComp from './SubComp.vue';
export default {
    name: "FirstComp",
    data: function() {
        return {
            message: "This is my First Vue Component"
        }
    },
    components: {
        SubComp
    }
}
</script>

<template>
    <div id="comp-div">
        <h1>{{ message }}</h1>
        <h2>I am using vue cli</h2>
        <SubComp />
    </div>
</template>

<style scoped>
    div{
        border: 2px solid whitesmoke;
        border-radius: 10px;
        padding: 5px;
    }
    h1{
        color: blueviolet;
    }
    h2{
        color: coral;
    }
</style>