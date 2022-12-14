package 기본메소드;

import java.util.*;

public class 트라이 {

    public static void main(String[] args) {
        String[] word = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] result = solution(word,queries);
        System.out.println(Arrays.toString(result));
    }

    static public int[] solution(String[] words, String[] queries) {

        trie= new Trie();
        for(int i=0; i<words.length; i++){
            trie.insert(words[i]);
        }
        int[] result = new int[queries.length];
        int i =0;
        for(String query: queries){

            count = 0;
            size = query.length();
            permutation(0,new StringBuilder(),query);
            result[i] = count;
            i++;
        }
        return result;
    }
    static int count, size;
    static Trie trie;
    static void permutation(int length, StringBuilder sb, String str){
        if(length==size){
            if(trie.search(sb.toString()))
                count++;
            return;
        }

        if(str.charAt(length) == '?'){
            for(char c = 'a'; c<'z'; c++){
                sb.append(c+"");
                permutation(length+1,sb,str);
                sb.deleteCharAt(sb.length()-1);
            }
        }else{
            sb.append(str.charAt(length)+"");
            permutation(length+1,sb,str);
        }
    }
    static class Node {
        // 자식노드
        Map<Character, Node> chiledNode = new HashMap<Character, Node>();
        // 단어의 끝인지 아닌지 체크
        boolean endOfword;
    }

    static class Trie {

        // Trie자료구조를 생성할 떄 rootNode는 기본적으로 생성
        Node rootNode = new Node();

        // Trie에 문자열 저장
        void insert(String str) {
            // Trie자료구조는 항상 rootNode부터 시작
            Node node = this.rootNode;

            // 문자열의 각 단어마다 가져와서 자식노드 중에 있는지 체크
            // 없으면 자식노드 새로 생성
            for (int i = 0; i < str.length(); i++) {
                node = node.chiledNode.computeIfAbsent(str.charAt(i), key -> new Node());
            }
            // 저장 할 문자열의 마지막 단어에 매핑되는 노드에 단어의 끝임을 명시
            node.endOfword = true;
        }

        // Trie에서 문자열 검색
        boolean search(String str) {
            // Trie자료구조는 항상 rootNode부터 시작
            Node node = this.rootNode;

            // 문자열의 각 단어마다 노드가 존재하는지 체크
            for (int i = 0; i < str.length(); i++) {
                // 문자열의 각 단어에 매핑된 노드가 존재하면 가져오고 아니면 null
                node = node.chiledNode.getOrDefault(str.charAt(i), null);
                if (node == null) {
                    // node가 null이면 현재 Trie에 해당 문자열은 없음
                    return false;
                }
            }
            // 문자열의 마지막 단어까지 매핑된 노드가 존재한다고해서 무조건 문자열어 존재하는게 아님
            // busy를 Trie에 저장했으면, bus의 마지막 s단어에 매핑 된 노드는 존재하지만 Trie에 저장된건 아님
            // 그러므로 현재 노드가 단어의 끝인지 아닌지 체크하는 변수로 리턴
            return node.endOfword;
        }
    }
}
