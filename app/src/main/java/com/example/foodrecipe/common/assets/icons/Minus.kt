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

public val Iconly.Minus: ImageVector
    get() {
        if (_minus != null) {
            return _minus!!
        }
        _minus = Builder(name = "Minus", defaultWidth = 256.0.dp, defaultHeight = 256.0.dp,
                viewportWidth = 256.0f, viewportHeight = 256.0f).apply {
            path(fill = SolidColor(Color(0xFF1D1D1B)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 2.81f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(244.47f, 137.69f)
                lineToRelative(-233.23f, 0.0f)
                curveTo(5.81f, 137.69f, 1.41f, 133.29f, 1.41f, 127.86f)
                reflectiveCurveToRelative(4.4f, -9.84f, 9.84f, -9.84f)
                lineToRelative(233.23f, 0.0f)
                curveToRelative(5.43f, 0.0f, 9.84f, 4.4f, 9.84f, 9.84f)
                reflectiveCurveTo(249.9f, 137.69f, 244.47f, 137.69f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1D1D1B)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 2.81f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(244.47f, 137.69f)
                lineToRelative(-233.23f, 0.0f)
                curveTo(5.81f, 137.69f, 1.41f, 133.29f, 1.41f, 127.86f)
                reflectiveCurveToRelative(4.4f, -9.84f, 9.84f, -9.84f)
                lineToRelative(233.23f, 0.0f)
                curveToRelative(5.43f, 0.0f, 9.84f, 4.4f, 9.84f, 9.84f)
                reflectiveCurveTo(249.9f, 137.69f, 244.47f, 137.69f)
                close()
            }
        }
        .build()
        return _minus!!
    }

private var _minus: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Iconly.Minus, contentDescription = "")
    }
}
