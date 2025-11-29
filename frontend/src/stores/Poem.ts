interface withId {
  elementId: string
}

export type Poem = {
  title: string
  feature: string
  content: string[]
  author: Author
  concepts: Concept[]
} & withId

export const initPoem = {
  elementId: '',
  title: '',
  feature: '',
  content: [],
  author: { fullName: '', elementId: '' },
  concepts: []
} satisfies Poem

export type Author = {
  fullName: string
} & withId

type Concept = {
  name: string
} & withId
