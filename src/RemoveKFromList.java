
public class RemoveKFromList {


    ListNode<Integer> removeKFromList(ListNode<Integer> listNode, int k) {
        ListNode<Integer> newHead = new ListNode<>();
        newHead.next = listNode;

        ListNode<Integer> current = listNode;
        ListNode<Integer> previous = newHead;
        while(current != null){
            if (current.value == k){
                previous.next = current.next;
                current = current.next;
            }
            else{
                previous = current;
                current = current.next;
            }
        }
        return newHead.next;
    }





}
