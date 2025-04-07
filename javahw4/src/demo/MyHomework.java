package demo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MyHomework {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<Integer, ListNode> nodes = new HashMap<>();
        ListNode head = null;

        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            int nextId = in.nextInt();

            nodes.putIfAbsent(id, new ListNode(id));
            if (head == null) head = nodes.get(id);

            if (nextId != -1) {
                nodes.putIfAbsent(nextId, new ListNode(nextId));
                nodes.get(id).next = nodes.get(nextId);
            }
        }
        in.close();
        
        System.out.println(cycle(head));
    }

    public static int cycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return smallest(head, slow);
            }
        }
        return -1;
    }

    private static int smallest(ListNode head, ListNode met) {
        Set<ListNode> cycle = new HashSet<>();
        ListNode current = met;
        int minId = current.val;

        do {
            cycle.add(current);
            minId = Math.min(minId, current.val);
            current = current.next;
        } while (current != met);

        return minId;
    }
}

