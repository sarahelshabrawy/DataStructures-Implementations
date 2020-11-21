public class MiscUtils implements IMiscUtils{

    @Override
    public BinaryTreeNode insert(BinaryTreeNode root, int element) {
        if(root==null)
            return new BinaryTreeNode(element);
        int compare = Integer.compare(element,(Integer) root.element);
        if(compare<0)
            root.left = insert(root.left,element);
        else if(compare>0)
            root.right = insert(root.right,element);
        return root;
    }

    @Override
    public int sumRange(BinaryTreeNode root, int low, int high) {
        if(root==null)
            return 0;
        int rootElement = (Integer)root.element;
        if(rootElement >= low ||rootElement <= high)
        return rootElement+sumRange(root.left,low,high)+sumRange(root.right,low,high);
        return 0;
    }

    @Override
    public boolean isValidBST(BinaryTreeNode root) {
        // the previous implementation was wrong bec you compared the node with its children ONLY
      return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }

    @Override
    public int[] nextSmallerNumber(int[] array) {
        if(array==null)
            throw new RuntimeException("Array can't be null !");
        Stack numbers = new Stack();
        int [] answer = new int[array.length];
        for (int i = 0; i <array.length ; i++) {

            while (!numbers.isEmpty()&&array[i]<array[(int) numbers.peek()])
                answer[(int) numbers.pop()]=i;

            numbers.push(i);
        }
        while(!numbers.isEmpty())
            answer[(int) numbers.pop()]=-1;
        return answer;
    }

    private boolean isValidBST (BinaryTreeNode root , int min , int max){
        if(root==null)
            return true;
        if ((int)root.element<min||(int)root.element>max)
            return false;
            return isValidBST(root.left,min,(int)root.element-1)&&isValidBST(root.right,(int)root.element+1,max);

    }
    public void printTree(BinaryTreeNode root){
        if(root==null)
            return;
        printTree(root.left);
        System.out.println(root.element.toString());
        printTree(root.right);
    }

}
