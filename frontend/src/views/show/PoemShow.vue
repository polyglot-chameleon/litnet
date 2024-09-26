<script setup lang="ts">
import { usePoemStore } from '@/stores/poems'
import { onMounted, watch } from 'vue'
import { useRoute } from 'vue-router'

const { id } = defineProps({ id: String })

const route = useRoute()
const store = usePoemStore()

onMounted(() => store.getPoemById(id!))
watch(route, () => store.getPoemById(id!))
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
