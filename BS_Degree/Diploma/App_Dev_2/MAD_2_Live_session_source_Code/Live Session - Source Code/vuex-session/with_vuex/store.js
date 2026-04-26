const store = new Vuex.Store({
  // how to use
  // $store.state.cart_items
  state: {
    cart_items: 0,
  },
  getters: {
    // how to use
    // $store.getters.emoji_items
    emoji_items(state) {
      if (state.cart_items == 0) return "😓";
      else if (state.cart_items < 10) return "☺️";
      else return "🥰";
    },
  },
  mutations: {
    // how to use
    // $store.commit("increment_cart_items", 10)
    // only sync
    increment_cart_items(state, value) {
      if (!value) {
        state.cart_items += 1;
      } else {
        state.cart_items += value;
      }
    },
  },
  actions: {
    // how to use
    // $store.dispatch("increment_delayed")
    // sync or async
    // async increment_delayed({commit}){
    increment_delayed(context) {
      // fetch
      //   await fetch();
      // can do more here
      setTimeout(() => {
        context.commit("increment_cart_items", 10);
      }, 5000);
    },
  },
});

export default store;
