package com.neonstudio.jetpackcomposepractice._6List_or_LazyColumn

import com.neonstudio.jetpackcomposepractice.R

data class Dataclass(val img: Int, val title: String, val subtitle: String)


fun getDataList(): MutableList<Dataclass>{

    val list = mutableListOf<Dataclass>()
    list.add(Dataclass(R.drawable.heart, "Programmnig",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Tech",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Full",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Dev",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "AI",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "ML",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Stack",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "HELLO",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Programmnig",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Tech",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Full",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Dev",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "AI",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "ML",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Stack",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "HELLO",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Programmnig",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Tech",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Full",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Dev",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "AI",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "ML",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "Stack",  "Learn Different Languages"))
    list.add(Dataclass(R.drawable.heart, "HELLO",  "Learn Different Languages"))


    return list
}