package com.example.jetsat.repsentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    placeholder: String = "",
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    isError: Boolean = false,
    supportingText: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    onImeAction: (() -> Unit)? = null,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    prefix: String? = null,
    suffix: String? = null,
    shape: Shape = RoundedCornerShape(12.dp),
    focusedBorderColor: Color = Color(0xFF2196F3),
    unfocusedBorderColor: Color = Color.Gray,
    errorBorderColor: Color = Color.Red,
    cursorColor: Color = Color(0xFF2196F3),
) {
    var isFocused by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { if (label.isNotEmpty()) Text(label) },
        placeholder = { if (placeholder.isNotEmpty()) Text(placeholder) },
        readOnly = readOnly,
        enabled = enabled,
        singleLine = singleLine,
        maxLines = maxLines,
        isError = isError,
        textStyle = TextStyle(fontSize = 16.sp),
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = { onImeAction?.invoke() },
            onNext = { onImeAction?.invoke() },
            onSearch = { onImeAction?.invoke() }
        ),
        leadingIcon = {
            leadingIcon?.let {
                Icon(imageVector = it, contentDescription = null)
            }
        },
        trailingIcon = {
            if (trailingIcon != null) {
                IconButton(onClick = { onTrailingIconClick?.invoke() }) {
                    Icon(imageVector = trailingIcon, contentDescription = null)
                }
            }
        },
        prefix = { if (prefix != null) Text(prefix, color = Color.Gray) },
        suffix = { if (suffix != null) Text(suffix, color = Color.Gray) },
        supportingText = {
            if (supportingText != null) {
                val color = if (isError) Color.Red else Color.Gray
                Text(text = supportingText, color = color, fontSize = 12.sp)
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = if (isError) errorBorderColor else focusedBorderColor,
            unfocusedBorderColor = if (isError) errorBorderColor else unfocusedBorderColor,
            cursorColor = cursorColor,
            focusedLabelColor = if (isError) Color.Red else focusedBorderColor
        ),
        shape = shape
    )
}
