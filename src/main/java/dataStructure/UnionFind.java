package dataStructure;

/**
 * Created by Yu on 2017/9/9.
 */
    //分别用数组 Hashmap实现并查集 通常可以用hashset、BFS等代替。
class UnionFind {
    private int count = 0;
    private int[] parent, rank;//用数组实现

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;//每个元素的大兄弟都是自己
        }
    }

    public int find(int p) {
        while (p != parent[p]) {//直到找到这个大兄弟节点
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootQ] > rank[rootP]) {//尽量使得不逆序
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
            }
        }
        count--;// 表示目前分几组
    }

    public int count() {
        return count;
    }
}