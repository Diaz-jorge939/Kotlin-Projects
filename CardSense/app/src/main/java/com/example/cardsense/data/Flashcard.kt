package com.example.cardsense.data

import java.io.Serializable

class Flashcard(private var front: String, private var back: String) : Serializable{

    fun setFront(text: String){
        this.front = text
    }

    fun getFront(): String{
        return this.front
    }

    fun setBack(text: String){
        this.back = text
    }

    fun getBack(): String{
        return this.back
    }
}
