class BST {
    
    Node root;
 
   
    BST()
    {
         root = null;
    }
 
    
    void insert(int key)
    {
         root = insertRec(root, key);
    }
 
    
    Node insertRec(Node root, int key)
    {
 
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
 
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        return root;
    }
 
    void show()
    {
         inorderRec(root);
    }
 
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    
    int size()
    {
        return size(root);
    }

    int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    

    }

    public void checkExist(int recieve) {
        int key = recieve;
 
        if (ifNodeExists(root, key))
            System.out.println("YES its present in bst");
        else
            System.out.println("NO its not here ,go check elsewhere");
    }

    static boolean ifNodeExists( Node node, int data) {
        if (node == null)
            return false;
        if (node.key == data)
            return true;
        boolean res1 = ifNodeExists(node.left, data);
        if(res1) return true;
        boolean res2 = ifNodeExists(node.right, data);
        return res2;
    }
}