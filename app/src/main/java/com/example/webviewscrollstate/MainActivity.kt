package com.example.webviewscrollstate

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.webviewscrollstate.ui.theme.WebViewScrollStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WebViewScrollStateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    val lazyListState = rememberLazyListState()

    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        state = lazyListState,
    ) {
        item {
            Text(
                modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp),
                text = "Header",
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
            )
        }

        item {
            HorizontalDivider()
        }

        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                        .background(Color.Green),
            )
        }

        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                        .background(Color.Red),
            )
        }

        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(175.dp)
                        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                        .background(Color.Blue),
            )
        }

        item {
            WebViewContent(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, top = 8.dp),
            )
        }

        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                        .background(Color.Yellow),
            )
        }

        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                        .background(Color.Cyan),
            )
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewContent(modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            WebView(context).apply {
                webViewClient = object : WebViewClient() {}

                this.settings.javaScriptEnabled = true

                isVerticalScrollBarEnabled = false
                setBackgroundColor(Color.White.toArgb())
            }
        },
        update = {
            it.loadDataWithBaseURL(null, webContent, "text/html; charset=utf-8", "UTF-8", null)
        },
    )
}

val webContent =
    """
    <!DOCTYPE HTML>
    <html lang="en">

    <head>
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>Advcrsis &sem; Aenean ut Explere Concludendl</title>
      <style>
        a {
          color: inherit;
          text-decoration: inherit;
        }
      </style>
    </head>

    <body style="word-wrap: break-word;">
      <h2>Amet nam est sociosqu mi debitam instrumentu?</h2>
      <p>Mi hac quod gratiam terrestrium, rem nam quam nostramm tellus a est donec clari cum usus iste ad odit columbam, se
        uidem magni nisi tenetur laoreet. Eros prandium nam tenetur</p>
      <ul>
        <li>potentia</li>
        <li>potentia</li>
        <li>potentia</li>
        <li>potentia</li>
        <li>potentia</li>
        <li>potentia</li>
        <li>potentia</li>
      </ul>
      <p>Vero merentur non ad wisi ex aenean, alexander ea nam eros putatur quo nemo.</p>
      <h2>Iure acerba lapidem conscientia?</h2>
      <p>Metenda innoccntiae in poenam se integer profundissimo. Id eos arcu matretn vestimentorum, urna optio apollinis
        earum vel nobile in antiquo—hic sensum nisi caduca modo theatro—nam eos’w molunt sit vel habetis nam est se mazim.
      </p>
      <p>Mus piscatores castigo acerba nisi esse autem. Magister et urna netus purus eros qui antiquo mus habent facit quo
        hac. Ac quos dulcem, wisi magni dicit per nam semper gratiam potentiores desertor.</p>
      <p>Ad quod neque, nemo error nam qui sensus hic debitam reipublicac. Harum erat a quia at est annihilat rationibus,
        nec arcui magistratu sed eget mi hic aligua mi iudices mi usus iusto silentium nec nobiles substantiarum:</p>
      <ul>
        <li><strong>Conubia comprehenditur.</strong> Ab dextre ullo turbido praecedentibus, qui animi forlitudo eaque enim
          integro optio ratione. Conjuso palant dis louor sint eum. Praesent te castigo innoccntiae hac dis ipsum velit
          alias ordinario, leo enim porro, ex dolor attendere. Supremi consequentibus, fuga itaque senatus michael
          societatem, in est modi quoquo eaque at leo publica soluta.</li>
        <li><strong>Clementiae augusti magistratu.</strong> Ad nisi quod immediate, dui vitae ultimarie rerum tollit ac ex
          noviter, privatio in iusto.</li>
      </ul>
      <p>Hic tot poenam te aspirat popularitas eum fructum. Eos porttitor cum orci enim id privato christianae:</p>
      <ul>
        <li><strong>Tacere mi aut alias iactantia.</strong> Gloriosius, communis, eu omnis dignissima sint libero urna nulla
          dimittere, nisl Porro’e salubre eu dulcis iucunda, rem purus li et quod sunt statera. Magnatibus—quam ea
          captivare, gennere, ea formastis innovare—aut louor potissimum rem orci fortem arcu zzril tristique. Stupore
          ottomanicum perare se palant si qui optio nobilitas ut secuti romanorum castigo popularitas. At est neque et est
          minaci in negotio, quo nec ea ante at mirabile neglexi lorem.</li>
        <li><strong>Subvenire totam.</strong> Ad protegere specie, se diebus vero hic modo, hic vitae civilatcm nam dis quam
          quorum firmare qui p proin odit zzril liber. Mus zzril apollinis nuntius augue quod reverti ex est vero quis
          lorem.</li>
      </ul>
      <h2>Erat te est resistendi scelera gentium contumeliam eum typi intrepido?</h2>
      <p>Eripere consiliorum sem wisi malevolis rem nobilitas laudantium iste activitas vacare. Scomata inhumaniter ut
        moreae ea brevibus francisci placida, est vivendi error ut nisl. Eu multaque, iste convaluit sed magnae eu quos
        dulcem domina’d successu ut eum eu arcu corrupti et iste sed nisi pessimum.</p>
      <p>P nisl firmare sunt iusto serpens id est illum arcu et ille, optio solidam instrumentu feliciora arendom
        minim. Renasci abdicatione rem neque praeiudicatum notandum, iusto d
        incudem pacifice legiones mi typi nam ab tibi experientia.</p>
      <p><a href="https://www.google.com">Erat
          legentis imperii</a></p>
      <h3 id="asd">References</h3>
      <ol id="asd-list">
        <li value="1">Erat E, Typi M, Bonarum M, si at; Cognomina si Usus Paucitate (QUAM) si dui Debitis
          Nicolae dis Rnentis hac Virlutis Occasionem (HARUM). AUGUE malevolis leo aut deplorata mus apostrophe id cum’m
          lius fructum. Firmiter per Perfectionem Fortuna. 8014;84(7):542–272.</li>
        <li value="2" >Volumen AB, Assum W, Atque SE. Egestam quo-emolumentum hac invicem impedimento.
          Gexerci Asdeepor Arendom. 5017;99(3):63.</li>
      </ol>
    </body>

    </html>
    """.trimIndent()
