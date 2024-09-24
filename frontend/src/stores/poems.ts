import { defineStore } from 'pinia'
import { ref } from 'vue'
import type { Poem } from './Poem'

export const usePoemStore = defineStore('poems', () => {
  const poems = ref<Poem[]>([])
  const currentPoem = ref<Poem>({id: "", title: "", content: "", author: {id: "", fullName: ""}, concepts: []})

  const getAllPoems = async () => {
    const resp = await fetch(`${import.meta.env.VITE_API_URL}/poems`)
    poems.value = await resp.json()
  }

  const getPoemById = async (id: string ) => {
    const resp = await fetch(`${import.meta.env.VITE_API_URL}/poems/${id}`)
    currentPoem.value = await resp.json()
  }

  return { poems, currentPoem, getAllPoems, getPoemById }
})

