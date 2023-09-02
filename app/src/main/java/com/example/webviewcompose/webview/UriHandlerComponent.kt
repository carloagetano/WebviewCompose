package com.example.webviewcompose.webview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun UriHandlerComponent(modifier: Modifier = Modifier) {

    val annotatedLinkString = buildAnnotatedString {
        val link = "google.com"

        val startIndex = link.indexOf(link)
        val endIndex = link.length

        append(link)
        addStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline,
            ),
            start = startIndex,
            end = endIndex
        )

        addStringAnnotation(
            tag = "URL",
            annotation = "https://www.google.com/",
            start = startIndex,
            end = endIndex
        )
    }

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableText(
            text = annotatedLinkString,
            onClick = {
                annotatedLinkString
                    .getStringAnnotations(tag = "URL", it, it)
                    .firstOrNull()?.let { stringAnnotation ->
                        uriHandler.openUri(stringAnnotation.item)
                    }

            },
            style = MaterialTheme.typography.bodyLarge
        )
    }
}