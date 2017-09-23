[TOC]
#CodingHistory
DP、two pointer(subarray)、String、LinkedList、backtracing
（九章新基础算法视频+有道云笔记+ppt-》整理第一波）（九章强化班1 2后 3 7）
### DP
triangle:
> 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字
 
input :(x,y) sum | a[x][y]

1.traverse
2.divide & conquer
3.DFS-optimized hash[x][y]

4.从上到下DP or 从下到上

从下到上：f[i][j] =Math.min(f[i-1][j],f[i-1][j-1])+A[i][j];

从上到下：f[i][j] =Math.min(f[i+1][j],f[i+1][j+1])+A[i][j];
* 基本要素

1.状态定义
2.初始化，终点先有值

3.循环递归求解
4.求结果

#### DP使用情况
1.求最大最小、YES/NO、Count(*)

2.Can not sort /swap

3.字符串匹配****

#### sequence

#### matrix

#### backup


#### HARD
* DEMO DAY 
* 诺曼底登陆 状态压缩


### Two pointer

### String
* 排列组合模板
###  Binary search 、 array 
* 二分查找模板
###  BFS 、 DFS 
* Graph、Tree分别的BFS、DFS
* 参数分别可以是什么。图可以是邻接表。
###  classic.Backtracing 

### Binary Tree 、Divide Conqueer 

### Union find  
* 用于判断联通等
* 基本概念有查找、合并操作，大兄弟指针，查找等优化（平均优化，第一次耗时）
* 优点在于动态添加的时候可以做到 O(1)

 246.Graph valid tree: 是否有环可以遍历边，然后找不同集合的公共大兄弟。如果某边两个节点在同一集合那么就是错的。
                       （Tricky 的点是不能有重边，如果本身图有重边就不能用这个方法）
        
###  LinkedList 

### 下面这四个有时间的时候整理下

### Trie Tree
* 又叫做前缀查找树

### Scan line

### Heap

### Deque

```$xslt
这里用来
写部分代码
但是希望解耦
```