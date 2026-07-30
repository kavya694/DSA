import java.util.Scanner;
class Stack1{
    int capacity=5;
    int[] stack=new int[capacity];
    int top=-1;
    void push(int value){
        if(top==capacity-1){
            System.out.println("Stack overflow");
        }
        else{
            top++;
            stack[top]=value;
            System.out.println(value + "inserted");
        }
    }
    void pop(){
        if(top==-1){
            System.out.println("Stack underflow");
        }
        else{
            System.out.println(stack[top] + "deleted");
            top--;
        }
    }
    void top(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println( "Top element :" + stack[top]);
        }
    
    }
    void isEmpty(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack is  not empty");
        }
    }
    void display(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack elements:");
            for(int i=top;i>=0;i--){
                System.out.println(stack[i]);
            }
        }
    }
}
public class StackUsingArray {
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