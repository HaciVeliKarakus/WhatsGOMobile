package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ComboboxWidget() {
    val options = listOf("Tümü", "Çevrimiçi", "Çevrimdışı")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

//    Spacer(modifier = Modifier.Companion.weight(1f))
    ExposedDropdownMenuBox(modifier = Modifier.width(130.dp),
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }) {
        OutlinedTextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
//                        label = { Text("Label") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
//                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
            shape = RoundedCornerShape(20.dp)
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = false
        }) {
            options.forEach { selectionOption ->
                DropdownMenuItem(onClick = {
                    selectedOptionText = selectionOption
                    expanded = false
                }) {
                    Text(text = selectionOption, fontSize = 10.sp)
                }
            }
        }
    }
}

