# **bomb-party-word-finder**
This is a word finding tool for the party game of the same name hosted [here](https://jklm.fun).

This tool is based of Chapter 1 of *Dan Gusfield's Algorithms on strings, trees, and sequences* where the algorithm is referred to as "The Z Algorithm" on page 9.

I'm using Java because it is the fastest language I am familiar with.

## **Algorithm Z**

This algorithm appends the the search and find string together and does the fundamental preprocessing of data that many string algorithms use. It then iterates over the created Z-scores array to return words that fit the description.

A few alterations have been made for the sake of convenience at the cost of speed that makes the program function better as a tool for Bomb Party.
