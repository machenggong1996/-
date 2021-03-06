package leetcode.list;

/**
 * Created by machenggong on 2020/3/16.
 */
public class DeleteDuplicates {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode p = cur; //当前结点

        while (cur != null && cur.next != null) {
            p = cur.next;
            //此处需要先判断p是否为空，在不为空的情况下才能进行后续判断
            while (p != null && cur.val == p.val) {
                p = p.next;
            }
            cur.next = p;
            cur = p;
        }
        return head;
    }

    public static ListNode deleteDuplicatesTest(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode root = new ListNode(0);
        root.next = pHead;
        ListNode preNode = root;
        ListNode curNode = pHead;
        while (curNode != null) {
            if (curNode.next != null && curNode.val == curNode.next.val) {
                while (curNode.next != null && curNode.val == curNode.next.val) {
                    curNode = curNode.next;
                }
                preNode.next = curNode.next;
            } else {
                preNode = curNode;
            }
            curNode = curNode.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode res = deleteDuplicates(listNode1);

        System.out.println();
    }

}
