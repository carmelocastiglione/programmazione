public class App {
    public static void main(String[] args) throws Exception {
        // Operatori di assegnazione
        int a = 5; // Assegna 5 a a prima di usare gli operatori di assegnazione
        int b = 3; // Assegna 3 a b prima di usare gli operatori di assegnazione
        a += b; // a = a + b
        System.out.println(a); // 8
        a -= b; // a = a - b
        System.out.println(a); // 5
        a *= b; // a = a * b
        System.out.println(a); // 15
        a /= b; // a = a / b
        System.out.println(a); // 5
        a %= b; // a = a % b
        System.out.println(a); // 2
    }
}
