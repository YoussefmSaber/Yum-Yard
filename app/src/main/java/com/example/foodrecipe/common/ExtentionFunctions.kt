package com.example.foodrecipe.common

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter


/**
 * Applies a fading edge effect to a composable using a specified brush.
 *
 * This modifier creates a fading edge by drawing a rectangle with the given brush
 * on top of the composable's content, using a Darken blend mode.
 *
 * @param brush The brush to use for the fading edge.
 * @return A modifier that applies the fading edge effect.
 */
fun Modifier.fadingEdge(brush: Brush) = this
    /**
     *  Apply a graphics layer with offscreen compositing strategy.
     *
     * This ensures that the fading edge is drawn separately and doesn't affect the composable's content.
     */
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
    /**
     * Draw the composable's content and then draw a rectangle with the brush.
     */
    .drawWithContent {
        /**
         * Draw the original content of the composable.
         */
        drawContent()
        /**
         * Draw a rectangle over the content using the provided brush and Darken blend mode.
         * This creates the fading edge effect.
         */
        drawRect(brush = brush, blendMode = BlendMode.Darken, alpha = 0.8F)
    }

/**
 * Constructs the URL for an ingredient image from TheMealDB API.
 *
 * This extension function takes a string representing the ingredient name and
 * appends it to the base URL for ingredient images on TheMealDB. It then
 * adds "-Small.png" to the end to retrieve the small-sized image.
 *
 * @return The URL for the ingredient image.
 */
fun String.ingredientImage(): String =
    "https://www.themealdb.com/images/ingredients/$this-Small.png"

fun String.transformDate(): String {
    // Define the input format to include the timezone
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")

    // Parse the input string to an OffsetDateTime object
    val dateTime = OffsetDateTime.parse(this, inputFormatter)

    // Define the output format
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy - HH:mm")

    // Format the date into the desired format
    return dateTime.format(outputFormatter)
}