<script setup lang="ts">
import { usePoemStore } from '@/stores/poems'
import { onMounted } from 'vue'

const store = usePoemStore()

onMounted(() => store.getAllPoems())
</script>

<template>
  <main>
    <ol>
      <li v-for="poem in store.poems" :key="poem.title">
        {{ poem.title }}
      </li>
    </ol>
  </main>
</template>
