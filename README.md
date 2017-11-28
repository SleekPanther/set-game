# Set Game 
An algorithm to find valid sets in the [Game Set](https://en.wikipedia.org/wiki/Set_(game)). This isn't a complete game, just the logic & algorithm to check if a valid set exists so that a hint can be provided.

# Java Version
The more robust version is in [SetGame.java](SetGame.java)

## Card Objects
- The `Card` class defines a data structure to hold 4 pieces of information about a card: **number, shape, shading & color**
- All are represented as **integers** for ease of calculation
- Displaying a card color would just be defining some draw() method that showed a different color based on the integer value

## N Choose 3 Algorithm
While computationally intractable, finding all possible subsets of size 3 can be done iteratively without too much trouble

- `printCombinations()` extracts the same logic from `findSets()` to find all subsets of size 3 using 3 nested loops
- The trick to to have the inner loop start it's index at 1 greater than the parent loop's current index
- This pattern could be continued to find combinations for specific values of **k**
- Doesn't work for arbitrary **k** because that would likely involve a recursive implementation

## Checking For Valid Sets
- Cards have 4 attributes and each attribute must either be the same for all 3 cards, or all different
- Since **number, shape, shading & color** are all integers, checking valid sets is done by examining each attribute and passing the 3 values to `areAllEqual(int num1, int num2, int num3)` and `areAllDifferent(int num1, int num2, int num3)`


## Python Version
The 1st attempt where I came up with the n choose 3 implementation
