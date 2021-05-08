import java.util.List;

public class isListPalindrome {


    public boolean isListPalindrome(ListNode<Integer> l) {
        if (l == null) {
            return true;
        }
        long size = getSize(l);
        long firstHalfLimit = 0;
        if (size%2 == 0){
            firstHalfLimit = size/2;
        }else{
            firstHalfLimit = (size/2) - 1;
        }
        ListNode<Integer>slow = l;
        ListNode<Integer>fast = l;
        ListNode<Integer>middle = new ListNode<>();
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (size%2 == 0){
            middle = slow;
        }else{
            middle = slow.next;
        }
        middle = reverse(middle);
        if (equal(firstHalfLimit,l,middle)){
            return true;
        }
        return false;
    }

    ListNode<Integer> reverse(ListNode<Integer>l){
        ListNode<Integer>prev = null;
        ListNode<Integer>current = l;
        ListNode<Integer>next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    boolean equal(long limit,ListNode<Integer>l,ListNode<Integer>secondHalf){
        ListNode<Integer>currentFirst = l;
        ListNode<Integer>currentSecond = secondHalf;
        for (long i = 0; i < limit; i++){
            if (currentFirst.value.longValue() != currentSecond.value.longValue()){
                return false;
            }
            currentFirst = currentFirst.next;
            currentSecond = currentSecond.next;
        }
        return true;
    }

    long getSize(ListNode<Integer>node){
        long size = 0;
        ListNode<Integer>temp = node;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }

}
