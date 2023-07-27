package com.example.travelinspirations

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun DestinationDetailsScreen(destination: Destination) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberImagePainter(destination.imageUrl),
            contentDescription = destination.name,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = destination.name, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = destination.description)
    }
}

@Preview(showBackground = true)
@Composable
fun DestinationDetailsScreenPreview() {
    val sampleDestination = Destination(
        id = 1,
        name = "Sample Destination",
        description = "A beautiful place to visit.",
        imageUrl = "https://example.com/image.jpg"
    )
    DestinationDetailsScreen(sampleDestination)
}
