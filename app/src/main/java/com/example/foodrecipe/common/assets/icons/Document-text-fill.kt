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

val Iconly.`Document-text-fill`: ImageVector
    get() {
        if (`_document-text-fill` != null) {
            return `_document-text-fill`!!
        }
        `_document-text-fill` = Builder(name = "Document-text-fill", defaultWidth = 24.0.dp,
                defaultHeight = 24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF797979)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(15.7999f, 2.21f)
                curveTo(15.3899f, 1.8f, 14.6799f, 2.08f, 14.6799f, 2.65f)
                verticalLineTo(6.14f)
                curveTo(14.6799f, 7.6f, 15.9199f, 8.81f, 17.4299f, 8.81f)
                curveTo(18.3799f, 8.82f, 19.6999f, 8.82f, 20.8299f, 8.82f)
                curveTo(21.3999f, 8.82f, 21.6999f, 8.15f, 21.2999f, 7.75f)
                curveTo(19.8599f, 6.3f, 17.2799f, 3.69f, 15.7999f, 2.21f)
                close()
            }
            path(fill = SolidColor(Color(0xFF797979)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(20.5f, 10.19f)
                horizontalLineTo(17.61f)
                curveTo(15.24f, 10.19f, 13.31f, 8.26f, 13.31f, 5.89f)
                verticalLineTo(3.0f)
                curveTo(13.31f, 2.45f, 12.86f, 2.0f, 12.31f, 2.0f)
                horizontalLineTo(8.07f)
                curveTo(4.99f, 2.0f, 2.5f, 4.0f, 2.5f, 7.57f)
                verticalLineTo(16.43f)
                curveTo(2.5f, 20.0f, 4.99f, 22.0f, 8.07f, 22.0f)
                horizontalLineTo(15.93f)
                curveTo(19.01f, 22.0f, 21.5f, 20.0f, 21.5f, 16.43f)
                verticalLineTo(11.19f)
                curveTo(21.5f, 10.64f, 21.05f, 10.19f, 20.5f, 10.19f)
                close()
                moveTo(11.5f, 17.75f)
                horizontalLineTo(7.5f)
                curveTo(7.09f, 17.75f, 6.75f, 17.41f, 6.75f, 17.0f)
                curveTo(6.75f, 16.59f, 7.09f, 16.25f, 7.5f, 16.25f)
                horizontalLineTo(11.5f)
                curveTo(11.91f, 16.25f, 12.25f, 16.59f, 12.25f, 17.0f)
                curveTo(12.25f, 17.41f, 11.91f, 17.75f, 11.5f, 17.75f)
                close()
                moveTo(13.5f, 13.75f)
                horizontalLineTo(7.5f)
                curveTo(7.09f, 13.75f, 6.75f, 13.41f, 6.75f, 13.0f)
                curveTo(6.75f, 12.59f, 7.09f, 12.25f, 7.5f, 12.25f)
                horizontalLineTo(13.5f)
                curveTo(13.91f, 12.25f, 14.25f, 12.59f, 14.25f, 13.0f)
                curveTo(14.25f, 13.41f, 13.91f, 13.75f, 13.5f, 13.75f)
                close()
            }
        }
        .build()
        return `_document-text-fill`!!
    }

private var `_document-text-fill`: ImageVector? = null
