package com.mayank;

import com.mayank.Trie.impl.TrieMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class AppRunnerTest {

    static List<String> words = new ArrayList<>(Arrays.asList("evolved,when,years,lorem,model,text,publishing,letters,still,using,in,infancy,is,it,uncover,packages,as,at,versions,looking,be,fact,distribution,accident,long,default,search,web,by,have,established,a,many,the,to,reader,use,sometimes,site,that,has,readable,making,like,its,look,page,here,for,their,content,point,desktop,more-or-less,and,now,of,editors,over,normal,opposed,will,distracted,layout".split(",")));

    @Test
    public void test() throws Exception{
        TrieMap trie = new TrieMap();
        List<String> sortedWords = new ArrayList<>(words);
        Collections.sort(sortedWords , (a, b)->a.compareTo(b));

        for(String word : words){
            trie.insert(word);
        }

        List<String> wordsFromTrie = trie.getWords();
        //insert test
        Assertions.assertEquals(sortedWords , wordsFromTrie);
        trie.serializeTrie();
        TrieMap tempTrie = new TrieMap();

        //serialization and deserialization test
        tempTrie.deserializeTrie(new File("serializeData.txt").getAbsoluteFile().toString());
        Assertions.assertEquals(trie.getWords(),tempTrie.getWords());

        //clear test
        trie.clear();
        Assertions.assertEquals(new ArrayList<>() , trie.getWords());

        //load from file
        File file = new File("testdata.txt");
        trie.buildTrieFromFile(file.getAbsoluteFile().toString());


    }
}
