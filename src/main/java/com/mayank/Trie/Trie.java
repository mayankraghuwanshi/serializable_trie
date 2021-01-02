package com.mayank.Trie;

import java.io.IOException;
import java.util.List;

public interface Trie {

    /*
    This takes a string as input and insert into the trie.
    It will throw Exception if the string contains special symbols
    which are not allowed to be inserted.
    */
    void insert(final String word) throws Exception;

    /*
    This takes a string and delete it from the trie.
    returns 1 if string is deleted and -1 if string not found.
    */
    int delete(final String word);

    int size();

    /*
    This takes a string and search in the trie, if string found then returns true
    else false.
    */
    boolean contains(final String word);

    /*
    This returns a list of strings.
    It doesn't guarantee to returns strings in lexicographical order but tries best to
    maintain lexicographical order.
    */
    List<String> getWords();

    /*
    This takes a prefix string and returns all matching string (only prefix matched).
    It doesn't guarantee to returns strings in lexicographical order but tries best to
    maintain lexicographical order.
    */
    List<String> getWordSuggestions(final String prefix);

    void clear();

    /*
    This takes an address to build trie from a text file.
    text file should contains only one string in a line.
    */
    int buildTrieFromFile(String filePath);

    /*
    This generates a serializeData file with can be used to transmit over the network.
    */
    void serializeTrie() throws IOException;

    /*
    This method will take deserialize file path and rebuild the whole trie.
    */
    void deserializeTrie(String filePath) throws Exception;

}
