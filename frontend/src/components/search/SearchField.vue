<script lang="ts" setup>
import { usePoemStore } from '@/stores/poems'

const store = usePoemStore()

const searchPoem = (event: Event) => {
  const searchTerm = (event.target as HTMLTextAreaElement).value
  searchTerm !== '' && store.searchPoem(searchTerm)
}
</script>

<template>
  <search>
    <input type="text" placeholder="Search poems..." @input="searchPoem($event)" />
  </search>

  <output>
    <span v-if="store.searchResults.length === 0">No results</span>

    <span v-for="result in store.searchResults" :key="result.id">
      <RouterLink :to="{ name: 'show', params: { id: result.id } }">
        <span>{{
          result.content.slice(
            result.content.indexOf(store.searchTerm) - 10,
            result.content.indexOf(store.searchTerm)
          )
        }}</span>
        <span style="color: red">{{
          result.content.slice(
            result.content.indexOf(store.searchTerm),
            result.content.indexOf(store.searchTerm) + store.searchTerm.length
          )
        }}</span>
        <span>
          {{
            result.content.slice(
              result.content.indexOf(store.searchTerm) + store.searchTerm.length,
              result.content.indexOf(store.searchTerm) + store.searchTerm.length + 10
            )
          }}
        </span></RouterLink
      >
      <br
    /></span>
  </output>
</template>

<style lang="css" scoped>
@import 'SearchField.css';
</style>
