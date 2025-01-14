package com.example.foodrecipe.presentation.componants.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.ui.theme.Black
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.Gray4
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.White

@Composable
fun IngredientInput(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    icon: ImageVector,
    modifier: Modifier,
) {
    var isFocused by remember { mutableStateOf(false) }
    val colorAnimate by animateColorAsState(targetValue = if (isFocused) Primary100 else Gray3)
    val borderWidth by animateDpAsState(targetValue = if (isFocused) 2.dp else 1.dp)

    Column(modifier = modifier) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = colorAnimate,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.Bottom) {
            Card(
                border = BorderStroke(
                    borderWidth,
                    colorAnimate
                ),
                shape = RoundedCornerShape(25),
                colors = CardDefaults.cardColors(
                    containerColor = White,
                    disabledContainerColor = Gray1,
                    disabledContentColor = Gray4
                ),
                modifier = Modifier.animateContentSize() // Smooth transition for border color change
            ) {
                Row(
                    Modifier
                        .padding(16.dp)
                        .focusable() // Ensures focus interaction
                        .onFocusChanged { focusState ->
                            isFocused = focusState.isFocused
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "$icon Ingredient",
                        modifier = Modifier.size(24.dp),
                        tint = colorAnimate
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    BasicTextField(
                        value = value,
                        onValueChange = onValueChange,
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Black
                        ),
                        modifier = Modifier
                            .onFocusChanged { focusState ->
                                isFocused = focusState.isFocused
                            }
                    )
                }
            }
        }
    }
}