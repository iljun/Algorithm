package BST;

public class Main {
    public static void main(String[] args){
        BSTTree tree = new BSTTree();
//        tree.insert();
    }
}
class Node{
    int key;
    Node leftChild;
    Node rightChild;

    public Node(int key){
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node(){
        this.leftChild=null;
        this.rightChild=null;
    }
}

class BSTTree{
    private Node root = new Node();

    public Node insertKey(Node root, int key){
        Node head = root;
        Node newNode = new Node(key);

        if(head==null){
            return newNode;
        }else if(key < head.key){
            head.leftChild = insertKey(head.leftChild,key);
            return head;
        }else if(head.key < key){
            head.rightChild = insertKey(head.rightChild,key);
            return head;
        }else{
            return head;
        }
    }

    public void insert(int key){
        root = insertKey(root,key);
    }

    public Node search(int key){
        Node tmp = root;
        while(tmp!=null){
            if(tmp.key<key){
                tmp = tmp.leftChild;
            }else if(key < tmp.key){
                tmp = tmp.rightChild;
            }else
                return tmp;
        }
        return tmp;
    }


    public void remove(int key){
        Node current = root;
        Node parent = root;
        while(current.key!=key){
            parent = current;
            if(current.key < key){
                current = current.leftChild;
            }else if(key < current.key){
                current = current.rightChild;
            }
            if(current==null)
                return;
        }

        if(current.leftChild==null && current.rightChild == null){
            if(parent.leftChild==current){
                parent.leftChild=null;
            }else
                parent.rightChild = null;
        }else if(current.leftChild == null){
            if(parent.leftChild==current){
                parent.leftChild=current.rightChild;
            }else
                parent.rightChild = current.rightChild;
        }else if(current.rightChild == null){
            if(parent.leftChild==current){
                parent.leftChild=current.leftChild;
            }else
                parent.rightChild = current.leftChild;
        }else{
            Node parent2 = current;
            current = current.leftChild;
            while(current.rightChild!=null){
                parent2=current;
                current = current.rightChild;
            }

            if(parent.leftChild==parent2){
                parent.leftChild = current;
                parent2.leftChild=null;
            }else {
                parent.rightChild = current;
                parent2.rightChild = null;
            }
        }
    }
}