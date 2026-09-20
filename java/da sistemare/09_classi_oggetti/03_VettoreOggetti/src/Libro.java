
public class Libro {
    private String titolo;
    private String autore;

	public Libro(String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}
}
