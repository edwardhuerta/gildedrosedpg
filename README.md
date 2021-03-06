# My thought process:

Step 1 : get familiar with the code. I studied the method updateQuality() and tried to find patterns and quick wins.

Step 2 : Get familiar with the state machine that is the GildedRose.kt class. GildedRose.kt receives an item array, and it
manipulates the numbers. I notice that there is a TexttestFixture.kt class that I can use to generate data!

Step 3 : run TexttestFixture.kt and see the output. By default, it is set to run for 2 days only. But I change that to 10, 15, 20, 25, 26.
I can see that the numbers have limits, some quality values increase, some decrease, and some stop after some time. I can see that after
running the algorithm for 26 days, the system stabilizes, meaning, there are no more meaningful changes in the quality values.

Step 4 : I cannot manipulate the Item.kt class, but I notice that it is declared as "open", meaning it is not final. When I write
all the tests from running TexttestFixture.kt for all the 26 days, I want the Assertions to be readable and clean. So
I make a ComparableItem.kt class that extends Item.kt class, and inside Comparable.kt class I can override the equals method. This
is useful when I do assertions in the GildedRoseTest.kt because it makes the Assertions more readable. This does require me to add
a generic type in GildedRose.kt class so that it can receive types of Item.kt or any subclasses.

Step 5 : Before doing any changes to updateQuality(), we must be 100% sure we do not break the system as we are refactoring. So
therefore I run and copy the data output from TexttestFixture.kt and input that into the GildedRoseTest.kt for all 26 days! These 20 minutes
spent copying and pasting code is valuable, and will save me a lot of headaches in the future and confirm that I have not broken any
business logic! I wanted to be very verbose, even when the quality value of some Item.kt instances do not change!

Step 6 : From the code I have written in GildedRostTest.kt, I can start seeing how the quality values are changing through time.
Each type of Item has its own characteristics. I do not want to use the original code in the updateQuality() method because
there are a lot of if-else nested statements and it is not easily readable. Because various Item.kt instances require different logic, I decide
to use an interface! I always carry in my mind the golden rule of choosing Composition over inheritance. The ItemProcessor.kt interface implementation
will not hold any state from the Item.kt, it simply manipulates Item.kt according to the values we see in the GildedRostTest.kt tests. (The Item.kt class
already holds the state!)

Step 7 : Create a processor for each Item. As each one is created, I can re-run the test in GildedRoseTest.kt to verify that I
am complying with the original logic and that I am not braking anything. Those 20 minutes spent before are coming in really handy now!

Step 8 : Item.kt has 3 properties : name, sellIn, quality. the property called "name" is the only property I can use to identify an Item.kt instance.
So create a Map containing as the key the name of the Item, and the value of each entry will contain the corresponding processor.

Step 9 : By using this strategy, I encapsulate the different quality calculations for each Item instance. This makes it
future proof, because if a new Item.kt type is introduced, we simply create a new Processor class that knows how to manipulate the Item values, and
add it to the "processorsByName" map.

Step 10 : Please note that DexterityProcessor, ElixirProcessor, ConjuredProcessor processors have the same logic, so they have been replaced by a
processor called : DecreaseByTwoAfterSellInExpiresProcessor since they share the following logic : a sellIn below 0 causes the quality to increase by -2 and not by -1 .
I left the classes DexterityProcessor.kt, ElixirProcessor.kt, ConjuredProcessor.kt in the code to show that they are identical.

Step 11 : I wanted to distinguish how the SellIn property of an Item is decreased by 1 after every time the quality value has been modified. I noticed that the line
```
item.sellIn = item.sellIn - 1
```
was being repeated inside each Processor class except SulfurasProcessor.kt . So I created the SellInPostProcessor.kt class that has the responsibility
to decrease the sellIn value by 1 after the quality value has been calculated. This was the end result of how to setup the "processorsByName" map inside GlideRose.kt:

```
private val processorsByName: Map<String, ItemProcessor> = mapOf(
        dexterity to SellInPostProcessor(DecreaseByTwoAfterSellInExpiresProcessor()),
        agedBrie  to SellInPostProcessor(AgedBrieProcessor()),
        elixir    to SellInPostProcessor(DecreaseByTwoAfterSellInExpiresProcessor()),
        sulfuras  to SulfurasProcessor(),
        backstage to SellInPostProcessor(BackstageProcessor()),
        conjured  to SellInPostProcessor(DecreaseByTwoAfterSellInExpiresProcessor()),
    )
```

But I do not like how that looks. For example,
```
SellInPostProcessor(DecreaseByTwoAfterSellInExpiresProcessor())
```
is less readable and looks confusing. So I decided to not use the SellInPostProcessor.kt and put back the line
```
item.sellIn = item.sellIn - 1
```
into each Processor class that needs it.

Therefore, the end result of processorsByName is:
```
private val processorsByName: Map<String, ItemProcessor> = mapOf(
        dexterity to DecreaseByTwoAfterSellInExpiresProcessor(),
        agedBrie  to AgedBrieProcessor(),
        elixir    to DecreaseByTwoAfterSellInExpiresProcessor(),
        sulfuras  to SulfurasProcessor(),
        backstage to BackstageProcessor(),
        conjured  to ConjuredProcessor(),
    )
```
which is much more readable for this specific small project.

The conjured item needs to be "fixed" because the item should degrade twice as fast. That is not the case
in the default implementation, so I modified the ConjuredProcessor to always decrease by 2.

# How to run
you can run the code I wrote with the command line :
```
sh gradlew test
```
This will show that the test will pass for my modified implementation.

