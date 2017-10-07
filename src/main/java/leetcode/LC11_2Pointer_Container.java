package leetcode;

/**
 * Created by yu on 17-10-1.
// */
//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//        Note: You may not slant the container and n is at least 2.
public class LC11_2Pointer_Container {
    public int maxArea(int[] height) {
        //一维数组，看情况，属于双指针对撞型的灌水题目，只要找一个，所以2，3为两边的时候，3 如果向里面缩进，一定会减少最大灌水面积，因为现在高度取决于2，所以3向里面走遇到6，整个container的高度也就是2.不会变好，而且长度还在缩小，所以不行。而如果把小的向里面移动，可能会遇到高壁垒，这样就比如形成4 3这样高度就变成右边了则可能会变高！
        //if中间存在更高的面积 那么一定是在宽缩小情况下高的变化。可能担心存在最终是2 1 1 9 1 5 3的情况就是说中间有 (9到5)的地方。 5*2 < 2* 6最终输出12 但是12不能算是container啊
        //发生上面担心主要可能曲解了这题目的意思，大概是要找到条纵线然后这两条线以及X轴构成的容器能容纳最多的水。没有硬性要求一定不能穿过去！因为毕竟是线而不是板子
        int right = height.length - 1 ;
        int left = 0;
        int rt = 0;
        while(left <= right){
            rt = Math.max(rt, (right - left) * Math.min(height[right] ,height[left] ));
            if( height[left] < height[right]  ){
                left++;
            }else{
                right--;
            }
        }
        return rt;
    }

}
