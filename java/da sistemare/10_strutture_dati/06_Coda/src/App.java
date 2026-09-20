public class App {
    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        queue.enqueue(1);
        System.out.println(queue.size() + " " + queue.head());
        queue.enqueue(2);
        System.out.println(queue.size() + " " + queue.head());
        queue.enqueue(3);
        System.out.println(queue.size() + " " + queue.head());
        queue.dequeue();
        System.out.println(queue.size() + " " + queue.head());
        queue.dequeue();
        System.out.println(queue.size() + " " + queue.head());
        queue.dequeue();
        System.out.println(queue.size() + " " + queue.head());
    }
}
