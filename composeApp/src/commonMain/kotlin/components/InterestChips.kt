package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import models.InterestItem
import utils.baseColors
import utils.tertiary


enum class LayoutOrientation {
    VERTICAL, HORIZONTAL, WRAP
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InterestChips(
    items: List<InterestItem>,
    onSelectionChanged: (InterestItem) -> Unit,
    layoutOrientation: LayoutOrientation = LayoutOrientation.WRAP,
) {
    when (layoutOrientation) {
        LayoutOrientation.VERTICAL -> {
            Column(modifier = Modifier.padding(16.dp)) {
                items.forEach { item ->
                    ChipItem(item, onSelectionChanged)
                }
            }
        }

        LayoutOrientation.HORIZONTAL -> {
            Row(modifier = Modifier.padding(16.dp)) {
                items.forEach { item ->
                    ChipItem(item, onSelectionChanged)
                }
            }
        }

        LayoutOrientation.WRAP -> {
            FlowRow(
                modifier = Modifier.padding(16.dp),
            ) {
                items.forEach { item ->
                    ChipItem(item, onSelectionChanged)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipItem(item: InterestItem, onSelectionChanged: (InterestItem) -> Unit) {
    FilterChip(
        selected = item.isChecked,
        onClick = { onSelectionChanged(item) },
        modifier = Modifier.padding(4.dp),
        leadingIcon = if (item.isChecked) {
            { Icon(Icons.Filled.Done, contentDescription = null, modifier = Modifier.size(20.dp)) }
        } else {
            null
        },
        colors = ChipDefaults.filterChipColors(
            selectedBackgroundColor = tertiary,
            backgroundColor = baseColors.primary
        )
    ) {
        Text(text = item.value, preset = TextType.BODY1)

    }
}