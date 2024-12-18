package com.example.foodrecipe.presentation.componants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.ui.theme.Black
import com.example.foodrecipe.ui.theme.Gray2
import com.example.foodrecipe.ui.theme.Gray3
import com.example.foodrecipe.ui.theme.Secondary100

@Preview(showBackground = true)
@Composable
fun OrWith(text: String = "Or with") {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .width(50.dp),
            color = Gray3
        )
        Spacer(Modifier.width(16.dp))
        Text(text, color = Gray3, fontWeight = FontWeight.Normal, fontSize = 14.sp)
        Spacer(Modifier.width(16.dp))
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .width(50.dp),
            color = Gray3
        )
    }
}

@Composable
fun ScreenTitle(
    title: String,
    titleFontSize: Int,
    subtitle: String,
    subtitleFontSize: Int,
) {
    Column(horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth(0.70F)) {
        Text(
            title,
            fontWeight = FontWeight.Bold,
            fontSize = titleFontSize.sp,
            textAlign = TextAlign.Start
        )
        Text(
            subtitle,
            fontWeight = FontWeight.Normal,
            fontSize = subtitleFontSize.sp,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun LoginRedirect(onLoginClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            "Already a member?",
            fontSize = 12.sp,
            color = Black,
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = onLoginClick) {
            Text(
                "Login",
                fontSize = 12.sp,
                color = Secondary100,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SignupRedirect(onSignupClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            "Already a member?",
            fontSize = 12.sp,
            color = Black,
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = onSignupClick) {
            Text(
                "Sign up",
                fontSize = 12.sp,
                color = Secondary100,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun RecipeTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ChefNameAndFollowers(chefName: String, followers: Int) {
    Column {
        Text(
            chefName
        )
        Text(
            "$followers followers",
            color = Gray2,
            fontSize = 12.sp
        )
    }
}

@Composable
fun SearchResultsHeader(resultsCount: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text("Search Result", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        Text(
            "$resultsCount results",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Gray3
        )
    }
}