package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import utils.baseColors
import utils.tertiary

@Composable
fun MultiCheckBoxList(
    items: List<String>,
    checkedState: MutableState<List<Boolean>>, // Pass state from parent
) {
    Column(modifier = Modifier.wrapContentHeight().padding(8.dp)) {
        items.forEachIndexed { index, item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Checkbox with circular shape
                Checkbox(
                    checked = checkedState.value[index],
                    onCheckedChange = { isChecked ->
                        // Update the state when checkbox is clicked
                        checkedState.value = checkedState.value.toMutableList().apply {
                            this[index] = isChecked
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = tertiary,
                        uncheckedColor = baseColors.primary
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = item, preset = TextType.BODY1)
            }
        }
    }
}