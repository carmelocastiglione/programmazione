public class App {
    public static void main(String[] args) throws Exception {
        // Operatori logici
        boolean isLoggedIn = true;
        boolean isAdmin = false;

        System.out.println("Is logged in: " + isLoggedIn);
        System.out.println("Is admin: " + isAdmin);
        System.out.println("Regular user: " + (isLoggedIn && !isAdmin));
        System.out.println("Has access: " + (isLoggedIn || isAdmin));
        System.out.println("Not logged in: " + (!isLoggedIn));
    }
}
