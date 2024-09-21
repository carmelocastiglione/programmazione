
public class Calcolatrice {

    public int addizione(int a, int b) {
        int somma = a + b;
        return somma;
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public void raddoppia(int[] v) {
        for (int i = 0; i < v.length; i++) {
            v[i] = v[i] * 2;
        }
    }

}
