package com.example.foodrecipe.presentation.componants

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Arrow-down`
import com.example.foodrecipe.common.assets.icons.`Arrow-up`
import com.example.foodrecipe.ui.theme.Black
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownField(
    label: String,
    modifier: Modifier = Modifier,
    defaultValue: String,
    available: List<String>,
    getCurrent: (String) -> Unit = {},
) {
    val selectedOption = remember { mutableStateOf(defaultValue) }
    val isExpanded = remember { mutableStateOf(false) }
    Column {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Black,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(Modifier.height(8.dp))
        ExposedDropdownMenuBox(
            expanded = isExpanded.value,
            onExpandedChange = { isExpanded.value = !isExpanded.value },
            modifier = Modifier.clip(RoundedCornerShape(12.dp)),
        ) {
            TextField(
                value = selectedOption.value,
                modifier = modifier
                    .menuAnchor(
                        type = MenuAnchorType.PrimaryNotEditable,
                        enabled = true
                    )
                    .border(
                        width = if (isExpanded.value) 2.dp else 1.dp,
                        color = if (isExpanded.value) Primary100 else Gray3,
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    Icon(
                        if (isExpanded.value) Iconly.`Arrow-up` else Iconly.`Arrow-down`,
                        contentDescription = "Drop down icon"
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            ExposedDropdownMenu(
                expanded = isExpanded.value,
                onDismissRequest = { isExpanded.value = false },
                shape = RoundedCornerShape(12.dp),
                containerColor = White
            ) {
                available.forEachIndexed { _, text ->
                    DropdownMenuItem(
                        text = { Text(text) },
                        onClick = {
                            selectedOption.value = text
                            getCurrent(text)
                            isExpanded.value = false
                        }
                    )
                }
            }
        }
    }
}