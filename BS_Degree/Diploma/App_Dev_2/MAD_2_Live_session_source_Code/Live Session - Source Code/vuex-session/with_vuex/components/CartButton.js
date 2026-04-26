export default {
  props: ["count"],
  template: `
      <div class="cart-button">
        <div>{{$store.getters.emoji_items}} </div> 
        <div>{{ $store.state.cart_items }} Items</div>
      </div>
          `,
};
