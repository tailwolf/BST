/**
 * 二叉搜索树
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 搜索节点
     * @param key
     * @return
     */
    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node node, Key key){
        if(node == null){
            return null;
        }

        int cmp = node.key.compareTo(key);
        if(cmp < 0){
            //小于
            return get(node.right, key);
        }else if(cmp > 0){
            return get(node.left, key);
        }else {
            return node.value;
        }
    }

    /**
     * 插入节点
     * @param key
     * @param value
     */
    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value){
        if(node == null){
            return new Node(key, value);
        }


        int cmp = node.key.compareTo(key);
        if(cmp < 0){
            //小于
            node.right = put(node.right, key, value);
        }else if(cmp > 0){
            node.left = put(node.left, key, value);
        }else {
            node.value = value;
        }

        return node;
    }

    /**
     * 删除节点
     */
    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node node, Key key){
        if(node == null){
            return null;
        }

        int cmp = node.key.compareTo(key);
        if(cmp < 0){
            node.right = delete(node.right, key);
        }else if(cmp > 0){
            node.left = delete(node.left, key);
        }else {
            if(node.right == null){
                return node.left;
            }
            if(node.left == null){
                return node.right;
            }

            Node tmp = node;
            node = minNode(node.right);
            node.left = tmp.left;
            node.right = delMinNode(tmp.right);
        }
        return node;
    }

    private Node minNode(Node node){
        if(node == null){
            return null;
        }

        if(node.left == null){
            return node;
        }

        return minNode(node.left);
    }

    private Node delMinNode(Node node){
        if(node.left == null){
            return node.right;
        }

        return delMinNode(node.left);
    }

    /**
     * 前缀遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.print(node.value);
    }


    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        bst.put(1, 1);
        bst.put(3, 3);
        bst.put(7, 7);
        bst.put(2, 2);
        bst.put(4, 4);
        bst.put(8, 8);
        bst.put(6, 6);
        bst.put(9, 9);
        bst.put(5, 5);
        //前缀遍历
        bst.preOrder();
        System.out.println();
        //中序遍历
        bst.inOrder();
        System.out.println();
        //后序遍历
        bst.postOrder();
    }
}
