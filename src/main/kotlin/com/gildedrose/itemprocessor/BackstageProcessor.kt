package com.gildedrose.itemprocessor

import com.gildedrose.Item
import kotlin.math.min

/**
 * calculate quality value by:
 *
 * if sellIn is 0 or lower : quality is 0
 * if sellIn is 5 or lower : increase by 3
 * if sellIn is 10 or lower : increase by 2
 * otherwise increase by 1
 */
class BackstageProcessor : ItemProcessor {

    private val maxQualityPossible = 50

    override fun <T : Item> processItem(item: T) {
        val calculatedQuality = if (item.sellIn <= 0) {
            0
        } else {
            item.quality + calculateQualityChange(item.sellIn)
        }

        item.quality = min(maxQualityPossible, calculatedQuality)
        item.sellIn = item.sellIn - 1
    }

    /**
     * if sellIn is equal or less than 5 : decrease by 3
     * else if sellIn is equal to 10 or less: decrease by 2
     * else decrease by 1
     */
    private fun calculateQualityChange(sellIn: Int): Int = if (sellIn <= 5) {
        3
    } else if (sellIn <= 10) {
        2
    } else {
        1
    }
}