package 자바_알고리즘_인터뷰.배열

import java.util.Deque
import java.util.LinkedList

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        val deque: Deque<Int> = LinkedList()

        var node = head

        while (node != null) {
            deque.addLast(node.`val`)
            node = node.next
        }

        while (deque.isNotEmpty() && deque.size > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false
            }
        }
        return true
    }

    class ListNode(
        var `val`: Int
    ) {
        var next: ListNode? = null
    }
}