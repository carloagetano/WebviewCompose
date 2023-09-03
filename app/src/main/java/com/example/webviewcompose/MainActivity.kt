package com.example.webviewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.webviewcompose.ui.theme.WebviewComposeTheme
import com.example.webviewcompose.webview.CustomTabsComponent
import com.example.webviewcompose.webview.WebviewComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebviewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WebviewContent()
                }
            }
        }
    }
}

@Composable
fun WebviewContent() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        //UriHandlerComponent()
        //WebviewComponent()

        //Google Custom Tabs
        CustomTabsComponent()
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WebviewContentPreview() {
    WebviewComposeTheme {
        WebviewContent()
    }
}