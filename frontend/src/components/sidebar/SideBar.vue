<script lang="ts" setup>
import SearchField from '../search/SearchField.vue'
</script>

<template>
  <aside>
    <RouterLink to="/">🏠</RouterLink>

    <section>
      <SearchField />
    </section>
  </aside>
</template>

<style lang="css" scoped>
@import 'SideBar.css';
</style>
