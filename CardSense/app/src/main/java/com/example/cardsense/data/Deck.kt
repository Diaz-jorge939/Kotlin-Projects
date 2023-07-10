package com.example.cardsense.data
import java.io.Serializable

class Deck(private var name: String) : Serializable{
    private var card_count = 0
    private val deck: MutableList<Card> = mutableListOf()

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
    fun addCard(card: Card) {
        deck.add(this.card_count,card)
        this.card_count++
    }
    fun removeCard(position: Int){
        deck.removeAt(position)
        this.card_count--
    }

}