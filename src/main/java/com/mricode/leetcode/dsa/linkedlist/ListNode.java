package com.mricode.leetcode.dsa.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode tail = head;

        ListNode ansList = new ListNode();

        //1->2->4
        //1->3->4

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        tail.next = (list1 != null) ? list1 : list2;

        return head.next;
    }

    //https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }


    //find length of cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                //calculate the length
                ListNode temp = slow;
                int length = 0;

                do {
                    temp = temp.next;
                    length++;
                }
                while (temp != slow);
                return length;
            }
        }

        return 0;
    }

    //https://leetcode.com/problems/linked-list-cycle-ii/description/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        int length = 0;

        while(fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        //find the start node;
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        //keep moving both forward
        while (f!=s) {
            f = f.next;
            s= s.next;
        }

        return s;
    }


    //https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        int slow =  n;
        int fast =  n;

        do {
           slow = findSquare(slow);
            fast = findSquare(findSquare(fast));

        }
        while (fast != slow);

        if (slow ==1) {
            return true;
        }

        return false;
    }

    //https://leetcode.com/problems/middle-of-the-linked-list/description/
    public ListNode middleNode(ListNode head) {

        ListNode first = head;
        ListNode slow = head;

        while (first != null && first.next != null) {
            slow = slow.next;
            first = first.next.next;

        }

        return slow;

    }


    private int findSquare(int number) {

        int ans = 0;
        while (number > 0) {
            int rem = number%10;
            ans  = ans + rem * rem;
            number = number/10;
        }
        return ans;
    }

}
