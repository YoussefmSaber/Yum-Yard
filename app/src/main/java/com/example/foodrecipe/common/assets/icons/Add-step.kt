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

public val Iconly.`Add-step`: ImageVector
    get() {
        if (`_add-step` != null) {
            return `_add-step`!!
        }
        `_add-step` = Builder(name = "Add step", defaultWidth = 512.0.dp, defaultHeight = 512.0.dp,
                viewportWidth = 512.0f, viewportHeight = 512.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(0.0f, 256.0f)
                lineToRelative(0.0f, 256.0f)
                lineToRelative(256.0f, -0.0f)
                lineToRelative(256.0f, -0.0f)
                lineToRelative(0.0f, -256.0f)
                lineToRelative(0.0f, -256.0f)
                lineToRelative(-256.0f, -0.0f)
                lineToRelative(-256.0f, -0.0f)
                lineToRelative(0.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_add-step`!!
    }

private var `_add-step`: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Iconly.`Add-step`, contentDescription = "")
    }
}
