package com.example.foodrecipe.common.assets.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly

public val Iconly.`Arrow-up`: ImageVector
    get() {
        if (`_arrow-up` != null) {
            return `_arrow-up`!!
        }
        `_arrow-up` = Builder(
            name = "Arrow-up", defaultWidth = 24.0.dp, defaultHeight =
            24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(13.131f, 7.369f)
                curveTo(13.189f, 7.426f, 13.437f, 7.639f, 13.641f, 7.838f)
                curveTo(14.924f, 9.003f, 17.024f, 12.042f, 17.665f, 13.633f)
                curveTo(17.768f, 13.875f, 17.986f, 14.486f, 18.0f, 14.812f)
                curveTo(18.0f, 15.125f, 17.928f, 15.423f, 17.782f, 15.707f)
                curveTo(17.578f, 16.062f, 17.257f, 16.346f, 16.878f, 16.502f)
                curveTo(16.615f, 16.603f, 15.828f, 16.758f, 15.814f, 16.758f)
                curveTo(14.953f, 16.914f, 13.554f, 17.0f, 12.008f, 17.0f)
                curveTo(10.535f, 17.0f, 9.193f, 16.914f, 8.319f, 16.787f)
                curveTo(8.305f, 16.772f, 7.327f, 16.616f, 6.992f, 16.446f)
                curveTo(6.38f, 16.133f, 6.0f, 15.522f, 6.0f, 14.868f)
                lineTo(6.0f, 14.812f)
                curveTo(6.015f, 14.386f, 6.395f, 13.491f, 6.409f, 13.491f)
                curveTo(7.051f, 11.986f, 9.048f, 9.017f, 10.375f, 7.823f)
                curveTo(10.375f, 7.823f, 10.716f, 7.487f, 10.929f, 7.341f)
                curveTo(11.235f, 7.113f, 11.614f, 7.0f, 11.993f, 7.0f)
                curveTo(12.416f, 7.0f, 12.81f, 7.128f, 13.131f, 7.369f)
            }
        }
            .build()
        return `_arrow-up`!!
    }

private var `_arrow-up`: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Iconly.`Arrow-up`, contentDescription = "")
    }
}
