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



    int delete(final String word);

    int size();

    boolean contains(final String word);

    List<String> getWords();

    List<String> getWordSuggestions(final String prefix);

    void clear();

    int buildTrieFromFile(String filePath);

    void serializeTrie() throws IOException;

    void deserializeTrie(String filePath) throws Exception;

}
