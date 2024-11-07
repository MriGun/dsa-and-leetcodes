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

    //in place reverse of linkedlist
    //https://leetcode.com/problems/reverse-linked-list/description/
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }

        //in the end!
        return prev;
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

    //https://leetcode.com/problems/reverse-linked-list-ii/description/
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        //skip th first left-1 nodes
        ListNode current = head;
        ListNode prev = null;

        for (int i=0; current!= null && i< left -1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;

        //reverse between lest and right
        ListNode next = current.next;
        for (int i = 0; current!=null && i < right-left +1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        }
        else {
            head = prev;
        }

        newEnd.next = current;

        return head;
    }


    //https://leetcode.com/problems/reverse-nodes-in-k-group/description/
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k <= 1 || head == null) {
            return head;
        }
        //skip th first left-1 nodes
        ListNode current = head;
        ListNode prev = null;

        while (true) {
            ListNode last = prev;
            ListNode newEnd = current;

            //reverse between lest and right
            ListNode next = current.next;
            for (int i = 0; current!=null && i < k +1; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            }
            else {
                head = prev;
            }

            newEnd.next = current;

            if (current == null) {
                break;
            }
        }

        return head;

    }

    //https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
    public ListNode reverseAlternateKGroup(ListNode head, int k) {

        if (k <= 1 || head == null) {
            return head;
        }
        //skip th first left-1 nodes
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode last = prev;
            ListNode newEnd = current;

            //reverse between lest and right
            ListNode next = current.next;
            for (int i = 0; current!=null && i < k +1; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            }
            else {
                head = prev;
            }

            newEnd.next = current;

            //skip the k nodes
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }

        }

        return head;

    }


    //https://leetcode.com/problems/rotate-list/description/
    public ListNode rotateRight(ListNode head, int k) {

        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;
        int rotation = k % length;
        int skip = length - rotation;

        ListNode newLast = head;
        for (int i = 0; i < skip-1; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;

        return head;

    }



    //https://leetcode.com/problems/palindrome-linked-list/description/
    public boolean isPalindrome(ListNode head) {
       ListNode mid = middleNode(head);
       ListNode secondHead = reverseList(mid);

       ListNode reverseHead =  secondHead;

       //compare both the halves
        while (head != null && secondHead != null) {
             if (head.val != secondHead.val) {
                break;
             }
             head = head.next;
             secondHead = secondHead.next;
        }

       reverseList(reverseHead);

        if (head == null || secondHead == null) {
            return true;
        }
        return false;
    }


    //https://leetcode.com/problems/reorder-list/description/
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);

        ListNode headFirst = head;

        //rearrange
        while (headFirst != null && headSecond != null) {
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;

        }

        //next of tail to null
        if (headFirst != null) {
            headFirst.next = null;
        }
    }



}
