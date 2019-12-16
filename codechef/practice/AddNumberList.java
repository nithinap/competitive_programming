package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddNumberList {
    int getListLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    ListNode addSimilar(ListNode n1, ListNode n2) {
        if (n1.next == null && n2.next == null) return new ListNode(n1.val + n2.val);
        ListNode node = addSimilar(n1.next, n2.next);
        int sum =(n1.val + n2.val) + (int)(node.val / 10);
        node.val %= 10;
        ListNode newNode = new ListNode(sum);
        newNode.next = node;
        return newNode;
    }

    ListNode addRemainingList(ListNode head, ListNode res, int diff) {
        System.out.println("head: " + head.val + "diff: " + diff);
        if (diff == 1) {
            head.next = null;
            head.next = res;
            head.val += (int)(res.val / 10);
            res.val %= 10;
            return head;
        }
        ListNode tmp = addRemainingList(head.next, res, --diff);
        head.val += (int)(tmp.val / 10);
        tmp.val %= 10;
        return head;
    }

    ListNode makeResSingleDigit(ListNode res) {
        if (res.val <= 9) return res;
        ListNode newNode = new ListNode((int)(res.val/10));
        res.val %= 10;
        newNode.next = res;
        return makeResSingleDigit(newNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        // System.out.println(len1 + " " + len2);

        ListNode head1 = l1, head2 = l2;
        int diff = len1 - len2;

        ListNode mark = null;
        if (diff > 0) {
            mark = head1;
            while (diff-- > 0) {
                head1 = head1.next;
            }
        } else {
            diff *= -1;
            mark = head2;
            while (diff-- > 0) {
                head2 = head2.next;
            }
        }
        ListNode node = addSimilar(head1, head2);
        System.out.println("val head similar: " + node.val);
        diff = Math.abs(len1 - len2);
        // System.out.println("mark : " + mark.val + " ; diff: " + diff);
        ListNode res = null;
        if (diff > 0)
            res = addRemainingList(mark, node, diff);
        else
            res = node;

        res = makeResSingleDigit(res);
        return res;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new AddNumberList().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}