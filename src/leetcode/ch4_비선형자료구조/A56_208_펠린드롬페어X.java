package leetcode.ch4_비선형자료구조;

import java.util.ArrayList;
import java.util.List;

public class A56_208_펠린드롬페어X {

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

    static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words.length; j++){
                if(i==j) continue;
                Trie root = new Trie();
                String tmp = words[i] + words[j];
                String reverse;
                if(tmp.length() == 1){
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(i);
                    tmpList.add(j);
                    result.add(tmpList);
                    continue;
                }
                //짝수
                if(tmp.length()%2 == 0){
                    root.insert(tmp.substring(0,tmp.length()/2));
                    StringBuilder sb = new StringBuilder(tmp.substring(tmp.length()/2));
                    reverse = sb.reverse().toString();
                }else{ //홀수
                    root.insert(tmp.substring(0,tmp.length()/2));
                    StringBuilder sb = new StringBuilder(tmp.substring(tmp.length()/2+1));
                    reverse = sb.reverse().toString();
                }
                if(root.search(reverse)){
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(i);
                    tmpList.add(j);
                    result.add(tmpList);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String[] words = {"a",""};
        palindromePairs(words);
    }

}


