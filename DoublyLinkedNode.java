public class DoublyLinkedNode{
    DoublyLinkedNode head;
    String item;
    DoublyLinkedNode next;
    DoublyLinkedNode previous;
    public DoublyLinkedNode(){
        this.next = null;
        this.previous = null;
    }
    public DoublyLinkedNode(String data, DoublyLinkedNode previous){
        this.item = data;
        this.next = null;
        this.previous = previous;
    }
    public void add(String data){
        DoublyLinkedNode newNode = new DoublyLinkedNode(data, null);
        if(head == null){
            head = newNode;
        }
        else{
            DoublyLinkedNode cursor = head;
            while(cursor.next != null){
                cursor = cursor.next;
            }
            newNode.previous = cursor;
            cursor.next = newNode;
        }
    }
    public void add(String data, int index){
        if(index >= size()){
            throw new RuntimeException("Empty Database");
        }
        DoublyLinkedNode newNode = new DoublyLinkedNode(data, null);
        if(index == 0 && head == null){
            head = newNode;
        }
        DoublyLinkedNode cursor = head;
        for(int i = 0; i < index - 1; i++){
            cursor = cursor.next;
        }
        newNode.previous = cursor;
        System.out.println("newNode.previous.item: " + newNode.previous.item);
        newNode.next = cursor.next;
        System.out.println("newNode.next.item: " + newNode.next.item);
        DoublyLinkedNode temp = cursor.next;
        cursor.next = newNode;
        System.out.println("cursor.next.item: " + cursor.next.item + " ; cursor.item: " + cursor.item);
        temp.previous = newNode;
        System.out.println("temp.previous.item: " + temp.previous.item + " ; temp.item: " + temp.item + " ; temp.next: " + temp.next);
    }
    public String printFirst(){
        if(head == null){
            throw new RuntimeException("Empty Database");
        }
        return head.item;
    }
    public int size(){
        DoublyLinkedNode cursor = head;
        int resultSize = 0;
        if(head == null){
            return resultSize;
        }
        while(cursor.next != null){
            resultSize++;
            cursor = cursor.next;
        }
        return resultSize+1;
    }
    public String printIndex(int index){
        if(head == null || index >= size()){
            throw new RuntimeException("Empty Database");
        }
        DoublyLinkedNode cursor = head;
        for(int i = 0; i < index;i++){
            cursor = cursor.next;
        }
        return cursor.item;
    }
}