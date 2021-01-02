<img width="400px" src="/src/main/resources/TrieSketch.jpeg"/>

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

```java
/*
This takes a string and search in the trie, if string found then returns true
else false.
*/
boolean contains(final String word);
```

```java
/*
This returns a list of strings.
It doesn't guarantee to returns strings in lexicographical order but tries best to
maintain lexicographical order.
*/
List<String> getWords();
```

```java
/*
This takes a prefix string and returns all matching string (only prefix matched).
It doesn't guarantee to returns strings in lexicographical order but tries best to
maintain lexicographical order.
*/
List<String> getWordSuggestions(final String prefix);
```

```java
/*
This takes an address to build trie from a text file.
text file should contains only one string in a line.
*/
int buildTrieFromFile(String filePath);
```

```java
/*
This generates a serializeData file with can be used to transmit over the network.
*/
void serializeTrie() throws IOException;
```

```java
/*
This method will take deserialize file path and rebuild the whole trie.
*/
void deserializeTrie(String filePath) throws Exception;
```

```java
void clear();

int size();

```




