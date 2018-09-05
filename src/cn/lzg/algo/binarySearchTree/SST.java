package cn.lzg.algo.binarySearchTree;

/**
 * @author lzg
 * @date 2018/9/4 9:48
 * @desc 顺序查找表
 */
public class SST<Key extends Comparable<Key>, Value> {

    // 顺序查找表中的节点为私有的类, 外界不需要了解顺序查找法节点的具体实现
    // 我们的顺序查找表, 内部本质是一个链表
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node head; //表头
    private int count; //顺序查找表中的节点个数

    //构造函数
    public SST() {
        head = null;
        count = 0;
    }

    //返回顺序表节点个数
    public int size(){
        return count;
    }

    //返回顺序表是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    //向顺序表中插入一个新的（key,value）数据对
    public void insert(Key key,Value value) {

        //查找整个顺序表，看是否已经存在key
        Node node = head;
        //有：替换并return
        while(node != null) {
            // 若在顺序表中找到了同样大小key的节点
            // 则当前节点不需要插入，将该key所对应的值更新为value后返回
            if(key.compareTo(node.key) == 0) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        //顺序表中不存在key，则创建新的节点，将新节点插入到表头
        Node newNode = new Node(key,value);
        newNode.next = this.head;
        this.head = newNode;
        this.count++;
    }

    //查看顺序表中是否包含键值为key的节点
    public boolean contain(Key key) {
        //重新复制head引用，不会改变原有的head
        Node node = head;
        while(head != null) {
            if(node.key.compareTo(key) == 0){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //查找顺序表中key对应的value，存在返回value，不存在返回null
    public Value search(Key key) {
        //重新复制head引用，不会改变原有的head
        Node node = head;
        while(head != null) {
            if(node.key.compareTo(key) == 0){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    //在顺序表中删除（key,value）所对应的节点
    public void remove(Key key) {

        if(head == null){
            return;
        }

        // 如果待删除的节点就是头结点, 则需要特殊处理
        // 思考: 对于链表, 可以使用什么技术不去特殊处理头结点的特殊情况?
        // 解答：在链表前加一个空的头节点
        if(head.key.compareTo(key) == 0){
            Node delNode = head;
            head = head.next;
            //让delNode指向null，将删除节点从链表中断开
            delNode.next = null;
            count--;
            return;
        }

        Node node = head;
        while (node.next != null) {
            if(key.compareTo(node.next.key) == 0) {
                Node delNode = node.next;
                node.next = delNode.next;
                delNode.next = null;
                this.count--;
                return;
            }
        }
    }


}
