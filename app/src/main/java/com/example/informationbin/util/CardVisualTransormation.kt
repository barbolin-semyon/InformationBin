package com.example.informationbin.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation


class CardVisualTransformation(val mask: Char = '-') : VisualTransformation {

    private val cardOffsetMapping = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return offset + offset / 4
        }

        override fun transformedToOriginal(offset: Int): Int {
            return offset - offset / 5
        }
    }

    override fun filter(text: AnnotatedString): TransformedText {

        var out = ""
        text.text.indices.forEach { index ->
            out += text[index]
            if (index % 4 == 3) out += mask

        }

        return TransformedText(
            text = AnnotatedString(out),
            offsetMapping = cardOffsetMapping
        )
    }
}