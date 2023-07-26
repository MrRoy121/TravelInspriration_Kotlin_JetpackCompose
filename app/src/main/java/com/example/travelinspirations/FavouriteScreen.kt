package com.example.travelinspirations

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun FavoritesScreen(favorites: List<Destination>, onDestinationClick: (Destination) -> Unit) {
    LazyColumn {
        items(favorites) { destination ->
            DestinationItem(destination, onDestinationClick)
        }
    }
}