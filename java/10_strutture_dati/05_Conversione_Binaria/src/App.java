public class App {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        int numeroDecimale = 87;
        int resto;
        int numero = numeroDecimale;
        while (numero != 0) {
            resto = numero % 2;
            numero = numero / 2;
            stack.push(resto);
        }
        System.out.print(numeroDecimale + " = ");
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int r = (int) stack.pop();
            System.out.print(r);
        }
    }
}
