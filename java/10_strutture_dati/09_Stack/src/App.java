import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (Object object : stack) {
            System.out.println(object);
        }
        System.out.println("-----");

        Integer num = (Integer) stack.pop();
        System.out.println(num);
        System.out.println("-----");

        for (Object object : stack) {
            System.out.println(object);
        }
        System.out.println("-----");

        Integer next = (Integer)stack.peek();
        System.out.println(next);
    }
}
