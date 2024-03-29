package leetcode.ch4_비선형자료구조;

import java.util.ArrayList;
import java.util.List;

public class A56_208_트라이구현 {

    static class TrieNode{
        char word;
        boolean isEnd;
        TrieNode[] next;
        int size;
        public TrieNode() {
            this.next =  new TrieNode[26];
            this.size = 0;
            this.isEnd = false;
        }

        public TrieNode(char word) {
            this.word = word;
            this.next =  new TrieNode[26];
            this.size = 0;
            this.isEnd = false;
        }
    }
    static class Trie{
        static TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        static void insert(String word) {
            TrieNode tmp = root;
            for(int i=0; i<word.length(); i++){
                if(tmp.next[word.charAt(i)-'a'] == null) tmp.next[word.charAt(i)-'a'] = new TrieNode(word.charAt(i));
                tmp = tmp.next[word.charAt(i)-'a'];
                if(i == word.length()-1) tmp.isEnd = true;
            }
        }

        static boolean search(String word) {
            TrieNode tmp = root;
            for(int i=0; i<word.length(); i++){
                if(tmp.next[word.charAt(i)-'a'] == null) return false;
                tmp = tmp.next[word.charAt(i)-'a'];
            }
            if(!tmp.isEnd) return false;
            return true;
        }

        static boolean startsWith(String prefix) {
            TrieNode tmp = root;
            for(int i=0; i<prefix.length(); i++){
                if(tmp.next[prefix.charAt(i)-'a'] == null) return false;
                tmp = tmp.next[prefix.charAt(i)-'a'];
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_4 = obj.search("app");
        boolean param_3 = obj.startsWith("app");
        System.out.println();
    }
}


