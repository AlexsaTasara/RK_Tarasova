package com.example.rk_tarasova

public class Model{
    lateinit var title:String
    lateinit var name:String
    lateinit var author:String

    constructor(name: String, author:String,title:String) {
        this.title = title
        this.name = name
        this.author = author
    }

    constructor()
}