import java.io.FileWriter;

public class TreeDictionary <K extends Comparable<K>,V> implements IDictionary<K,V>{
    int size = 0;
    BSTNode root = null;

    private class BSTNode {
        public V value;
        public K key;
        public BSTNode left, right;
        public BSTNode(V value, K key) {
            this.value = value;
            this.key = key;
        }
    }


    @Override
    public V get(K key){
    if(key==null)
        throw new RuntimeException("Key can't be null !");
    BSTNode target = FindNode(root,key);
    if(target==null)
        return null;
        return FindNode(root,key).value;
    }


    @Override
    public V set(K key, V value){
        if(key==null)
            throw new RuntimeException("Key can't be null !");
        size++;
        if(root==null) {
            root = new BSTNode(value, key);
            return null;
        }
        BSTNode parent = null;
        BSTNode child = root;
        while(child!=null){
            parent = child;
            int compare = key.compareTo(child.key);
            if(compare<0)
            child = child.left;
            else if(compare>0)
                child = child.right;
            else {
                if(child.value == null)
                    throw new RuntimeException("Null value !");
                V prevValue = child.value;
                child.value = value;
                return prevValue;
            }
        }
        int compare = key.compareTo(parent.key);
        if(compare<0)
            parent.left = new BSTNode(value,key);
        else if(compare>0)
            parent.right = new BSTNode(value,key);
        return null;
    }


    @Override
    public V remove(K key){
        if(key==null)
            throw new RuntimeException("Key can't be null !");
        BSTNode parent = null;
        BSTNode child = root;
        V oldValue;
        if(root==null)
            return null;
        while(child!=null) {
            int compare = key.compareTo(child.key);
            if (compare == 0)
                break;
            parent = child;
            if (compare < 0)
                child = child.left;
            else child = child.right;
        }
        size--;
        if(parent==null){
            oldValue = root.value;
            root =removeNode(root);
           return oldValue;
        }
            if(child!=null){
                oldValue = child.value;
                    int compare = key.compareTo(parent.key);
                    if(compare<0)
                        parent.left = removeNode(child);
                    else
                        parent.right = removeNode(child);
        return oldValue;
        }
return null;
    }



private BSTNode removeNode (BSTNode deletedNode){

        if(deletedNode.left==null)
            return deletedNode.right;
        if(deletedNode.right==null)
            return deletedNode.left;
    BSTNode root = removeMin(deletedNode.right);
    root.right = deletedNode.right;
    root.left = deletedNode.left;
    return root;

}



private BSTNode removeMin(BSTNode root){
        while(root.left!=null)
            root = root.left;
    BSTNode temp = new BSTNode(root.value,root.key);
        if(root.right!=null) {
            root.value = root.right.value;
            root.key = root.right.key;
            root.right = root.right.right;
        }
        return temp;
}
    @Override
    public boolean isEmpty(){
return size==0;
    }


    private BSTNode FindNode(BSTNode node, K key){
    if(node==null)
        return null;
        int compare = key.compareTo(node.key);
        if (compare<0)
            return FindNode(node.left,key);
        else if(compare>0)
            return FindNode(node.right,key);
        else return node;
    }


}
