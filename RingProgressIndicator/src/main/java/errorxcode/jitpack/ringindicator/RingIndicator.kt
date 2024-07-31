package errorxcode.jitpack.ringindicator

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RingProgressIndicator(
    radius: Int,
    colors: List<Color>,
    progress: Int,
    suffix: String = "%",
    maxValue: Int = 100,
    txtColor: Color = Color.Unspecified,
    strokeWidth: Int = radius / 4,
    isHalfRing: Boolean = false
) {
    val progressPercentage by animateFloatAsState(
        targetValue = (progress.coerceAtMost(maxValue) * 100f / maxValue),
        animationSpec = tween(1000, 0, LinearOutSlowInEasing)
    )
    val sweepAngle =
        if (isHalfRing) (progressPercentage / 100) * 240f else (progressPercentage / 100) * 360f
    val startAngle = if (isHalfRing) 150f else 90f
    val backgroundSweepAngle = if (isHalfRing) 240f else 360f

    val textMeasurer = rememberTextMeasurer()

    Canvas(Modifier.size(radius.dp)) {
        // Background Arc
        drawArc(
            color = Color.LightGray,
            startAngle = startAngle,
            sweepAngle = backgroundSweepAngle,
            useCenter = false,
            size = Size(radius * 2f, radius * 2f),
            topLeft = Offset(size.width / 2 - radius, size.height / 2 - radius),
            style = Stroke(strokeWidth.toFloat())
        )

        // Progress Arc
        drawArc(
            brush = Brush.linearGradient(colors),
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            useCenter = false,
            size = Size(radius * 2f, radius * 2f),
            topLeft = Offset(size.width / 2 - radius, size.height / 2 - radius),
            style = Stroke(
                width = strokeWidth.toFloat(),
                cap = StrokeCap.Round
            )
        )

        val text = "${progressPercentage.toInt()}$suffix"
        val txtStyle = if (txtColor == Color.Unspecified) {
            TextStyle(
                brush = Brush.horizontalGradient(colors),
                fontSize = (radius / 10).sp
            )
        } else
            TextStyle(Color.Black, fontSize = (radius / 10).sp)

        val textLayoutResult = textMeasurer.measure(text,txtStyle)

        drawText(
            textMeasurer = textMeasurer,
            text = text,
            topLeft = Offset(
                (size.width - textLayoutResult.size.width) / 2f,
                (size.height - textLayoutResult.size.height) / 2f
            ),
            style = txtStyle
        )
    }
}