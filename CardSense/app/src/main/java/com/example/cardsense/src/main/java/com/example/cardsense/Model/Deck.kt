package com.example.cardsense.Model
import java.io.Serializable

class Deck(private var name: String) : Serializable{
    private var card_count = 0
    private var deck: MutableList<Card> = mutableListOf()

    fun setDeckName(name: String){
        this.name = name
    }
    fun getCardCount(): Int {
        return this.card_count
    }
    fun getDeckName(): String {
        return this.name
    }
    fun getDeck() : List<Card> {
        return deck
    }
    fun getSize() : Int {
        return deck.size
    }
    fun addCard(front_text: String, back_text: String){
        deck.add(this.card_count,Card(front_text,back_text))
        this.card_count++
    }

    fun removeCard(position: Int){
        deck.removeAt(position)
        this.card_count--
    }

    fun display() {
        for (card in deck){
            println("front: ${card.getFront()}, back: ${card.getBack()}")
        }
    }
}