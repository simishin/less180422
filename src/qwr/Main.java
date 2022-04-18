package qwr;

import static qwr.Main.prnq;

public class Main {
    public  static boolean  prnq(String s){System.out.println(s); return true;}
    public  static boolean  prnt(String s){System.out.print(s); return true;}
    public  static boolean  prne(String s){System.err.println(s); return true;}

    public static void main(String[] args) {
        prnq("start");
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(27);
            List list1 = new List(node1);

            node1.setNextNode(node2);
            node2.setNextNode(node3);
            node3.setNextNode(node4);

            list1.push(-4);
            list1.push(1000, 0);
            list1.printList();
            list1.pop(2);
//            list1.pushHead(0);
            list1.printList();

        }//main
}//class Main--------------------------------------------------------------
class Node {
    private int value;
    private Node nextNode;

    public int  getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    public Node getNextNode() { return nextNode; }
    public void setNextNode(Node nextNode) { this.nextNode = nextNode; }
    public Node() { this.value = 0;  this.nextNode = null; }
    public Node(int value, Node nextNode) { this.value = value; this.nextNode = nextNode; }
    public Node(int value) { this.value = value; this.nextNode = null; }
}//class Node----------------------------------------------------------------

class List {
    private Node head;

    public List() { this.head = null; }
    public List(Node head) { this.head = head; }

    public void printList() {
        assert prnq("-----------");
        Node nodeTmp = this.head;
        int j=0;
        while (nodeTmp != null) {
            System.out.println((j++)+"--"+nodeTmp.getValue());
            nodeTmp = nodeTmp.getNextNode();
        }
    }

    public void push(int value) {
        Node nodeTmp = this.head;
        while (nodeTmp.getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode(new Node(value));
    }

    public void push(int value, int index) {
        if (index==0) {
            pushHead(value);
            return;
        }
        Node nodeTmp = this.head;
        for (int i = 0; i < index - 1 && nodeTmp.getNextNode() != null; i ++) {
            nodeTmp = nodeTmp.getNextNode();
        }
        Node newNode = new Node(value, nodeTmp.getNextNode());
        nodeTmp.setNextNode(newNode);
    }

    private void pushHead(int value) {
        Node node = new Node(value, this.head);
        this.head = node;
    }

    public void pop(){
        Node nodeTmp = this.head;
        while (nodeTmp.getNextNode().getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode(null);
    }//pop
    public void pop(int index){
        if (index==0) {
           this.head=head.getNextNode();
            return;
        }
        Node nodeTmp = this.head;
        for (int i = 0; i < index - 1 && nodeTmp.getNextNode().getNextNode() != null; i ++) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode(nodeTmp.getNextNode().getNextNode());
    }//pop


}//class List
