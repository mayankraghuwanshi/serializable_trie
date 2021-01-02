package com.mayank.Trie;

import com.mayank.Trie.impl.TrieMap;


import java.io.File;

public class AppRunner {

	public static void main(String[] args) throws Exception{
		File file = new File("testdata.txt");
		File newFile = new File("serializeData.txt");
		Trie trie = new TrieMap();
		trie.buildTrieFromFile(file.getAbsoluteFile().toString());
//		trie.insert("ab");
		trie.serializeTrie();
		trie.clear();
		trie.deserializeTrie(newFile.getAbsoluteFile().toString());
		System.out.println(trie.getWords());



	}
}
