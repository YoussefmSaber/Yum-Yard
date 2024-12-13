package com.example.foodrecipe.common.iconly

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.common.Iconly

val Iconly.`Home-fill`: ImageVector
    get() {
        if (`_home-fill` != null) {
            return `_home-fill`!!
        }
        `_home-fill` = Builder(name = "Home-fill", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF797979)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(20.04f, 6.8199f)
                lineTo(14.28f, 2.7899f)
                curveTo(12.71f, 1.6899f, 10.3f, 1.7499f, 8.79f, 2.9199f)
                lineTo(3.78f, 6.8299f)
                curveTo(2.78f, 7.6099f, 1.99f, 9.2099f, 1.99f, 10.4699f)
                verticalLineTo(17.3699f)
                curveTo(1.99f, 19.9199f, 4.06f, 21.9999f, 6.61f, 21.9999f)
                horizontalLineTo(17.39f)
                curveTo(19.94f, 21.9999f, 22.01f, 19.9299f, 22.01f, 17.3799f)
                verticalLineTo(10.5999f)
                curveTo(22.01f, 9.2499f, 21.14f, 7.5899f, 20.04f, 6.8199f)
                close()
                moveTo(12.75f, 17.9999f)
                curveTo(12.75f, 18.4099f, 12.41f, 18.7499f, 12.0f, 18.7499f)
                curveTo(11.59f, 18.7499f, 11.25f, 18.4099f, 11.25f, 17.9999f)
                verticalLineTo(14.9999f)
                curveTo(11.25f, 14.5899f, 11.59f, 14.2499f, 12.0f, 14.2499f)
                curveTo(12.41f, 14.2499f, 12.75f, 14.5899f, 12.75f, 14.9999f)
                verticalLineTo(17.9999f)
                close()
            }
        }
        .build()
        return `_home-fill`!!
    }

private var `_home-fill`: ImageVector? = null
