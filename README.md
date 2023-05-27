# **bomb-party-word-finder**
This is a word finding repository for the party game of the same name hosted [here](https://jklm.fun).

I'm working through the chapters of *Dan Gusfield's Algorithms on strings, trees, and sequences*. I'm going to use the algorithms in this book in seperate implementations 1 by 1 to compare and contrast this specific use case. I'm not yet sure what metrics I am going to measure and plot.

The data structures described below might then not be implemented until later this academic quarter. 

I'm using Java because it is the fastest language I am familiar with. (C++ incoming)

## **Algorithm Z**

This algorithm appends the the search and find string together and does the fundamental preprocessing of data that many string algorithms use. It then iterates over the created Z-scores array to return words that fit the description.

A few alterations have been made for the sake of convenience at the cost of speed that makes the program function better as a tool for the party game Bomb Party.
