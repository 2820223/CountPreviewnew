package shamsiddin.project.myapplicationnew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shamsiddin.project.myapplicationnew.ui.theme.MyApplicationnewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationnewTheme { //package name
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), //


                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    countPreview()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )

}

@Preview(showBackground = true)
@Composable
fun countPreview(){
    var num= remember{ mutableStateOf(0)    }

    Row(
        modifier=Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically

    ) {
         var  image: Painter = painterResource(R.drawable.ic_launcher_background)

        if(num.value>0){
            image= painterResource(id = R.drawable.ic_launcher_foreground)

        }
        else{
            image= painterResource(id =R.drawable.ic_launcher_background)
        }


        Column(
            modifier=Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
             text = "Number : ${num.value} ",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold

         )

            Row(

            ) {
                Button(
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        num.value--
                    }) {
                    Text(
                        text = "-",

                    )
                }

                Button(
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        num.value++
                    }) {
                    Text(
                        text = "+",

                    )
                }
            }

            Button(
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.Blue),
                onClick = {
                    num.value=0
                }) {
                Text(
                    text = "Reset",

                )
            }

        }

    }



}

@Composable
fun GreetingPreview() {
    MyApplicationnewTheme {
        Greeting("Android")
    }
}