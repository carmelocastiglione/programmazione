public class App {
    public static void main(String[] args) throws Exception {
        int x = 10;
        int y = 3;

        // Operazioni aritmetiche di base con x e y
        System.out.println(x + y); // 13
        System.out.println(x - y); // 7
        System.out.println(x * y); // 30
        System.out.println(x / y); // 3
        System.out.println(x % y); // 1

        // Operazioni di incremento e decremento con z
        int z = 5;
        ++z;
        System.out.println(z); // 6
        z++;
        System.out.println(z); // 7
        --z;
        System.out.println(z); // 6
        z--;
        System.out.println(z); // 5

        int a = 2, b = 3;
        System.out.println(a++ + b); // 5
        System.out.println(a); // 3
        System.out.println(++a + b); // 7
        System.out.println(a); // 4
    }
}
