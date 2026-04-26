import CartItem from "./CartItem.js";

export default {
  template: `
      <div class="main-body">
        <h2>Main Body</h2>
        <CartItem v-on:add-to-cart="emitAddToCartGrandpa" itemName="Grape" itemEmoji="🍇" :price="10"></CartItem>
        <CartItem v-on:add-to-cart="emitAddToCartGrandpa" itemName="'Carrot'" itemEmoji="🥕" :price="15"></CartItem>
      </div>
    `,
  data() {
    return {
      name: "meao",
    };
  },
  methods: {
    emitAddToCartGrandpa() {
      this.$emit("add-to-cart");
    },
  },
  components: {
    CartItem,
  },
};
