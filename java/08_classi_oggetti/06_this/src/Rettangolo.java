/**
 * Rettangolo
 */
public class Rettangolo {
    int base;
    int altezza;

    int area() {
        return base * altezza;
    }

    int perimetro() {
        return 2 * (base + altezza);
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }
}
