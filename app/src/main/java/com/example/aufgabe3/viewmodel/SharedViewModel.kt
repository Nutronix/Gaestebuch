package com.example.aufgabe3.viewmodel

import androidx.lifecycle.ViewModel
import com.example.aufgabe3.model.BookingEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SharedViewModel : ViewModel() {
    private val _bookingsEntries = MutableStateFlow<List<BookingEntry>>(emptyList())
    val bookingsEntries: StateFlow<List<BookingEntry>> = _bookingsEntries

    fun addBookingEntry(bookingEntry: BookingEntry) {
        val currentList = _bookingsEntries.value.toMutableList()
        // Neues Buch hinzufügen
        currentList.add(bookingEntry)
        // Liste aktualisieren
        _bookingsEntries.value = currentList
    }

    fun deleteBookingEntry(bookingEntry: BookingEntry) {
        val currentList = _bookingsEntries.value.toMutableList()
        currentList.remove(bookingEntry)
        _bookingsEntries.value = currentList
    }
}