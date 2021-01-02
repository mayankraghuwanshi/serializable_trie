# Serializable Trie
Serializable_trie is a trie implementation in java. This package provides a full-fledged Trie with following features.<br/>
* Insert a string into the trie.
* Delete a string from the trie.
* Get words with prefix string.
* Get words count.
* Get list of words.
* Build a trie from a text file.
* Create a serialized txt file from the trie.
* Deserialize from a txt file.
* Clear whole trie.

<img width="400px" src="/src/main/resources/TrieSketch.jpeg"/>

## Methods
* This takes a string as input and insert into the trie.
It will throw Exception if the string contains special symbols
which are not allowed to be inserted.
```java
void insert(final String word) throws Exception;
```
* This takes a string and search in the trie, if string found then returns true
else false.
```java
boolean contains(final String word);
```
* This returns a list of strings.
It doesn't guarantee to returns strings in lexicographical order but tries best to
maintain lexicographical order.
```java
List<String> getWords();
```
* This takes a prefix string and returns all matching string (only prefix matched).
It doesn't guarantee to returns strings in lexicographical order but tries best to
maintain lexicographical order.

```java
List<String> getWordSuggestions(final String prefix);
```
* This takes an address to build trie from a text file.
text file should contains only one string in a line.
```java
int buildTrieFromFile(String filePath);
```

* This generates a serializeData file with can be used to transmit over the network.
```java
void serializeTrie() throws IOException;
```
* This method will take deserialize file path and rebuild the whole trie.
```java
void deserializeTrie(String filePath) throws Exception;
```

```java
void clear();

int size();

```




