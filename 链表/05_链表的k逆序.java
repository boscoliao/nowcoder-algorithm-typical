import java.util.*;
/*
public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 题目名称：链表的k逆序
 * 题目描述：有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，
 * 则不调整最后几个节点。例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。
 * 调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 */
public class KInverse {
    /**
     * 思路：
     * 翻转前k个节点后，后续的节点用递归来解决
     */
    public ListNode inverse(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        //此时cur为第k+1个节点
        if(count == k) {
            cur = inverse(cur,k);
            while(count-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            //cur为翻转后的第一个节点
            head = cur;
        }
        return head;
    }
}