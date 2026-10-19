public class Veicolo {
    private String targa;
    private String modello;
    private double tariffaOraria;

    public Veicolo(String targa, String modello, double tariffaOraria) {
        this.targa = targa;
        this.modello = modello;
        setTariffaOraria(tariffaOraria);
    }

    public Veicolo(String targa, String modello) {
        this(targa, modello, 2.0);
    }

    public String getTarga() { return targa; }
    public String getModello() { return modello; }
    public double getTariffaOraria() { return tariffaOraria; }

    public void setTariffaOraria(double tariffaOraria) {
        if (tariffaOraria > 0) this.tariffaOraria = tariffaOraria;
    }

    @Override
    public String toString() {
        return "[" + targa + "] " + modello + " | tariffa oraria: " + tariffaOraria;
    }
}
