package com.mayank.Trie.impl;


public final class Pair {

    private String word;

    private TrieNode node;

    Pair(String w , TrieNode n){

        word=w;
        node=n;
    }

    public String getWord(){
        return word;
    }

    public TrieNode getNode() {
        return node;
    }
}
