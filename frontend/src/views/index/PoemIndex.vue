<script setup lang="ts">
import { usePoemStore } from '@/stores/poems'
import { onMounted } from 'vue'

const store = usePoemStore()

onMounted(() => store.getAllPoems())
</script>

<template>
  <article class="index" v-for="poem in store.poems" :key="poem.id">
    <RouterLink :to="{ name: 'show', params: { id: poem.id } }"
      ><h2>{{ poem.title }}</h2></RouterLink
    >
    <em>{{ poem.author.fullName }}</em>
    <em v-for="concept in poem.concepts" :key="concept.id">{{ concept.name }}</em>

    <details>
      <summary>🔎</summary>
      <p>{{ poem.feature }}</p>
    </details>
  </article>
</template>

<style lang="css" scoped>
@import 'PoemIndex.css';
</style>
