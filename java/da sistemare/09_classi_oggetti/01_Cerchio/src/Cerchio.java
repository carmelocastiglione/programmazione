
public class Cerchio {

    private double raggio;

    public void setRaggio(double r) {
        raggio = r;
    }

    public double calcolaArea() {
        double area = raggio * raggio * Math.PI;
        return area;
    }

}
