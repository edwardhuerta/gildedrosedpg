package com.gildedrose.itemprocessor

import com.gildedrose.Item
import kotlin.math.max

/**
 * This processor is re-used by 3 types of Items :
 * ("+5 Dexterity Vest", "Elixir of the Mongoose", "Conjured Mana Cake")
 *
 * calculate quality value by:
 *
 * if sellIn is 0 or lower : decrease by 2
 * otherwise decrease by 1
 *
 */
class DecreaseByTwoAfterSellInExpiresProcessor : ItemProcessor {

    private val lowestQualityPossible = 0

    override fun <T : Item> processItem(item: T) {
        val calculatedQuality = item.quality + calculateQualityChange(item.sellIn)

        item.quality = max(lowestQualityPossible, calculatedQuality)
        item.sellIn = item.sellIn - 1
    }

    private fun calculateQualityChange(sellIn: Int): Int = if (sellIn <= 0) -2 else -1
}