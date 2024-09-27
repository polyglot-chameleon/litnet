import { createRouter, createWebHistory } from 'vue-router'

export const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'index',
      component: () => import('../views/index/PoemIndex.vue')
    },
    {
      path: '/:id',
      name: 'show',
      component: () => import('../views/show/PoemShow.vue'),
      props: true
    }
  ]
})