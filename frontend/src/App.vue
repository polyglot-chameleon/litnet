<script setup lang="ts">
import { RouterView } from 'vue-router'
import Sidebar from './components/Sidebar.vue'
</script>

<template>
  <main>
    <RouterView />
  </main>

  <Sidebar />
</template>
