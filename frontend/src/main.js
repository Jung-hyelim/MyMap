// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'

Vue.prototype.$axios = axios

Vue.config.productionTip = false

export const eventBus = new Vue({
  methods: {
    selectPlace (x, y, name, address, placeUrl) {
      this.$emit('selectPlace', x, y, name, address, placeUrl)
    }
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
