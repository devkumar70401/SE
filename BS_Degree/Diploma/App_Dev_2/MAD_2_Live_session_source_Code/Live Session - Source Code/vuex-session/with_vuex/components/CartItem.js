export default {
  props: ["itemName", "itemEmoji", "price"],
  template: `
    <div class="card">
      <h3 class="item-name">{{ itemName }}</h3>
      <span class="item-emoji">{{ itemEmoji }}</span>
      <p class="price">Price: {{ price }}</p>
      <button class="add-to-cart" @click="$store.commit('increment_cart_items')">Add to Cart</button>
      <button class="add-to-cart" @click="$store.dispatch('increment_delayed')">Slow to Cart</button>
  </div>
  `,
};
