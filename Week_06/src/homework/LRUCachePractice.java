package homework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DSH
 * @date 2021/3/10
 * @description
 */
public class LRUCachePractice {


    class LRUCache{
        DoubleList cache;
        Map<Integer,Node> map;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new DoubleList();
            map = new HashMap<>();
        }

        public int get(int key) {
            if(map.containsKey(key)) {
                int val = map.get(key).val;
                put(key,val);
                return val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = new Node(key,value);
            if (map.containsKey(key)){
                cache.remove(map.get(key));
                cache.addFirst(node);
                map.put(key,node);
            }else {
                if (capacity==cache.getSize()){
                    Node n2 = cache.removeLast();
                    map.remove(n2.key);
                }
                cache.addFirst(node);
                map.put(key,node);
            }
        }
    }


    class Node{
        int key,val;
        Node prev,next;

        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList{
        Node head,tail;
        int size;

        public DoubleList() {
            //伪节点
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node n){
            Node headNext = head.next;
            n.prev = head;
            headNext.prev = n;
            n.next = headNext;
            head.next = n;
            size++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeLast(){
            Node node = tail.prev;
            remove(node);
            return node;
        }

        public int getSize() {
            return size;
        }
    }




}
