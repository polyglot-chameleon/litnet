interface withId {
  id: string;
}

export type Poem = {
  title: string;
  content: string;
  author: Author;
  concepts: Concept[];
} & withId;

type Author = {
  fullName: string;
} & withId;

type Concept = {
  name: string;
} & withId;
