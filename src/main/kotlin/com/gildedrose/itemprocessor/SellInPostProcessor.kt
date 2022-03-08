package com.gildedrose.itemprocessor

import com.gildedrose.Item

/**
 * This processor is in charge of wrapping a Processor, execute it, and after, decrease
 * the sellIn value of the Item.kt.
 *
 * This class is left here on purpose. read the README file, step 11.
 */
class SellInPostProcessor(private val wrappedProcessor : ItemProcessor) : ItemProcessor {

    override fun <T : Item> processItem(item: T) {
        // 1. execute the wrapped processor
        wrappedProcessor.processItem(item)

        // 2. this is the whole reason of creating this processor :
        item.sellIn = item.sellIn - 1
    }
}