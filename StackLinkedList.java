import java.util.Scanner;
class Node1{
    int data;
    Node1 next;
    Node1(int data){
        this.data=data;
        this.next=null;
    }
}
class StackSll{
    Node1 top=null;
    void push(int value){
        Node1 newNode=new Node1(value);
        newNode.next=top;
        top=newNode;
        System.out.println(value + "inserted");
    }
    void pop(){
        if(top==null){
            System.out.println("Stack underFlow");
        }
        else{
            System.out.println(top.data + "deleted");
        }

    }
    void top(){
        if(top==null){
            System.out.println("Stack is empty");
        }
        else{
             System.out.println("Top number:" + top.data);
        }
    }
    void isEmpty(){
        if(top==null){
             System.out.println("Stack is Empty");
        }
        else{
             System.out.println("Stack is not empty");
        }
    }
    void Display(){
        if(top==null){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack elements:");
            Node1 temp=top;
            while(temp!=null){
                 System.out.println(temp.data);
                 temp=temp.next;
            }
        }
    }
}
public class StackLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackSll s = new StackSll();

        while (true) {
            System.out.println("\n1.Push");
            System.out.println("2.Pop");
            System.out.println("3.top");
            System.out.println("4.Display");
            System.out.println("5.isEmpty");
            System.out.println("6.Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    s.push(val);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.top();
                    break;

                case 4:
                    s.Display();
                    break;

                case 5:
                    s.isEmpty();
                    break;

                case 6:
                    System.out.println("Program Ended");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}