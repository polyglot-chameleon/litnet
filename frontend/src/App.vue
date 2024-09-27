<script lang="ts" setup>
import { RouterView } from 'vue-router'
import Sidebar from './components/sidebar/SideBar.vue'
</script>

<template>
  <main>
    <RouterView />
  </main>

  <Sidebar />
</template>
