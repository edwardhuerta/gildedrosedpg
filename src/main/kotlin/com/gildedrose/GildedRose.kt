package com.gildedrose

import com.gildedrose.itemprocessor.*

/**
 * Part 1 : items parameter can be considered the incoming "state"
 */
class GildedRose<T : Item>(var items: Array<out T>) {

    /**
     * Part 2 : the processors are the state "modifiers". This setup allows
     * each Processor to update the SellIn and Quality.
     */
    private val processorsByName: Map<String, ItemProcessor> = mapOf(
        dexterity to DecreaseByTwoAfterSellInExpiresProcessor(),
        agedBrie  to AgedBrieProcessor(),
        elixir    to DecreaseByTwoAfterSellInExpiresProcessor(),
        sulfuras  to SulfurasProcessor(),
        backstage to BackstageProcessor(),
        conjured  to ConjuredProcessor(),
    )

    fun updateQuality() {
        for (item in items) {
            processorsByName[item.name]?.processItem(item) ?: run {
                // warn user : sorry, we cannot process your item until
                // you add a new processor for your item name.
            }
        }
    }
}

