package com.example.travelinspirations


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter


@Composable
fun HomeScreen(destinations: List<Destination>, onDestinationClick: (Destination) -> Unit) {
    LazyColumn {
        items(destinations) { destination ->
            DestinationItem(destination, onDestinationClick)
        }
    }
}

@Composable
fun DestinationItem(destination: Destination, onClick: (Destination) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick(destination) },
        elevation = 4.dp
    ) {
        Row {
            Image(
                painter = rememberImagePainter(data = destination.imageUrl),
                contentDescription = destination.name,
                modifier = Modifier.size(100.dp)
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(destination.name, style = MaterialTheme.typography.h6)
                Text(destination.description, style = MaterialTheme.typography.body2)
            }
        }
    }
}