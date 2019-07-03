import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const Keyword = () => import('@/components/Keyword')
const Top10 = () => import('@/components/Top10')
const History = () => import('@/components/History')

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: Keyword
    },
    {
      path: '/keyword',
      name: 'Keyword',
      component: Keyword
    },
    {
      path: '/top10',
      name: 'Top10',
      component: Top10
    },
    {
      path: '/history',
      name: 'History',
      component: History
    }
  ]
})
