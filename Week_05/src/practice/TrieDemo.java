package practice;


import entity.TreeNode;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/2/25
 * @description #208 实现Trie前缀树
 * 亚马逊 微软 谷歌
 */
public class TrieDemo {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("leet");
        System.out.println(trie.search("leet"));
    }



}

class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            System.out.println(node);
            if (!node.containsKey(ch)){
                node.put(ch,new TrieNode());
            }
            node = node.get(ch);
            System.out.println(node);
        }
        node.setEnd();
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)){
                node = node.get(ch);
            }else {
                return null;
            }
        }
        return node;
    }

}

class TrieNode{
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    public TrieNode get(char ch){
        return links[ch-'a'];
    }

    public void put(char ch,TrieNode node){
        links[ch-'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}
