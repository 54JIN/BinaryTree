public class BinaryTree{
    BinaryTree root;
    BinaryTree leftTree;
    BinaryTree rightTree;
    int data;
    public BinaryTree(){
        this.leftTree = null;
        this.rightTree = null;
    }
    public BinaryTree(int data){
        this.data = data;
        this.leftTree = null;
        this.rightTree = null;
    }
    public void add(int data){
        if(root == null){
            BinaryTree tempRoot = new BinaryTree(data);
            root = tempRoot;
        }
        else{
            if(data < root.data){
                BinaryTree tempLeft = new BinaryTree(data);
                root.leftTree = tempLeft;
            }
            else if(data > root.data){
                BinaryTree tempRight = new BinaryTree(data);
                root.rightTree = tempRight;
            }
            else{
                throw new RuntimeException("Root equals data or error");
            }
        }
    }
    public boolean contains(int data){
        return containsData(data, root);
    }
    public boolean containsData(int data, BinaryTree root){
        if(root == null){
            System.out.println(root.data);
            return false;
        }
        else if(root.data == data){
            return true;
        }
        else if(data < root.data){
            return containsData(data, root.leftTree);
        }
        else
            return containsData(data, root.rightTree);
    }
    public static void main(String[] args){
        BinaryTree temp = new BinaryTree();
        temp.add(10);
        temp.add(20);
        System.out.println(temp.contains(10));
        System.out.println(temp.contains(20));
    }
}