public class Node{
    Node head;
    String item;
    Node next;
    public Node(){
        this.next = null;
    }
    public Node(String item){
        this.item = item;
        this.next = null;
    }
    public int size(){
        Node newNode = head;
        int resultSize = 0;
        if(head == null){
            return resultSize;
        }
        while(newNode.next != null){
            resultSize++;
            newNode = newNode.next;
        }
        return resultSize+1;
    }
    public void add(String item){
        Node newNode = new Node(item);
        if(head == null){
            head = newNode;
        }
        else{
            //the cursor has the same reference address as the Node called as head. This allows the cursor to flow fluently through the head Node without interfering with the data.
            Node cursor = head;
            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = newNode;
        }
    }
    
    public void add(String item, int index){
        if(index >= size()){
            throw new RuntimeException("index out of bounds" + head.size());
        }
        Node newNode = new Node(item);
        if(index == 0){
            Node temp2 = head;
            head = newNode;
            newNode = temp2;
        }
        Node cursor = head;
        for(int i = 0; i < index-1;i++){
            cursor = cursor.next;
        }
        newNode.next = cursor.next;
        cursor.next = newNode;
    }
    
    public String printFirst(){
        if(head == null){
            throw new RuntimeException("Empty Database");
        }
        else{
            return head.item;
        }
    }
    public String deleteFirst(){
        if(head == null){
            throw new RuntimeException("Empty Database");
        }
        else{
            String temp = head.item;
            head = head.next;
            return temp;
        }
    }
    public Boolean contains(String data){
        Node newNode = head;
        if(newNode == null){
            throw new RuntimeException("Empty Database");
        }
        while(newNode.next != null){
            if(newNode.item == data){
                return true;
            }
            newNode = newNode.next;
        }
        return newNode.item == data? true : false;
    }
    public Boolean isEmpty(){
        return head == null? true : false;
    }
 
}

/*public class Node{
    Node head;
    String name;
    int id;
    int grade;

    Node next;

    public Node(String name, int id, int grade){
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.next = null;
    }
    public void add(String name, int id, int grade){

        Node newNode = new Node(name, id, grade);

        if(head == null){
            head = newNode;
        }
        else{
            Node cursor = head;
            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = newNode;
        }


    }
    public void print(){

        
        
        if(head == null){
            throw new RuntimeException("Empty Database");
        }
        else{
            Node cursor = head;
            while(cursor != null){
                System.out.println("Student name: " + cursor.name);
                System.out.println("Student ID: " + cursor.id);
                System.out.println("Student Grade: " + cursor.grade);
                cursor = cursor.next;
            }
        }
    }
}
*/