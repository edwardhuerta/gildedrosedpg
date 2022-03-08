package com.gildedrose.itemprocessor

import com.gildedrose.Item

interface ItemProcessor {
    fun <T : Item> processItem(item: T)
}