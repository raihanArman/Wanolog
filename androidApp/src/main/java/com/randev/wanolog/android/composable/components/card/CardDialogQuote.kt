package com.randev.wanolog.android.composable.components.card

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import com.randev.domain.model.QuoteListModel
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.presentation.dashboard.quote.QuoteAllViewModel
import com.randev.wanolog.android.utils.ImageUtils
import com.randev.wanolog.android.utils.IntentUtils
import com.randev.wanolog.android.utils.bitmapToCacheUri

/**
 * @author Raihan Arman
 * @date 16/12/22
 */

@SuppressLint("ViewConstructor")
class CardDialogQuoteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    val modifier: Modifier = Modifier,
    val quote: QuoteListModel.QuoteModel,
) : AbstractComposeView(context, attrs, defStyleAttr) {


    @Composable
    override fun Content() {
        CardDialogQuote(
            quote = quote,
            modifier = modifier,
        )
    }

    fun onShareQuote(view: CardDialogQuoteView){
        val bitmap = ImageUtils.generateBitmap(view)
        val bitmapUri = bitmap.bitmapToCacheUri(context)
        bitmapUri?.let {uri ->
            IntentUtils.shareImage(context, uri)
        }
    }
}

@Composable
fun DialogQuote(
    modifier: Modifier = Modifier,
    quote: QuoteListModel.QuoteModel,
    openDialog: (Boolean) -> Unit,
) {
    var captureView: CardDialogQuoteView? = null
    Card(
        modifier = modifier
            .defaultMinSize(minHeight = 500.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(quote.backgroundColor),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AndroidView(modifier = Modifier.wrapContentSize(),
                factory = {
                    CardDialogQuoteView(
                        it,
                        quote = quote,
                    ).apply {
                        post {
                            captureView = this
                        }
                    }
                }
            )
            OptionQuote(
                openDialog = openDialog,
                onShareQuote = {
                    captureView?.apply {
                        onShareQuote(this)
                    }
                }
            )
        }
    }
}

@Composable
fun OptionQuote(
    modifier: Modifier = Modifier,
    openDialog: (Boolean) -> Unit,
    onShareQuote: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(20.dp)
        .fillMaxWidth()
    ) {
        IconButton(onClick = {
            openDialog.invoke(false)
        }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
        }
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null, tint = Color.White)
        }
        IconButton(onClick = onShareQuote) {
            Icon(imageVector = Icons.Default.Share, contentDescription = null, tint = Color.White)
        }
    }
}


@Composable
fun CardDialogQuote(
    modifier: Modifier,
    quote: QuoteListModel.QuoteModel,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(quote.backgroundColor),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = quote.anime,
                    style = MovieAppTheme.typography.bold,
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = quote.character,
                    style = MovieAppTheme.typography.bold,
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
                VerticalSpacer(height = 16.dp)
                Text(
                    text = quote.quote,
                    style = MovieAppTheme.typography.light,
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }

            VerticalSpacer(height = 20.dp)
        }
    }
}