import { defineStore } from 'pinia'
import { ref } from 'vue'

type Poem = {
  title: string
  content: string
}

export const usePoemStore = defineStore('poems', () => {
  const poems = ref<Poem[]>([])

  const getAllPoems = async () => {
    const resp = await fetch(`${import.meta.env.VITE_API_URL}/poems`)
    poems.value = await resp.json()
  }

  return { poems, getAllPoems }
})

