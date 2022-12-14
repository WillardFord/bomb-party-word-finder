# bomb-party-word-finder
This is a word finding repository for the party game

We want to quickly find words that have a given substring. This presents two things to keep in mind:
1) Efficient time complexity to find substring so that the bomb doesn't go off before the time runs out. (space complexity would also be nice)
2) We need a data structure that can handle any number of given input words. A "generalized __"

Viable data structures that exist in my research are:
1) A suffix tree
    * Using Ukkonen's algorithm can be built in linear time
        * Need to check if this works for a generalized suffix tree with greater than 2 words
    * Finding a substring of length m is also done in linear time.
    * Takes up a lot of additional space. Quadratic growth asymptotically.
    * These algorithims can be found in Dan Gusfield's Textbook
2) A suffix array
    * Can be built in linear time and constant space !(shown here)[https://arxiv.org/abs/1610.08305]
    * A generalized suffix array for multiple strings might be more difficult. Is possible as !(shown here)[https://link.springer.com/chapter/10.1007/BFb0027775]
    * Find a substring takes logrithimic time which is pretty good.
3) An enhanced suffix array
    * Takes the space efficiency of a suffix array and applies the algorithm of a suffix tree.
    * Thus it is the most efficient on both counts.
    * Need to double check that it can be constructed in still in linear time for a generalized enhanced suffix array. Complex enough topic that the only way to find out is probably just to do.
    * !(This)[http://www.mi.fu-berlin.de/wiki/pub/ABI/RnaSeqP4/enhanced-suffix-array.pdf] seems like a good resource


