package com.example.cardsense.data

class Deck(private val name: String) {
    private var card_count = 0
    private val deck: MutableList<Flashcard> = mutableListOf()

    fun getCardCount(): Int {
        return this.card_count
    }
    fun getDeckName(): String {
        return this.name
    }
    fun getDeck() : List<Flashcard> {
        return deck
    }
    fun addCard(card: Flashcard) {
        deck.add(this.card_count,card)
        this.card_count++
    }
    fun removeCard(position: Int){
        deck.removeAt(position)
    }

}