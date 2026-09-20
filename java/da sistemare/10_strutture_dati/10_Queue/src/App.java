import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Integer num1 = queue.poll();
        System.out.println(num1);
        System.out.println("-------");
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        System.out.println("-------");
        Integer num2 = queue.poll();
        System.out.println(num2);
        System.out.println("-------");
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }
}
