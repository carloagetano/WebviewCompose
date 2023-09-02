package com.example.webviewcompose.webview

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebviewComponent(
    modifier: Modifier = Modifier
) {

    var isClicked by rememberSaveable {
        mutableStateOf(false)
    }

    val annotatedLink = buildAnnotatedString {

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
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableText(
            text = annotatedLink,
            onClick = {
                isClicked = true
            },
            style = MaterialTheme.typography.bodyLarge
        )
    }

    if (isClicked) {
        loadWebUrl(url = "https://www.google.com/")
    }
}

@Composable
fun loadWebUrl(url: String) {

    AndroidView(factory = {
        WebView(it).apply {
            webViewClient = WebViewClient()

            loadUrl(url)
        }
    }, update = { webview -> webview.loadUrl(url) })

}