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

val Iconly.`Search-normal-fill`: ImageVector
    get() {
        if (`_search-normal-fill` != null) {
            return `_search-normal-fill`!!
        }
        `_search-normal-fill` = Builder(name = "Search-normal-fill", defaultWidth = 24.0.dp,
                defaultHeight = 24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF797979)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(11.5f, 21.0f)
                curveTo(16.7467f, 21.0f, 21.0f, 16.7467f, 21.0f, 11.5f)
                curveTo(21.0f, 6.2533f, 16.7467f, 2.0f, 11.5f, 2.0f)
                curveTo(6.2533f, 2.0f, 2.0f, 6.2533f, 2.0f, 11.5f)
                curveTo(2.0f, 16.7467f, 6.2533f, 21.0f, 11.5f, 21.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF797979)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(21.3001f, 22.0001f)
                curveTo(21.1201f, 22.0001f, 20.9401f, 21.9301f, 20.8101f, 21.8001f)
                lineTo(18.9501f, 19.9401f)
                curveTo(18.6801f, 19.6701f, 18.6801f, 19.2301f, 18.9501f, 18.9501f)
                curveTo(19.2201f, 18.6801f, 19.6601f, 18.6801f, 19.9401f, 18.9501f)
                lineTo(21.8001f, 20.8101f)
                curveTo(22.0701f, 21.0801f, 22.0701f, 21.5201f, 21.8001f, 21.8001f)
                curveTo(21.6601f, 21.9301f, 21.4801f, 22.0001f, 21.3001f, 22.0001f)
                close()
            }
        }
        .build()
        return `_search-normal-fill`!!
    }

private var `_search-normal-fill`: ImageVector? = null
