package com.example.introducaojetpack2

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introducaojetpack2.ui.theme.DebugButtonColors
import com.example.introducaojetpack2.ui.theme.ErrorButtonColors
import com.example.introducaojetpack2.ui.theme.InfoButtonColors
import com.example.introducaojetpack2.ui.theme.IntroducaoJetPack2Theme
import com.example.introducaojetpack2.ui.theme.WarningButtonColors
import java.lang.Exception

const val TAG = "TestAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    IntroducaoJetPack2Theme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting(name = "JetPack")
                ActionButton(
                    text = "Debug",
                    buttonColors = DebugButtonColors(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ){
                    Log.d(TAG, "APP: Clicou en Debug")
                }
                ActionButton(
                    text = "Info",
                    buttonColors = InfoButtonColors(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ){
                    Log.i(TAG, "APP: Clicou em Info")
                }
                ActionButton(
                    text = "Warning",
                    buttonColors = WarningButtonColors(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ){
                    Log.w(TAG, "APP: Clicou em Warning")
                }
                ActionButton(
                    text = "Error",
                    buttonColors = ErrorButtonColors(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ){
                    try {
                        throw RuntimeException("Clicou em Error")
                    }catch (ex: Exception){
                        Log.e(TAG,  "${ex.message}")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 400)
@Composable
fun AppPreview(){
    App()
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable()
fun ActionButtonPreview(){
    ActionButton(text = "Cadastrar"){

    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroducaoJetPack2Theme {
        Greeting("Android")
    }
}