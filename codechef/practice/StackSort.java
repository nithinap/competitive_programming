package practice;

import java.util.Scanner;
import java.util.Stack;
class SortedStack{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Stack<Integer> s=new Stack<>();
            int n=sc.nextInt();
            while(n-->0)
                s.push(sc.nextInt());
            StackSort g=new StackSort();
            Stack<Integer> a=g.sort(s);
            while(!a.empty()){
                System.out.print(a.peek()+" ");
                a.pop();
            }
            System.out.println();
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
public class StackSort{
    public Stack<Integer> sort(Stack<Integer> s)
    {
        Stack<Integer> s1 = new Stack<>();
        while(!s.isEmpty()) {
            int top = s.pop();
            while(!s1.isEmpty() && s1.peek() > top) {
                int num = s1.pop();
                s.push(num);
            }
            s1.push(top);
        }
        return s1;
    }
}