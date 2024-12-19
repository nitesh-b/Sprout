package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import utils.secondary


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropdownMenu(
    label: String? = null,
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = Modifier.background(secondary, RoundedCornerShape(16.dp)),
        expanded = isExpanded,
        onExpandedChange = { isExpanded = !isExpanded }
    ) {
        // TextField that triggers the dropdown menu
        TextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            label = { label?.let { Text(text = it, preset = TextType.BODY1) } },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            modifier = Modifier.fillMaxWidth().padding(8.dp).background(secondary)
        )

        Spacer(modifier = Modifier.height(8.dp))
        // Dropdown menu items
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        onItemSelected(item)
                        isExpanded = false
                    }
                ) {
                    Text(text = item, preset = TextType.BODY1)
                }
            }
        }

    }
}
