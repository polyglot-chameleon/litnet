<script setup lang="ts">
import { usePoemStore } from '@/stores/poems'
import { onMounted } from 'vue'

const store = usePoemStore()

onMounted(() => {
  store.getNextPoem()

  window.addEventListener('scroll', () => {
    Math.abs(
      document.documentElement.scrollHeight -
        (document.documentElement.scrollTop + window.innerHeight)
    ) <= 10 && store.getNextPoem()
  })
})
</script>

<template>
  <article class="index" v-for="poem in store.poems" :key="poem.id">
    <h3>{{ poem.title }}</h3>
    <em>{{ poem.author.fullName }}</em
    ><br />
    <span v-for="concept in poem.concepts" :key="concept.id">{{ concept.name }}</span>

    <p v-for="paragraph in poem.content" :key="paragraph">{{ paragraph }}</p>
  </article>
</template>

<style lang="css" scoped>
@import 'PoemIndex.css';
</style>
