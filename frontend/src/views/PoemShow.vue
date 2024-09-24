<script setup lang="ts">
import { usePoemStore } from '@/stores/poems'
import { onMounted } from 'vue'

const props = defineProps({
  id: String
})

const store = usePoemStore()

onMounted(() => store.getPoemById(props.id!))
</script>

<template>
  <article>
    <header>
      <h2>{{ store.currentPoem.title }}</h2>
      <em>by {{ store.currentPoem.author.fullName }}</em
      ><br />
      <em v-for="concept in store.currentPoem.concepts" :key="concept.id">{{ concept.name }}</em>
    </header>

    <p>{{ store.currentPoem.content }}</p>
  </article>
</template>
