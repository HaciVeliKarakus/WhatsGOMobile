package io.bordo.whatsgomobile.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jaikeerthick.composable_graphs.color.LinearGraphColors
import com.jaikeerthick.composable_graphs.color.PointHighlight2
import com.jaikeerthick.composable_graphs.composables.LineGraph
import com.jaikeerthick.composable_graphs.data.GraphData
import com.jaikeerthick.composable_graphs.style.LineGraphStyle
import com.jaikeerthick.composable_graphs.style.LinearGraphVisibility
import io.bordo.whatsgomobile.ui.theme.BlueMain
import io.bordo.whatsgomobile.ui.theme.BlueMinus85


private val month = listOf(
    "Oca",
    "Şub",
    "Mar",
    "Nis",
    "May",
    "Haz",
    "Tem",
    "Ağu",
    "Eyl",
    "Eki",
    "Kas",
    "Ara"
)


@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGLineChart()
}

@Composable
fun WGLineChart() {
    val style = LineGraphStyle(
        visibility = LinearGraphVisibility(
            isHeaderVisible = true,
            isYAxisLabelVisible = false,
            isCrossHairVisible = true,
            isGridVisible = true
        ),
        colors = LinearGraphColors(
            lineColor = BlueMain,
            pointColor = BlueMain,
            clickHighlightColor = PointHighlight2,
            fillGradient = Brush.verticalGradient(
                listOf(BlueMinus85, Color.Transparent)
            )
        )
    )
    LineGraph(
        xAxisData = month.map {
            GraphData.String(it)
        }, // xAxisData : List<GraphData>, and GraphData accepts both Number and String types
        yAxisData = listOf(200, 40, 60, 45, 70, 30, 50, 45, 78, 30, 50, 77),
        style = style
    )
}
