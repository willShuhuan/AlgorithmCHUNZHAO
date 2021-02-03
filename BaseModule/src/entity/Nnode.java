package entity;

import java.util.List;

/**
 * @author DSH
 * @date 2021/1/26
 * @description
 */
public class Nnode {
    public int val;
    public List<Nnode> children;

    public Nnode() {}

    public Nnode(int _val) {
        val = _val;
    }

    public Nnode(int _val, List<Nnode> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }
}
