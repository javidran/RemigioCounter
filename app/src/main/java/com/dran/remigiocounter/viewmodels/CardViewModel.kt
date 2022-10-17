package com.dran.remigiocounter.viewmodels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.dran.remigiocounter.datasource.Card

class CardModelView : ViewModel() {
    private val _cardList = getCards().toMutableStateList()

    val cardList: List<Card>
        get() = _cardList

    fun onCountIncrement(card: Card) {
        _cardList.find { it.number == card.number }?.let { item -> item.count += 1 }
    }

    fun onCountDecrement(card: Card) {
        _cardList.find { it.number == card.number }?.let { item -> item.count -= 1 }
    }
}

private fun getCards() = List(12) { i -> Card(i + 1) }