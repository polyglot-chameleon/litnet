interface withId {
  id: string;
}

export type Poem = {
  title: string;
  feature: string;
  content: string;
  author: Author;
  concepts: Concept[];
} & withId;

export const initPoem = {
  id: "",
  title: "",
  feature: "",
  content: "",
  author: {fullName: "", id: ""},
  concepts: []
} satisfies Poem

type Author = {
  fullName: string;
} & withId;

type Concept = {
  name: string;
} & withId;
