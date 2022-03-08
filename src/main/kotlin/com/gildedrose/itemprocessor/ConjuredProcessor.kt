package com.gildedrose.itemprocessor

import com.gildedrose.Item
import kotlin.math.max

/**
 * This processor must decrease the quality value twice as fast.
 */
class ConjuredProcessor : ItemProcessor {

    private val lowestQualityPossible = 0

    override fun <T : Item> processItem(item: T) {
        val calculatedQuality = item.quality + calculateQualityChange()

        item.quality = max(lowestQualityPossible, calculatedQuality)
        item.sellIn = item.sellIn - 1
    }

    private fun calculateQualityChange(): Int = -2
}