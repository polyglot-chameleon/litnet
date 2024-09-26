<script lang="ts" setup>
import SearchField from '../search/SearchField.vue'
</script>

<template>
  <aside>
    hover me

    <section>
      <RouterLink to="/">Home</RouterLink>

      <SearchField />
    </section>
  </aside>
</template>

<style lang="css" scoped>
@import 'SideBar.css';
</style>
