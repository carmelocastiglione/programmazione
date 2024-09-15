public class _01_Orario {
    public static void main(String[] args) {
        int orario = 41345;
        int ore, minuti, secondi;

        ore = orario / 3600;
        minuti = (orario % 3600) / 60;
        secondi = orario % 60;

        System.out.println("Orario: " + ore + ":" + minuti + ":" + secondi);
    }
}