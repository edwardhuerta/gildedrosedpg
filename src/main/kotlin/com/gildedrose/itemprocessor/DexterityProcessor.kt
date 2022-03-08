package com.gildedrose.itemprocessor

import com.gildedrose.Item
import kotlin.math.max

/**
 * Processor that updates the quality and sellIn values of an item
 *
 * Please note that DexterityProcessor, ElixirProcessor, ConjuredProcessor processors
 * have the same logic, so they have been replaced by a processor called : DecreaseByTwoAfterSellInExpiresProcessor since
 * they share the logic that a sellIn below 0 causes the quality to increase by -2 and not by -1
 *
 * This class is left here on purpose. read the README file, step 10.
 *
 */
class DexterityProcessor : ItemProcessor {

    private val lowestQualityPossible = 0

    override fun <T : Item> processItem(item: T) {
        val calculatedQuality = item.quality + calculateQualityChange(item.sellIn)

        item.quality = max(lowestQualityPossible, calculatedQuality)
        item.sellIn = item.sellIn - 1
    }

    private fun calculateQualityChange(sellIn: Int): Int = if (sellIn <= 0) -2 else -1
}