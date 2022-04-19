package qwr;

import static qwr.Main.prnq;
import static qwr.Main.prnt;

public class Main {
    public  static boolean  prnq(String s){System.out.println(s); return true;}
    public  static boolean  prnt(String s){System.out.print(s); return true;}
    public  static boolean  prne(String s){System.err.println(s); return true;}

    public static void main(String[] args) {
        prnq("start");
        ListInt y = new ListInt(2,5,7,2,8,9,1,0);
        y.printList();
        y.push(12,0);
        y.pushHead(new NodeInt(13));
        //Найти среднее арифметическое значение элементов списка.
        y.printList("среднее арифметическое значение = "+y.average());
        //Перенести в начало списка его последний элемент.
        y.pushHead(y.pop());
        y.push(new NodeInt(32));
        y.printList();
        //Поменять местами первый и последний элементы списка.
        NodeInt tmp = y.pop();
        y.push(y.popHead());
        y.pushHead(tmp);
        y.printList("Поменять местами");

        ListGns q = new ListGns("acbf","bcdr","cfgj","dfqa");
        q.printList();
        q.push("dfg");
        q.printList("AAA");
        prnq("количество слов в списке "+wQer(q));
        prnq("каждое следующее слово... "+(wQtt(q) ? "Yes" : "No"));
        prnq("которые совпадают с первым "+wQtq(q));
        prnq("упорядочены ли элементы списка по алфавиту "+(wQtb(q) ? "Yes" : "No"));
        q.printList("BBB");
        q.reverse();
        q.printList("CCC");
//            Node node1 = new Node(1);
//            Node node2 = new Node(2);
//            Node node3 = new Node(3);
//            Node node4 = new Node(27);
//            List list1 = new List(node1);
//
//            node1.setNextNode(node2);
//            node2.setNextNode(node3);
//            node3.setNextNode(node4);
//
//            list1.push(-4);
//            list1.push(1000, 0);
//            list1.printList();
//            list1.pop(2);
////            list1.pushHead(0);
//            list1.printList();

    }//main
    //Определить количество слов в списке,
    // которые начинаются и заканчиваются на одну букву.
    public static int wQer(ListGns x){
        int z=0;
        for (NodeGns j:x.integr() ) {
            String h =j.getValue().toString();
            if (h.charAt(0)==h.charAt(h.length()-1)) z++;
        }
        return z;
    }//wQer
    //Проверить, что каждое следующее слово в
    // списке начинается с последней буквы предыдущего.
    public static boolean wQtt(ListGns x){
        NodeGns[] y = x.integr();
        if (y.length<2) return false;
        assert prnq("~~"+y[0].getValue().toString());
        char hs = y[0].getValue().toString().charAt(y[0].getValue().toString().length()-1);
        for (int i = 1; i < y.length; i++) {
            assert prnq(i+"~"+(char)hs+":"+y[i].getValue().toString().charAt(0));
            if( y[i].getValue().toString().charAt(0) != hs) return false;
            hs = y[i].getValue().toString().charAt(y[i].getValue().toString().length()-1);
        }
        return true;
    }//wQtt
    //Определить количество слов в списке, которые совпадают
    // с первым (последним) словом списка.
    public static int wQtq(ListGns x){
        int z=0;
        NodeGns[] y = x.integr();
        String h = y[0].getValue().toString();
        for (int i = 1; i < y.length; i++) {
            if (h.equals(y[i].getValue().toString())) z++;
        }
        return z;
    }//wQtq
    //Проверить, упорядочены ли элементы списка по алфавиту.
    public static boolean wQtb(ListGns x) {
        NodeGns[] y = x.integr();
        for (int i = 1; i < y.length; i++) {
            int h= y[i-1].getValue().toString().compareTo(y[i].getValue().toString());
            if (h>0) return false;
        }
        return true;
    }//wQtb
    //Перевернуть список наоборот.

}//class Main--------------------------------------------------------------
class NodeInt {
    private int value;
    private NodeInt nextNode;

    public NodeInt() { this.value = 0;  this.nextNode = null; }
    public NodeInt(int value, NodeInt nextNode) { this.value = value; this.nextNode = nextNode; }
    public NodeInt(int value) { this.value = value; this.nextNode = null; }
    public NodeInt getNextNode() { return nextNode; }
    public int  getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    public void setNextNode(NodeInt nextNode) { this.nextNode = nextNode; }
}//class Node----------------------------------------------------------------

class ListInt {
    private NodeInt head;

    public ListInt() { this.head = null; }
    public ListInt(NodeInt head) { this.head = head; }

    public ListInt(int ...vls){
        this.head=new NodeInt(vls[0]);
        if (vls.length>1){
            assert prnq("="+vls.length);
            NodeInt nodeTmp = this.head;
            for (int i = 1; i < vls.length; i++) {
                nodeTmp.setNextNode(new NodeInt(vls[i]));
                nodeTmp = nodeTmp.getNextNode();
            }//for
        }//if
    }//List

    public void printList() { printList(""); }
    public void printList(String str) {
        assert prnq("-----------"+str);
        NodeInt nodeTmp = this.head;
        int j=0;
        while (nodeTmp != null) {
            prnt((j++)+": "+nodeTmp.getValue()+"\t");
            nodeTmp = nodeTmp.getNextNode();
        }
        prnq(" ="+j);
    }//printList---------------------------------------------

    public void push(int value) {//добавление в конец списка
        NodeInt nodeTmp = this.head;
        while (nodeTmp.getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode(new NodeInt(value));
    }//push--------------------------------------------------
    public void push(NodeInt nodeInt) {//добавление в конец списка
        NodeInt nodeTmp = this.head;
        while (nodeTmp.getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode(nodeInt);
        nodeTmp.getNextNode().setNextNode(null);
    }//push--------------------------------------------------


    public void push(int value, int index) {
        if (index==0) {
            pushHead(value);
            return;
        }
        NodeInt nodeTmp = this.head;
        for (int i = 0; i < index - 1 && nodeTmp.getNextNode() != null; i ++) {
            nodeTmp = nodeTmp.getNextNode();
        }
        NodeInt newNodeInt = new NodeInt(value, nodeTmp.getNextNode());
        nodeTmp.setNextNode(newNodeInt);
    }//push

    private void pushHead(int value) {//добавление в голову
        NodeInt nodeInt = new NodeInt(value, this.head);
        this.head = nodeInt;
    }//pushHead

    public void pushHead(NodeInt nodeInt){
        NodeInt nodeTmp = this.head;
        this.head = nodeInt;
        head.setNextNode(nodeTmp);
    }//pushHead

    public NodeInt pop(){//удаление элемента с конца
        NodeInt nodeTmp = this.head;
        while (nodeTmp.getNextNode().getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        NodeInt z =nodeTmp.getNextNode();
        nodeTmp.setNextNode(null);
        return z;
    }//pop---------------------------------------------------------
    public void pop(int index){
        if (index==0) {
           this.head=head.getNextNode();
            return;
        }
        NodeInt nodeTmp = this.head;
        for (int i = 0; i < index - 1 && nodeTmp.getNextNode().getNextNode() != null; i ++) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode(nodeTmp.getNextNode().getNextNode());
    }//pop-----------------------------------------------------------
    public NodeInt popHead(){
        NodeInt z = head;
        this.head=head.getNextNode();
        z.setNextNode(null);
        return z;
    }
//Найти среднее арифметическое значение элементов списка.
    public float average(){
        NodeInt nodeTmp = this.head;
        int j=0, z=0;
        while (nodeTmp != null) {
            j++;
            z+= nodeTmp.getValue();
            nodeTmp = nodeTmp.getNextNode();
        }
        return (float) z/j;
    }

}//class List
/*
Найти среднее арифметическое значение элементов списка.

Перенести в начало списка его последний элемент.

Перенести в конец списка его последний элемент.

Поменять местами первый и последний элементы списка.

Определить количество слов в списке, которые начинаются и заканчиваются на одну букву.

Проверить, что каждое следующее слово в списке начинается с последней буквы предыдущего.

Определить количество слов в списке, которые совпадают с первым (последним) словом списка.

Проверить, упорядочены ли элементы списка по алфавиту.

Определить, входит ли список L1 в L2.
Перевернуть список наоборот.
 */
class NodeGns<T> {//обобщения или generics
    private T value;
    private NodeGns nextNode;
    public NodeGns(T value, NodeGns nextNode) { this.value = value; this.nextNode = nextNode; }
    public NodeGns(T value) { this.value = value; this.nextNode = null; }
    public NodeGns getNextNode() { return nextNode; }
    public T  getValue() { return value; }
    public void setValue(T value) { this.value = value; }
    public void setNextNode(NodeGns nextNode) { this.nextNode = nextNode; }
}//class NodeGns----------------------------------------------------------------
class ListGns {
    private NodeGns head;

    ListGns() { this.head = null; }
    ListGns(NodeGns head) { this.head = head; }

    <T>ListGns(T ...vls){
        this.head=new NodeGns(vls[0]);
        if (vls.length>1){
            assert prnq("="+vls.length);
            NodeGns nodeTmp = this.head;
            for (int i = 1; i < vls.length; i++) {
                nodeTmp.setNextNode(new NodeGns(vls[i]));
                nodeTmp = nodeTmp.getNextNode();
            }//for
        }//if
    }//List---------------------------------------------------

    ListGns(NodeGns ...vls){
        this.head=new NodeGns(vls[0]);
        if (vls.length>1){
            assert prnq("="+vls.length);
            NodeGns nodeTmp = this.head;
            for (int i = 1; i < vls.length; i++) {
                nodeTmp.setNextNode(new NodeGns(vls[i]));
                nodeTmp = nodeTmp.getNextNode();
            }//for
        }//if
    }//List---------------------------------------------------
    public void printList() { printList(""); }
    public void printList(String str) {
        assert prnq("-----------"+str);
        NodeGns nodeTmp = this.head;
        int j=0;
        while (nodeTmp != null) {
            prnt((j++)+": "+nodeTmp.getValue()+"\t");
            nodeTmp = nodeTmp.getNextNode();
        }
        prnq(" ="+j);
    }//printList---------------------------------------------
    public int length() {
        NodeGns nodeTmp = this.head;
        int j=0;
        while (nodeTmp != null) {
            j++;
            nodeTmp = nodeTmp.getNextNode();
        }
        return j;
    }//length---------------------------------------------
    public NodeGns[] integr(){
        int q = this.length();
        NodeGns[] z= new NodeGns [q];
        NodeGns nodeTmp = this.head;
        int j=0;
        while (nodeTmp != null) {
            z[j++]=nodeTmp;
            nodeTmp = nodeTmp.getNextNode();
        }
        return z;
    }//integr------------------------------------------------
    public void reverse(){//Перевернуть список наоборот.
        NodeGns nodeTmp = this.head;
        NodeGns tmpA = null;
        NodeGns tmpB = null;
        int j=0;
        while (nodeTmp != null) {
            tmpA = nodeTmp;
            nodeTmp = nodeTmp.getNextNode();
            tmpA.setNextNode(tmpB);
            tmpB=tmpA;
        }
        head=tmpA;
    }//reverse

    public <T> void push(T value) {//добавление в конец списка
        NodeGns nodeTmp = this.head;
        while (nodeTmp.getNextNode() != null)
            nodeTmp = nodeTmp.getNextNode();
        nodeTmp.setNextNode(new NodeGns(value));
    }//push--------------------------------------------------
    public void push(NodeGns node) {//добавление в конец списка
        NodeGns nodeTmp = this.head;
        while (nodeTmp.getNextNode() != null)
            nodeTmp = nodeTmp.getNextNode();
        nodeTmp.setNextNode(node);
        nodeTmp.getNextNode().setNextNode(null);
    }//push--------------------------------------------------
    public <T> void push(T value, int index) {
        if (index==0) {
            pushHead(value);
            return;
        }
        NodeGns nodeTmp = this.head;
        for (int i = 0; i < index - 1 && nodeTmp.getNextNode() != null; i ++)
            nodeTmp = nodeTmp.getNextNode();
        NodeGns newNode = new NodeGns(value, nodeTmp.getNextNode());
        nodeTmp.setNextNode(newNode);
    }//push--------------------------------------------------
    public <T> void pushHead(T value) {//добавление в голову
        NodeGns node = new NodeGns(value, this.head);
        this.head = node;
    }//pushHead----------------------------------------------
    public void pushHead(NodeGns node){
        NodeGns nodeTmp = this.head;
        this.head = node;
        head.setNextNode(nodeTmp);
    }//pushHead----------------------------------------------
    public NodeGns pop(){//удаление элемента с конца
        NodeGns nodeTmp = this.head;
        while (nodeTmp.getNextNode().getNextNode() != null)
            nodeTmp = nodeTmp.getNextNode();
        NodeGns z =nodeTmp.getNextNode();
        nodeTmp.setNextNode(null);
        return z;
    }//pop---------------------------------------------------------
    public void pop(int index){
        if (index==0) {
            this.head=head.getNextNode();
            return;
        }
        NodeGns nodeTmp = this.head;
        for (int i = 0; i < index - 1 && nodeTmp.getNextNode().getNextNode() != null; i ++)
            nodeTmp = nodeTmp.getNextNode();
        nodeTmp.setNextNode(nodeTmp.getNextNode().getNextNode());
    }//pop-----------------------------------------------------------
    public NodeGns popHead(){
        NodeGns z = head;
        this.head=head.getNextNode();
        z.setNextNode(null);
        return z;
    }//popHead-----------------------------------------------------
}//class ListGns
