import MainBody from "./components/MainBody.js";
import Navbar from "./components/Navbar.js";
import store from "./store.js";

new Vue({
  el: "#app",
  template: `
      <div class="root">
      <div class="main-container">
        <Navbar ></Navbar>
        <MainBody ></MainBody>
        </div>
      </div>
    `,
  data() {
    return {
      cartItemCount: 0,
    };
  },
  methods: {
    incrementCart() {
      this.cartItemCount++;
    },
  },
  components: {
    MainBody: MainBody,
    Navbar,
  },
  store: store, // creates(injects) $store, accessible in different components
});
