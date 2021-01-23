public class BinaryTree{
    BinaryTree root;
    BinaryTree leftTree;
    BinaryTree rightTree;
    int data;
    //having two subtrees without data being initialized
    public BinaryTree(){
        this.leftTree = null;
        this.rightTree = null;
    }
    //the tree will contain data with subtrees bieng null
    public BinaryTree(int data){
        this.data = data;
        this.leftTree = null;
        this.rightTree = null;
    }
    public void addBinaryTree(BinaryTree root, int data){
        if(root.data == data){
            throw new RuntimeException("Data already exist");
        }
        else if(data < root.data && root.leftTree == null){
            BinaryTree temp = new BinaryTree(data);
            root.leftTree = temp;
        }
        else if(data > root.data && root.rightTree == null){
            BinaryTree temp = new BinaryTree(data);
            root.rightTree = temp;
        }
        else if(data < root.data){
            addBinaryTree(root.leftTree, data);
        }
        else if(data > root.data){
            addBinaryTree(root.rightTree, data);
        }
    }
    //add on to the data
    public void add(int data){
        if(root == null){
            BinaryTree tempRoot = new BinaryTree(data);
            root = tempRoot;
        }
        else{
            addBinaryTree(root, data);
        }
    }
    public boolean contains(int data){
        return containsData(root, data);
    }
    public boolean containsData(BinaryTree root, int data){
        if(root == null){
            return false;
        }
        else if(data < root.data){
            return containsData(root.leftTree, data);
        }
        else if(data > root.data){
            return containsData(root.rightTree, data);
        }
        return true;
    }
    public static void main(String[] args){
        BinaryTree temp = new BinaryTree();
        temp.add(3);
        System.out.println(temp.contains(1000));
    }
}
