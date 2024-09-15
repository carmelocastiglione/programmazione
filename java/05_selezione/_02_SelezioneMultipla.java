public class _02_SelezioneMultipla {
    public static void main(String[] args) {
        int numero = (int) (Math.random() * 10);
        System.out.print("E' stato estratto ");
        switch (numero) {
            case 1:
                System.out.println("il numero 1");
                break;
            case 0:
            case 2:
            case 4:
            case 6:
            case 8:
                System.out.println("un numero pari");
                break;
            default:
                System.out.println("un numero dispari diverso da 1");
                break;
        }
    }
}
