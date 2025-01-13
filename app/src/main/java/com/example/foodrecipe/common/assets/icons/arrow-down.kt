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

public val Iconly.`Arrow-down`: ImageVector
    get() {
        if (`_arrow-down` != null) {
            return `_arrow-down`!!
        }
        `_arrow-down` = Builder(name = "Arrow - down 2", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.869f, 16.631f)
                curveTo(10.811f, 16.574f, 10.563f, 16.361f, 10.359f, 16.162f)
                curveTo(9.076f, 14.997f, 6.976f, 11.958f, 6.335f, 10.367f)
                curveTo(6.232f, 10.125f, 6.014f, 9.514f, 6.0f, 9.188f)
                curveTo(6.0f, 8.875f, 6.072f, 8.577f, 6.218f, 8.293f)
                curveTo(6.422f, 7.938f, 6.743f, 7.654f, 7.122f, 7.498f)
                curveTo(7.385f, 7.397f, 8.172f, 7.242f, 8.186f, 7.242f)
                curveTo(9.047f, 7.086f, 10.446f, 7.0f, 11.992f, 7.0f)
                curveTo(13.465f, 7.0f, 14.807f, 7.086f, 15.681f, 7.213f)
                curveTo(15.695f, 7.228f, 16.673f, 7.384f, 17.008f, 7.554f)
                curveTo(17.62f, 7.867f, 18.0f, 8.478f, 18.0f, 9.132f)
                lineTo(18.0f, 9.188f)
                curveTo(17.985f, 9.614f, 17.605f, 10.509f, 17.591f, 10.509f)
                curveTo(16.949f, 12.014f, 14.952f, 14.983f, 13.625f, 16.177f)
                curveTo(13.625f, 16.177f, 13.284f, 16.513f, 13.071f, 16.659f)
                curveTo(12.765f, 16.887f, 12.386f, 17.0f, 12.007f, 17.0f)
                curveTo(11.584f, 17.0f, 11.19f, 16.872f, 10.869f, 16.631f)
            }
        }
        .build()
        return `_arrow-down`!!
    }

private var `_arrow-down`: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Iconly.`Arrow-down`, contentDescription = "")
    }
}
