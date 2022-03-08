package com.gildedrose.itemprocessor

import com.gildedrose.Item
import kotlin.math.min

/**
 * calculate quality value by:
 *
 * if sellIn is above 0 : increase by 1
 * if sellIn is 0 or lower : increase by 2!
 */
class AgedBrieProcessor : ItemProcessor {

    private val maxQualityPossible = 50

    override fun <T : Item> processItem(item: T) {
        val calculatedQuality = item.quality + calculateQualityChange(item.sellIn)

        item.quality = min(maxQualityPossible, calculatedQuality)
        item.sellIn = item.sellIn - 1
    }

    private fun calculateQualityChange(sellIn: Int): Int = if (sellIn <= 0) 2 else 1
}