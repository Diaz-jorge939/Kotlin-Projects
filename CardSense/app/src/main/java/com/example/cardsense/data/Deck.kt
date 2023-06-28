package com.example.cardsense.data

class Deck(private val name: String) {
    private val card_count = 0

    fun getCardCount(): Int {
        return this.card_count
    }
    fun getDeckName(): String {
        return this.name
    }


}