package backCode;

/**
 * Created by Yu on 2017/8/28.
 */
public class lclinkedlist
{

       public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
     public static void main(String[] arg){
         ListNode a = new ListNode(1);
         a.next= new ListNode(2);
         a.next.next= new ListNode(5);
         a.next.next.next= new ListNode(3);
         a.next.next.next.next= new ListNode(7);
         a.next.next.next.next.next= new ListNode(6);
         ListNode rt = insertionSortList(a);
         while(rt!=null){
             System.out.println(rt.val);
             rt = rt.next;
         }
     }
        public static ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(0);
            // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
            // 所以这里不需要dummy.next = head;
            // 0 -1 2 3 4  10 5 3 ——》新建一个头节点，遍历原来的链表，对原链表的每个节点找到新链表中适合插入位置的前指针，然后执行插入操作。
            while (head != null) {
                ListNode node = dummy;
                System.out.println("node"+node.val);
                while (node.next != null && node.next.val < head.val) {
                    node = node.next;
                }//找到比开头小的元素，然后  0   2
                ListNode temp = head.next;// -1
                head.next = node.next;//0 -》 2
                node.next = head;// -1 -》0
                head = temp;//用head来索引最小的数//-1
            }

            return dummy.next;

        }
}
