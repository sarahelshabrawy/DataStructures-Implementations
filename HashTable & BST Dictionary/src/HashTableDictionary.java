public class HashTableDictionary <K extends Comparable<K>,V> implements IDictionary<K,V>{
    private int maxSize;
    private HashNode<K,V>[] hash;
    int size =0;

    public HashTableDictionary(int size){
        this.maxSize = size;
        hash =  new HashNode[size];
    }
    public HashTableDictionary(){
        this.maxSize = 199; //any prime number
        hash = new HashNode[maxSize];

    }


     class HashNode<K,V> {
        K key;
        V value;
        HashNode<K,V> next;
        private HashNode(K key,V value){
            this.key = key;
            this.value = value;
        }
    }


    @Override
    public V get(K key) {
        if(key==null)
            throw new RuntimeException("Key can't be null !");
        HashNode<K,V> bucketHead ;
        int index = hashFunction(key);
        if(hash[index]==null)
            return null;
        else{
            bucketHead = hash[index];
            while (bucketHead!=null&&bucketHead.key!=key){
                bucketHead = bucketHead.next;
            }
            if(bucketHead==null)
                return null;
            else {
                return bucketHead.value;
            }
        }
    }

    @Override
    public V set(K key, V value) {
        if(key==null)
            throw new RuntimeException("Key can't be null !");
        HashNode<K,V> bucketHead ;
        int index = hashFunction(key);
        size++;
        if(hash[index]==null)
            hash[index] = new HashNode<>(key, value);
        else{
            bucketHead = hash[index];
            while (bucketHead.next!=null&&bucketHead.key!=key){
                bucketHead = bucketHead.next;
            }
            if(bucketHead.next==null)
                bucketHead.next = new HashNode<>(key,value);
            else {
                V prevValue = bucketHead.value;
                bucketHead.value = value;
                return prevValue;
            }

        }
        return null;
    }

    @Override
    public V remove(K key) {
        if(key==null)
            throw new RuntimeException("Key can't be null !");
        HashNode<K,V> bucketHead ;
        int index = hashFunction(key);
        if(hash[index]==null)
            return null;
        else{
            size--;
            bucketHead = hash[index];
            if(bucketHead.key==key) {
                V prevValue = bucketHead.value;
                hash[index]=null;
                return prevValue;
            }
            while (bucketHead.next!=null&&bucketHead.next.key!=key){
                bucketHead = bucketHead.next;
            }
            if(bucketHead.next==null)
                return null;
            V prevValue = bucketHead.next.value;
            bucketHead.next = bucketHead.next.next;

            return prevValue;
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    private int hashFunction (K key){
        return (Integer) key %maxSize;

    }
}
