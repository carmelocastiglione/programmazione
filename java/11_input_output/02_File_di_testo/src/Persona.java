public class Persona {
    private String nome;
    private Integer eta;
    private Voto[] voti;
    private int numeroVoti;

    public Persona(String nome, Integer eta) {
        this.nome = nome;
        this.eta = eta;
        this.voti = new Voto[5];
        this.numeroVoti = 0;
    }

    @Override
    public String toString() {
        String s = "Persona [nome=" + nome + ", eta=" + eta + "]";
        for (int i = 0; i < numeroVoti; i++) {
            s = s + "\n" + voti[i];
        }
        return s;
    }

    public void aggiungiVoto(String t, int v) {
        if (numeroVoti < 5) {
            voti[numeroVoti] = new Voto(t, v);
            numeroVoti++;
        }
    }

    public String writeToFile() {
        String s = nome + ";" + eta + ";";
        for (int i = 0; i < numeroVoti; i++) {
            s = s + voti[i].writeToFile();
        }
        return s;
    }
}
