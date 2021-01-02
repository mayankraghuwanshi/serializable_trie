# Serializable Trie
Serializable_trie is a trie implementation in java. This package provides a full-fledged Trie with following features.<br/>
* Insert a string into the trie.
* Delete a string from the trie.
* get words with prefix string.
* get total word count.
* get list of words.
* Build a trie from a text file.
* Create a serialized txt file from the trie.
* deserialize from a txt file.
* Clear while trie.

## Methods
```java
/*
This takes a string as input and insert into the trie.
It will throw Exception if the string contains special symbols
which are not allowed to be inserted.
*/
void insert(final String word) throws Exception;
```

<img width="400px" src="/src/main/resources/TrieSketch.jpeg"/>
