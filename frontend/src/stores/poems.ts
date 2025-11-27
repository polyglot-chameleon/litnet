import { defineStore } from 'pinia'
import { ref } from 'vue'
import { initPoem, type Poem } from './Poem'

export const usePoemStore = defineStore('poems', () => {
  const poems = ref<Poem[]>([])
  const currentPoem = ref<Poem>(initPoem)
  const searchResults = ref<Poem[]>([])
  const searchTerm = ref<string>('')

  const getNextPoem = async () => {
    const resp = await fetch('/poems/next', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(currentPoem.value)
    })
    const freshPoem = await resp.json()
    poems.value.push(freshPoem)
    currentPoem.value = freshPoem
  }

  const searchPoem = async (term: string) => {
    searchTerm.value = term

    const resp = await fetch(`/poems/search`, {
      method: 'post',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ content: [term] } satisfies Partial<Poem>)
    })
    searchResults.value = await resp.json()
  }

  return { poems, getNextPoem, currentPoem, searchTerm, searchResults, searchPoem }
})
