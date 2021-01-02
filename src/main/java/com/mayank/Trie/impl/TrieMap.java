package com.mayank.Trie.impl;

import com.mayank.Trie.Trie;

import java.io.*;
import java.util.*;

public class TrieMap implements Trie {

    private final TrieNode root = new TrieNode();

    private int wordCount = 0;

    private static List<Character> bagOfNotAllowedKeys = new ArrayList<Character>(Arrays.asList('<','>',']'));

    @Override
    public void insert(String word) throws Exception{
        word = word.toLowerCase(Locale.ROOT);
        TrieNode currentNode = root;
        for(char key : word.toCharArray()){
            if(bagOfNotAllowedKeys.contains(key)){
                throw new Exception(String.format("string %s contains character not allowed to be inserted.", word));
            }
            TrieNode tempNode;
            boolean newCreatedNode = false;

            if(currentNode.hasChild(key)){
                tempNode = currentNode.getChild(key);
            }
            else{
                tempNode = new TrieNode();
                newCreatedNode = true;
            }

            if(newCreatedNode){
                currentNode.addChild(key ,tempNode);
            }

            currentNode = tempNode;

        }
        currentNode.setEndOfWord();
        ++wordCount;
    }

    @Override
    public int delete(String word){
        TrieNode currentNode = root;
        for(char key : word.toCharArray()){
            if(!currentNode.hasChild(key)) return -1;
            currentNode = currentNode.getChild(key);
        }
        if(currentNode.isEndOfWord()) {
            currentNode.setEndOfWordFalse();
            return 1;
        }

        return -1;
    }

    @Override
    public void clear(){
        root.deleteAllChild();
    }

    @Override
    public int size() {
        return wordCount;
    }

    @Override
    public boolean contains(String word) {

        TrieNode currentNode = root;

        for(char key : word.toCharArray()){
            if(!currentNode.hasChild(key)) return false;
            currentNode = currentNode.getChild(key);
        }

        return currentNode.isEndOfWord();
    }

    @Override
    public List<String> getWordSuggestions(String prefix){
        TrieNode currentNode = root;
        List<String> result = new ArrayList<>();
        for(char key : prefix.toCharArray()){
            if(!currentNode.hasChild(key)) return result;
            currentNode = currentNode.getChild(key);
        }
        Pair pair = new Pair(prefix , currentNode);
        return getWordsHelper(pair);
    }

    @Override
    public List<String> getWords() {
        TrieNode currentNode = root;
        Pair pair = new Pair("" , currentNode);
        return getWordsHelper(pair);
    }

    private List<String> getWordsHelper(Pair firstPair){
        List<String> result = new ArrayList<String>();
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(firstPair);

        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            String word = pair.getWord();
            TrieNode node = pair.getNode();

            if(node.isEndOfWord()) result.add(word);

            for(char key : node.getChildrenKeysDesc()){

                stack.push(new Pair(word+key , node.getChild(key)));
            }
        }
        return result;
    }



    @Override
    public int buildTrieFromFile(String filePath) {
        int count=0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while((line=reader.readLine())!=null){
                this.insert(line);
                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return count;
    }


    @Override
    public void serializeTrie() throws IOException{
        StringBuilder string = new StringBuilder();
        TrieNode currentNode = root;
        serializeHelper(currentNode , string);
        File file = new File("serializeData.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        writer.write(string.toString());
        writer.close();
    }

    private void serializeHelper(TrieNode node , StringBuilder string){
        if(node.isEndOfWord()){
            string.append(']');
        }
        for(char key : node.getChildrenKeys()){
            string.append(key);
            serializeHelper(node.getChild(key) , string);
            string.append('<');
        }
    }


    @Override
    public void deserializeTrie(String filePath) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = reader.readLine())!=null){
            for(char key : line.toCharArray()){
                if(key==']'){
                    this.insert(sb.toString());
                }
                else if(key=='<'){
                    sb.deleteCharAt(sb.length()-1);
                }
                else{
                    sb.append(key);
                }
            }
        }
    }
}
