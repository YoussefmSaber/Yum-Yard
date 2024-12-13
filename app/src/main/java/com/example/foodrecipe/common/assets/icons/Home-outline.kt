package com.example.foodrecipe.common.assets.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.assets.Iconly

val Iconly.`Home-outline`: ImageVector
    get() {
        if (`_home-outline` != null) {
            return `_home-outline`!!
        }
        `_home-outline` = Builder(name = "Home-outline", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF797979)),
                    strokeLineWidth = 1.5f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(20.4699f, 6.2054f)
                lineTo(20.4701f, 6.2055f)
                curveTo(21.1412f, 6.6753f, 21.706f, 7.3862f, 22.1023f, 8.1454f)
                curveTo(22.4987f, 8.9045f, 22.76f, 9.776f, 22.76f, 10.5999f)
                verticalLineTo(17.3799f)
                curveTo(22.76f, 20.3442f, 20.3542f, 22.7499f, 17.39f, 22.7499f)
                horizontalLineTo(6.61f)
                curveTo(3.6437f, 22.7499f, 1.24f, 20.332f, 1.24f, 17.3699f)
                verticalLineTo(10.4699f)
                curveTo(1.24f, 9.6966f, 1.4782f, 8.8677f, 1.8371f, 8.1386f)
                curveTo(2.1963f, 7.4092f, 2.7083f, 6.7147f, 3.3186f, 6.2387f)
                curveTo(3.3186f, 6.2386f, 3.3187f, 6.2386f, 3.3187f, 6.2386f)
                lineTo(8.3286f, 2.3287f)
                lineTo(8.3306f, 2.3271f)
                lineTo(8.3306f, 2.3271f)
                curveTo(10.1003f, 0.9559f, 12.8707f, 0.8871f, 14.7099f, 2.1754f)
                lineTo(20.4699f, 6.2054f)
                close()
                moveTo(20.4699f, 6.2054f)
                lineTo(14.7103f, 2.1757f)
                lineTo(20.4699f, 6.2054f)
                close()
            }
        }
        .build()
        return `_home-outline`!!
    }

private var `_home-outline`: ImageVector? = null
