import { defineStore } from 'pinia'
import { ref } from 'vue'
import { initPoem, type Poem } from './Poem'

export const usePoemStore = defineStore('poems', () => {
  const poems = ref<Poem[]>([])
  const currentPoem = ref<Poem>(initPoem)
  const searchResults = ref<Poem[]>([])
  const searchTerm = ref<string>("")


  const getAllPoems = async () => {
    const resp = await fetch(`${import.meta.env.VITE_API_URL}/poems`)
    poems.value = await resp.json()
  }

  const getPoemById = async (id: string ) => {
      poems.value.length ? currentPoem.value = poems.value.find(p => p.id === id)! : fetch(`${import.meta.env.VITE_API_URL}/poems/${id}`).then(resp => resp.json()).then(data => currentPoem.value = data)
  }

  const searchPoem = async (term: string) => {
    searchTerm.value = term

    const resp = await fetch(`${import.meta.env.VITE_API_URL}/poems/search`, {method: "post", headers: {
      'Content-Type': 'application/json'
    }, body: JSON.stringify({content: term} satisfies Partial<Poem>)})
    searchResults.value = await resp.json()
  }

  return { poems, getAllPoems, currentPoem, getPoemById, searchTerm, searchResults, searchPoem }
})

