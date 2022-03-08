package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest() {

    @Test
    fun testItemsUpToDay26() {
        val items = arrayOf(
            ComparableItem(dexterity, 10, 20), //
            ComparableItem(agedBrie, 2, 0), //
            ComparableItem(elixir, 5, 7), //
            ComparableItem(sulfuras, 0, 80), //
            ComparableItem(sulfuras, -1, 80),
            ComparableItem(backstage, 15, 20),
            ComparableItem(backstage, 10, 49),
            ComparableItem(backstage, 5, 49),
            ComparableItem(conjured, 3, 6))

        val app = GildedRose(items)

        // the point of running the tests this many days is to visualize how the numbers change and how fast they reach their limits
        verifyDay0(items); app.updateQuality()
        verifyDay1(items); app.updateQuality()
        verifyDay2(items); app.updateQuality()
        verifyDay3(items); app.updateQuality()
        verifyDay4(items); app.updateQuality()
        verifyDay5(items); app.updateQuality() // conjured reaches limit
        verifyDay6(items); app.updateQuality() // elixir reaches limit, backstage3 reaches limit
        verifyDay7(items); app.updateQuality()
        verifyDay8(items); app.updateQuality()
        verifyDay9(items); app.updateQuality()
        verifyDay10(items); app.updateQuality()
        verifyDay11(items); app.updateQuality()
        verifyDay12(items); app.updateQuality()
        verifyDay13(items); app.updateQuality()
        verifyDay14(items); app.updateQuality()
        verifyDay15(items); app.updateQuality() // dexterityVestName reaches limit
        verifyDay16(items); app.updateQuality()
        verifyDay17(items); app.updateQuality()
        verifyDay18(items); app.updateQuality()
        verifyDay19(items); app.updateQuality()
        verifyDay20(items); app.updateQuality()
        verifyDay21(items); app.updateQuality()
        verifyDay22(items); app.updateQuality()
        verifyDay23(items); app.updateQuality()
        verifyDay24(items); app.updateQuality()
        verifyDay25(items); app.updateQuality()
        verifyDay26(items); app.updateQuality() // agedBrie reaches limit

        // after running the flow for 26 days, we see that there is no more value changes
        // we can see that brie is the slowest product to reach its extreme values
    }

    private fun verifyDay0(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 10, 20), items[0])
        assertEquals(ComparableItem(agedBrie, 2, 0), items[1])
        assertEquals(ComparableItem(elixir, 5, 7), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3]) // <-- never changes
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4]) // <-- never changes
        assertEquals(ComparableItem(backstage, 15, 20), items[5])
        assertEquals(ComparableItem(backstage, 10, 49), items[6])
        assertEquals(ComparableItem(backstage, 5, 49), items[7])
        assertEquals(ComparableItem(conjured, 3, 6), items[8])
    }

    private fun verifyDay1(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 9, 19), items[0])
        assertEquals(ComparableItem(agedBrie, 1, 1), items[1])
        assertEquals(ComparableItem(elixir, 4, 6), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 14, 21), items[5])
        assertEquals(ComparableItem(backstage, 9, 50), items[6])
        assertEquals(ComparableItem(backstage, 4, 50), items[7])
        assertEquals(ComparableItem(conjured, 2, 4), items[8])
    }

    private fun verifyDay2(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 8, 18), items[0])
        assertEquals(ComparableItem(agedBrie, 0, 2), items[1])
        assertEquals(ComparableItem(elixir, 3, 5), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 13, 22), items[5])
        assertEquals(ComparableItem(backstage, 8, 50), items[6])
        assertEquals(ComparableItem(backstage, 3, 50), items[7])
        assertEquals(ComparableItem(conjured, 1, 2), items[8])
    }

    private fun verifyDay3(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 7, 17), items[0])
        assertEquals(ComparableItem(agedBrie, -1, 4), items[1])
        assertEquals(ComparableItem(elixir, 2, 4), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 12, 23), items[5])
        assertEquals(ComparableItem(backstage, 7, 50), items[6])
        assertEquals(ComparableItem(backstage, 2, 50), items[7])
        assertEquals(ComparableItem(conjured, 0, 0), items[8])  // <-- quality reaches 0
    }

    private fun verifyDay4(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 6, 16), items[0])
        assertEquals(ComparableItem(agedBrie, -2, 6), items[1])
        assertEquals(ComparableItem(elixir, 1, 3), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 11, 24), items[5])
        assertEquals(ComparableItem(backstage, 6, 50), items[6])
        assertEquals(ComparableItem(backstage, 1, 50), items[7])
        assertEquals(ComparableItem(conjured, -1, 0), items[8])
    }

    private fun verifyDay5(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 5, 15), items[0])
        assertEquals(ComparableItem(agedBrie, -3, 8), items[1])
        assertEquals(ComparableItem(elixir, 0, 2), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 10, 25), items[5])
        assertEquals(ComparableItem(backstage, 5, 50), items[6])
        assertEquals(ComparableItem(backstage, 0, 50), items[7])
        assertEquals(ComparableItem(conjured, -2, 0), items[8])
    }

    private fun verifyDay6(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 4, 14), items[0])
        assertEquals(ComparableItem(agedBrie, -4, 10), items[1])
        assertEquals(ComparableItem(elixir, -1, 0), items[2]) // <-- quality reaches 0
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 9, 27), items[5])
        assertEquals(ComparableItem(backstage, 4, 50), items[6])
        assertEquals(ComparableItem(backstage, -1, 0), items[7]) // <-- quality reaches 0
        assertEquals(ComparableItem(conjured, -3, 0), items[8])
    }

    private fun verifyDay7(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 3, 13), items[0])
        assertEquals(ComparableItem(agedBrie, -5, 12), items[1])
        assertEquals(ComparableItem(elixir, -2, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 8, 29), items[5])
        assertEquals(ComparableItem(backstage, 3, 50), items[6])
        assertEquals(ComparableItem(backstage, -2, 0), items[7])
        assertEquals(ComparableItem(conjured, -4, 0), items[8])
    }

    private fun verifyDay8(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 2, 12), items[0])
        assertEquals(ComparableItem(agedBrie, -6, 14), items[1])
        assertEquals(ComparableItem(elixir, -3, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 7, 31), items[5])
        assertEquals(ComparableItem(backstage, 2, 50), items[6])
        assertEquals(ComparableItem(backstage, -3, 0), items[7])
        assertEquals(ComparableItem(conjured, -5, 0), items[8])
    }

    private fun verifyDay9(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 1, 11), items[0])
        assertEquals(ComparableItem(agedBrie, -7, 16), items[1])
        assertEquals(ComparableItem(elixir, -4, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 6, 33), items[5])
        assertEquals(ComparableItem(backstage, 1, 50), items[6])
        assertEquals(ComparableItem(backstage, -4, 0), items[7])
        assertEquals(ComparableItem(conjured, -6, 0), items[8])
    }

    private fun verifyDay10(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, 0, 10), items[0])
        assertEquals(ComparableItem(agedBrie, -8, 18), items[1])
        assertEquals(ComparableItem(elixir, -5, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 5, 35), items[5])
        assertEquals(ComparableItem(backstage, 0, 50), items[6])
        assertEquals(ComparableItem(backstage, -5, 0), items[7])
        assertEquals(ComparableItem(conjured, -7, 0), items[8])
    }

    private fun verifyDay11(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -1, 8), items[0])
        assertEquals(ComparableItem(agedBrie, -9, 20), items[1])
        assertEquals(ComparableItem(elixir, -6, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 4, 38), items[5])
        assertEquals(ComparableItem(backstage, -1, 0), items[6]) // <-- quality reaches 0
        assertEquals(ComparableItem(backstage, -6, 0), items[7])
        assertEquals(ComparableItem(conjured, -8, 0), items[8])
    }

    private fun verifyDay12(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -2, 6), items[0])
        assertEquals(ComparableItem(agedBrie, -10, 22), items[1])
        assertEquals(ComparableItem(elixir, -7, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 3, 41), items[5])
        assertEquals(ComparableItem(backstage, -2, 0), items[6])
        assertEquals(ComparableItem(backstage, -7, 0), items[7])
        assertEquals(ComparableItem(conjured, -9, 0), items[8])
    }

    private fun verifyDay13(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -3, 4), items[0])
        assertEquals(ComparableItem(agedBrie, -11, 24), items[1])
        assertEquals(ComparableItem(elixir, -8, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 2, 44), items[5])
        assertEquals(ComparableItem(backstage, -3, 0), items[6])
        assertEquals(ComparableItem(backstage, -8, 0), items[7])
        assertEquals(ComparableItem(conjured, -10, 0), items[8])
    }

    private fun verifyDay14(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -4, 2), items[0])
        assertEquals(ComparableItem(agedBrie, -12, 26), items[1])
        assertEquals(ComparableItem(elixir, -9, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 1, 47), items[5])
        assertEquals(ComparableItem(backstage, -4, 0), items[6])
        assertEquals(ComparableItem(backstage, -9, 0), items[7])
        assertEquals(ComparableItem(conjured, -11, 0), items[8])
    }

    private fun verifyDay15(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -5, 0), items[0]) // <-- quality reaches 0
        assertEquals(ComparableItem(agedBrie, -13, 28), items[1])
        assertEquals(ComparableItem(elixir, -10, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, 0, 50), items[5]) // <-- quality reaches 50
        assertEquals(ComparableItem(backstage, -5, 0), items[6])
        assertEquals(ComparableItem(backstage, -10, 0), items[7])
        assertEquals(ComparableItem(conjured, -12, 0), items[8])
    }

    private fun verifyDay16(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -6, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -14, 30), items[1])
        assertEquals(ComparableItem(elixir, -11, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -1, 0), items[5])
        assertEquals(ComparableItem(backstage, -6, 0), items[6])
        assertEquals(ComparableItem(backstage, -11, 0), items[7])
        assertEquals(ComparableItem(conjured, -13, 0), items[8])
    }

    private fun verifyDay17(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -7, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -15, 32), items[1])
        assertEquals(ComparableItem(elixir, -12, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -2, 0), items[5])
        assertEquals(ComparableItem(backstage, -7, 0), items[6])
        assertEquals(ComparableItem(backstage, -12, 0), items[7])
        assertEquals(ComparableItem(conjured, -14, 0), items[8])
    }

    private fun verifyDay18(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -8, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -16, 34), items[1])
        assertEquals(ComparableItem(elixir, -13, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -3, 0), items[5])
        assertEquals(ComparableItem(backstage, -8, 0), items[6])
        assertEquals(ComparableItem(backstage, -13, 0), items[7])
        assertEquals(ComparableItem(conjured, -15, 0), items[8])
    }

    private fun verifyDay19(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -9, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -17, 36), items[1])
        assertEquals(ComparableItem(elixir, -14, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -4, 0), items[5])
        assertEquals(ComparableItem(backstage, -9, 0), items[6])
        assertEquals(ComparableItem(backstage, -14, 0), items[7])
        assertEquals(ComparableItem(conjured, -16, 0), items[8])
    }

    private fun verifyDay20(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -10, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -18, 38), items[1])
        assertEquals(ComparableItem(elixir, -15, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -5, 0), items[5])
        assertEquals(ComparableItem(backstage, -10, 0), items[6])
        assertEquals(ComparableItem(backstage, -15, 0), items[7])
        assertEquals(ComparableItem(conjured, -17, 0), items[8])
    }

    private fun verifyDay21(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -11, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -19, 40), items[1])
        assertEquals(ComparableItem(elixir, -16, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -6, 0), items[5])
        assertEquals(ComparableItem(backstage, -11, 0), items[6])
        assertEquals(ComparableItem(backstage, -16, 0), items[7])
        assertEquals(ComparableItem(conjured, -18, 0), items[8])
    }

    private fun verifyDay22(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -12, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -20, 42), items[1])
        assertEquals(ComparableItem(elixir, -17, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -7, 0), items[5])
        assertEquals(ComparableItem(backstage, -12, 0), items[6])
        assertEquals(ComparableItem(backstage, -17, 0), items[7])
        assertEquals(ComparableItem(conjured, -19, 0), items[8])
    }

    private fun verifyDay23(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -13, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -21, 44), items[1])
        assertEquals(ComparableItem(elixir, -18, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -8, 0), items[5])
        assertEquals(ComparableItem(backstage, -13, 0), items[6])
        assertEquals(ComparableItem(backstage, -18, 0), items[7])
        assertEquals(ComparableItem(conjured, -20, 0), items[8])
    }

    private fun verifyDay24(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -14, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -22, 46), items[1])
        assertEquals(ComparableItem(elixir, -19, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -9, 0), items[5])
        assertEquals(ComparableItem(backstage, -14, 0), items[6])
        assertEquals(ComparableItem(backstage, -19, 0), items[7])
        assertEquals(ComparableItem(conjured, -21, 0), items[8])
    }

    private fun verifyDay25(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -15, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -23, 48), items[1])
        assertEquals(ComparableItem(elixir, -20, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -10, 0), items[5])
        assertEquals(ComparableItem(backstage, -15, 0), items[6])
        assertEquals(ComparableItem(backstage, -20, 0), items[7])
        assertEquals(ComparableItem(conjured, -22, 0), items[8])
    }

    private fun verifyDay26(items: Array<ComparableItem>) {
        assertEquals(9, items.size)
        assertEquals(ComparableItem(dexterity, -16, 0), items[0])
        assertEquals(ComparableItem(agedBrie, -24, 50), items[1]) // <-- quality reaches 50
        assertEquals(ComparableItem(elixir, -21, 0), items[2])
        assertEquals(ComparableItem(sulfuras, 0, 80), items[3])
        assertEquals(ComparableItem(sulfuras, -1, 80), items[4])
        assertEquals(ComparableItem(backstage, -11, 0), items[5])
        assertEquals(ComparableItem(backstage, -16, 0), items[6])
        assertEquals(ComparableItem(backstage, -21, 0), items[7])
        assertEquals(ComparableItem(conjured, -23, 0), items[8])
    }

}


