package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import utils.primary
import utils.tertiary

@Composable
fun RadioButtonGroup(
    items: List<String>,
    selectedOption: MutableState<Int>,
) {
    Column(modifier = Modifier.wrapContentHeight().padding(8.dp)) {
        items.forEachIndexed { index, item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption.value == index,
                    onClick = {
                        selectedOption.value = index
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = tertiary,
                        unselectedColor = primary
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = item)
            }
        }
    }
}