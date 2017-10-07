package leetcode;

/**
 * Created by yu on 17-10-2.
 */
public class LC292_BRAIN_NIMGAME {

    public boolean canWinNim(int n) {
        // 在有规则的时候尽量寻找规则，这里可以看出是%4
        //  没有规则可以先从朴素解法入手：用{n1,n2,n3} traceback 然后countall 可能性的奇偶（一定会TLE）
        // 注意的是，如果只有四个，而且先手，那么一定会赢。所以想办法剩到4个，而在大数逼近四个过程，因为另一个人一定要拿一个，而这里可以拿1-3个，所以一定有余四的情况，只要模除四不等于0,那么先手只要使得满足后手+先手每轮=4就可以啦
        return n%4 != 0 ;
    }
}
