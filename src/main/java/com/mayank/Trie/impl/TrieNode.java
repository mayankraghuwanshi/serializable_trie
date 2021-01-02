package com.mayank.Trie.impl;

import java.util.*;

public class TrieNode {

    private boolean endOfWord = false;

    private Map<Character , TrieNode> children = new HashMap<Character,TrieNode>();

    public boolean hasChild(char key){
        return children.containsKey(key);
    }

    public void addChild(char key , TrieNode node){
        children.put(key,node);
    }

    public TrieNode getChild(char key){
        return children.get(key);
    }

    public boolean isEndOfWord(){
        return endOfWord;
    }

    public void setEndOfWord(){
        endOfWord = true;
    }

    public List<Character> getChildrenKeys(){
        return new ArrayList<>(children.keySet());
    }


    /*
    @Return
    This will return a set of keys sorted in reverse lexicographical order.
    * */
    public List<Character> getChildrenKeysDesc(){
        List<Character> keys = new ArrayList<Character>(children.keySet());
        Collections.sort(keys , (a,b)->b.compareTo(a));
        return keys;
    }

    public void deleteAllChild(){
        children.clear();
    }

    public void setEndOfWordFalse(){
        endOfWord = false;
    }
}
