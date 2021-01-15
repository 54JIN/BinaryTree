import javax.management.RuntimeErrorException;
 
public class QueueNodes{
    QueueNodes top;
    QueueNodes next;
    String item;
 
    public QueueNodes(){
        this.top = null;
        this.next = null;
    }
    public QueueNodes(String data){
        this.item = data;
        this.top = null;
        this.next = null;
    }
    public void push(String data){
        QueueNodes newNodes = new QueueNodes(data);
        if(top == null){
            top = newNodes;
        }
        else{
            QueueNodes cursor = top;
            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = newNodes;
        }
    }
    public int size(){
        int result = 0;
        if(top == null){
            return result;
        }
        QueueNodes cursor = top;
        while(cursor.next != null){
            result++;
            cursor = cursor.next;
        }
        return result+1;
    }
    public String peek(){
        return top.item;
    }
    public String printIndex(int index){
        if(index >= size()){
            throw new RuntimeException("Empty Data Base");
        }
        QueueNodes cursor = top;
        for(int i = 0; i < index;i++){
            cursor = cursor.next;
        }
        return cursor.item;
    }
    public String pop(){
        String result = top.item;
        top = top.next;
        return result;
    }
    public boolean isEmpty(){
        return top == null? true : false;
    }
    public boolean contains(String data){
        if(top == null){
            throw new RuntimeException("Empty Data Base");
        }
        else{
            QueueNodes cursor = top;
            while(cursor.next != null){
                if(cursor.item == data){
                    return true;
                }
                cursor = cursor.next;
            }
            return cursor.item == data? true : false;
        }
    }
}