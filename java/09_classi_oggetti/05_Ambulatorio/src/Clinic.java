public class Clinic {

    private int numeroPazienti;
    private int numeroDottori;
    private Patient[] listaPatients = new Patient[1024];
    private Doctor[] listaDoctors = new Doctor[128];

    public Clinic() {
        numeroPazienti = 0;
    }

    public void addPatient(Patient patient) {
        if (numeroPazienti < 1024) {
            listaPatients[numeroPazienti] = patient;
            numeroPazienti++;
        }
    }

    public void addDoctor(Doctor dottore) {
        if (numeroDottori < 128) {
            listaDoctors[numeroDottori] = dottore;
            numeroDottori++;
        }
    }

    public String getPatient(String codiceFiscale) throws Exception {
        for (int i = 0; i < numeroPazienti; i++) {
            if (listaPatients[i].getCodiceFiscale().equals(codiceFiscale)) {
                return listaPatients[i].getCognome() + " " + listaPatients[i].getNome() + " (" + listaPatients[i].getCodiceFiscale() + ")";
             }
        }
        throw new Exception("Paziente inesistente");
    }

    public String getDoctor(int badge) throws Exception {
        for (int i = 0; i < numeroDottori; i++) {
            if (listaDoctors[i].getBadge() == badge) {
                return listaDoctors[i].getCognome() + " " + listaDoctors[i].getNome() + " (" + listaDoctors[i].getCodiceFiscale() + ") [" + listaDoctors[i].getBadge() + "]: " + listaDoctors[i].getSpecializzazione();
             }
        }
        throw new Exception("Dottore inesistente");
    }

    public void assignPatientToDoctor(String codiceFiscale, int badge) throws Exception {
        for (int i = 0; i < numeroPazienti; i++) {
            if (listaPatients[i].getCodiceFiscale().equals(codiceFiscale)) {
                for (int j = 0; j < numeroDottori; j++) {
                    if (listaDoctors[j].getBadge() == badge) {
                        listaPatients[i].setBadgeMedico(badge);
                        return;
                     }
                }
                throw new Exception("Dottore inesistente");
             }
        }
        throw new Exception("Paziente inesistente");
    }

    public int getAssignedDoctor(String codiceFiscale) throws Exception {
        for (int i = 0; i < numeroPazienti; i++) {
            if (listaPatients[i].getCodiceFiscale().equals(codiceFiscale)) {
                if (listaPatients[i].getMedico() != 0) {
                    return listaPatients[i].getMedico();
                } else {
                    throw new Exception("Dottore inesistente");
                }
             }
        }
        throw new Exception("Paziente inesistente");
    }

    public String[] getAssignedPatents(int badge) throws Exception {
        int k = 0;
        String[] lista = new String[1024];
        for (int i = 0; i < numeroDottori; i++) {
            if (listaDoctors[i].getBadge() == badge) {
                for (int j = 0; j < numeroPazienti; j++) {
                    if (listaPatients[j].getMedico() == badge) {
                        lista[k] = listaPatients[j].getCodiceFiscale();
                        k++;
                    }
                }
                return lista;
             }
        }
        throw new Exception("Dottore inesistente");
    }
    
}
