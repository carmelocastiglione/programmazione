public class App {
    public static void main(String[] args) throws Exception {
        Clinic clinic = new Clinic();

        Patient p1 = new Patient("Mario", "Rossi", "aaa123");
        clinic.addPatient(p1);
        System.out.println(clinic.getPatient("aaa123"));
        //System.out.println(clinic.getPatient("bbb123"));

        Patient p2 = new Patient("Luca", "Bianchi", "bbb123");
        clinic.addPatient(p2);
        System.out.println(clinic.getPatient("bbb123"));

        Doctor d1 = new Doctor("Gianni", "Morandi", "ccc123", 1, "dentista");
        clinic.addDoctor(d1);
        System.out.println(clinic.getDoctor(1));

        clinic.assignPatientToDoctor("aaa123", 1);
        //clinic.assignPatientToDoctor("aaa123", 2);
        System.out.println(clinic.getAssignedDoctor("aaa123"));

        clinic.assignPatientToDoctor("bbb123", 1);

        String[] lista = new String[1024];
        lista = clinic.getAssignedPatents(1);
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                System.out.println(lista[i]);
            }
        }
    }
}
