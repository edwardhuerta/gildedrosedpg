package com.gildedrose

/**
 * I created this class to enclose the Item class (which we cannot modify) and add an equals method
 * that can help us simplify the assertions in the tests inside com.gildedrose.GildedRoseTest.kt
 */
class ComparableItem(nameValue: String, sellInValue: Int, qualityValue: Int) : Item(nameValue, sellInValue, qualityValue) {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (javaClass != other?.javaClass && other?.javaClass != Item::class.java) {
            return false
        }

        if (other is ComparableItem) {
            if (name != other.name) return false
            if (sellIn != other.sellIn) return false
            if (quality != other.quality) return false
        } else if (other is Item) {
            if (name != other.name) return false
            if (sellIn != other.sellIn) return false
            if (quality != other.quality) return false
        }

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + sellIn
        result = 31 * result + quality
        return result
    }
}