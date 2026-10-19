public class App {
    public static void main(String[] args) throws Exception {
        Studente studente = new Studente("Mario", "Rossi", "Liceo Classico");
        StudenteDiplomato studenteDiplomato = new StudenteDiplomato("Luigi", "Verdi", "Liceo Scientifico", 90);
        System.out.println(studente);
        System.out.println(studenteDiplomato);
    }
}
