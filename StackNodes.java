public class StackNodes{
    StackNodes top;
    StackNodes previous;
    String item;

    public StackNodes(){
         this.top = null;
         this.previous = null;
    }
    public StackNodes(String data){
         this.previous = null;
         this.item = data;
    }
    public void push(String data){
          StackNodes newNode = new StackNodes(data);
          if(top == null){
               top = newNode;
          }
          else{
               StackNodes cursor = top;
               newNode.previous = top;
               top = newNode;
          }
    }
    public String peek(){
    return top.item;
    }
    public String pop(){
         String result = top.item;
         top = top.previous;
         return result;
    }
    public boolean contains(String data){
        StackNodes cursor = top;
        while(cursor.previous != null){
            if(cursor.item == data){
                return true;
            }
            cursor = cursor.previous;
        }
        if(cursor.item == data){
            return true;
        }
        return false;
    }
    public boolean empty(){
        return top == null? true : false;
    }
}
