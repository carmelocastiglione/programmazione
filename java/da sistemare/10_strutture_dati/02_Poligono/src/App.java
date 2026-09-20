public class App {
    public static void main(String[] args) throws Exception {
        Poligono poligono = new Poligono();

        Punto p1 = new Punto(0,2);    
        Punto p2 = new Punto(2,5);    
        Punto p3 = new Punto(4,4);    
        Punto p4 = new Punto(5,1);    
        Punto p5 = new Punto(2,-1);    
        Poligono poli = new Poligono();    
        poli.aggiungi(p1);    
        poli.aggiungi(p2);    
        poli.aggiungi(p3);    
        poli.aggiungi(p4);    
        poli.aggiungi(p5);    
        poli.stampa();    
        poli.togli(3);    
        poli.stampa();
    }
}
