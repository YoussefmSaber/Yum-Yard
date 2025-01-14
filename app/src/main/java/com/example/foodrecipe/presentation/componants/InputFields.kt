package com.example.foodrecipe.presentation.componants

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Ingredients-mix`
import com.example.foodrecipe.common.assets.icons.Measure
import com.example.foodrecipe.common.assets.icons.Message
import com.example.foodrecipe.common.assets.icons.Password
import com.example.foodrecipe.common.assets.icons.Profile
import com.example.foodrecipe.common.assets.icons.`Search-outline`
import com.example.foodrecipe.presentation.componants.input.CustomOutlinedTextField
import com.example.foodrecipe.presentation.componants.input.IngredientInput
import com.example.foodrecipe.ui.theme.Gray1
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.Gray4
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.White


@Composable
fun IngredientInputRow(
    ingredient: String,
    measure: String,
    onIngredientChange: (String) -> Unit,
    onMeasureChange: (String) -> Unit,
    onAddClick: () -> Unit,
) {
    Row(verticalAlignment = Alignment.Bottom) {
        IngredientInput(
            "Ingredient",
            ingredient,
            onIngredientChange,
            icon = Iconly.`Ingredients-mix`,
            modifier = Modifier.weight(3f)
        )
        Spacer(Modifier.width(16.dp))
        IngredientInput(
            "Measure",
            measure,
            onMeasureChange,
            icon = Iconly.Measure,
            modifier = Modifier.weight(2f)
        )
        Spacer(Modifier.width(16.dp))
        Card(
            modifier = Modifier.weight(1f),
            onClick = onAddClick,
            shape = RoundedCornerShape(25),
            colors = CardDefaults.cardColors(
                contentColor = White,
                containerColor = Primary100,
                disabledContainerColor = Gray1,
                disabledContentColor = Gray4
            )
        ) {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = "Add Ingredient",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun SignupInputFields(
    nameState: MutableState<String>,
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
    confPasswordState: MutableState<String>,
) {
    CustomOutlinedTextField(
        label = "Name",
        placeholder = "Enter Name",
        icon = Iconly.Profile,
        inputValue = nameState.value,
        onValueChange = { nameState.value = it },
        isPassword = false
    )
    CustomOutlinedTextField(
        label = "Email",
        placeholder = "Enter Email",
        icon = Iconly.Message,
        inputValue = emailState.value,
        onValueChange = { emailState.value = it },
        isPassword = false
    )
    CustomOutlinedTextField(
        label = "Password",
        placeholder = "Enter Password",
        icon = Iconly.Password,
        inputValue = passwordState.value,
        onValueChange = { passwordState.value = it },
        isPassword = true
    )
    CustomOutlinedTextField(
        label = "Confirm Password",
        placeholder = "Retype Password",
        icon = Iconly.Password,
        inputValue = confPasswordState.value,
        onValueChange = {
            confPasswordState.value = it
            if (confPasswordState.value != passwordState.value) {
                Log.d("TAG", "Passwords do not match")
            }
        },
        isPassword = true
    )
}

@Composable
fun LoginInputFields(
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
) {
    CustomOutlinedTextField(
        label = "Email",
        placeholder = "Enter Email",
        icon = Iconly.Message,
        inputValue = emailState.value,
        onValueChange = { emailState.value = it },
        isPassword = false
    )
    CustomOutlinedTextField(
        label = "Password",
        placeholder = "Enter Password",
        icon = Iconly.Password,
        inputValue = passwordState.value,
        onValueChange = { passwordState.value = it },
        isPassword = true
    )
}

@Composable
fun OTPTextField(
    otpValue: MutableState<String>,
) {
    BasicTextField(
        value = otpValue.value,
        onValueChange = {
            if (it.length <= 6) {
                otpValue.value = it
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        modifier = Modifier.fillMaxWidth(),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(6) { index ->
                    val char = when {
                        index >= otpValue.value.length -> ""
                        else -> otpValue.value[index].toString()
                    }
                    val isFocused = otpValue.value.length == index
                    Text(
                        text = char,
                        modifier = Modifier
                            .border(
                                if (isFocused) 2.dp
                                else 1.dp,
                                if (isFocused) Primary100 else Gray3,
                                RoundedCornerShape(25)
                            )
                            .width(50.dp)
                            .height(55.dp)
                            .padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.width(8.dp))
                }
            }
        }
    )
}

@Composable
fun SearchInputField(
    searchQuery: String = "",
    onQueryChanged: (String) -> Unit = {},
    navigateToSearch: () -> Unit = {},
    maxWidth: Float = 0.8F,
) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = onQueryChanged,
        maxLines = 1,
        modifier = Modifier
            .background(White, shape = RoundedCornerShape(25))
            .fillMaxWidth(maxWidth)
            .clickable {
                navigateToSearch()
            },
        textStyle = TextStyle(fontWeight = FontWeight.Normal),
        shape = RoundedCornerShape(25),
        colors = OutlinedTextFieldDefaults.colors(
            focusedLeadingIconColor = Primary100,
            unfocusedLeadingIconColor = Gray3,
            focusedBorderColor = Primary100,
            unfocusedBorderColor = Gray3,
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        placeholder = {
            Text(
                "Search recipe",
                fontWeight = FontWeight.Normal,
                color = Gray3
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Iconly.`Search-outline`,
                contentDescription = "Search icon",
            )
        },
    )
}