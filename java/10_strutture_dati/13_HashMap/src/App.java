import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        /* Key=Value */
        map.put("Juventus", 36);
        map.put("Torino", 7);
        map.put("Milan", 19);
        map.put("Inter", 20);
        map.put("Roma", 3);
        map.put("Lazio", 2);
        map.put("Real Madrid", 36);
        System.out.println(map);

        System.out.println(map.get("Inter"));

        map.remove("Real Madrid");
        System.out.println(map);

        System.out.println(map.size());

        for (String key : map.keySet()) {
            System.out.println(key);
        }
        for (Integer value : map.values()) {
            System.out.println(value);
        }
        for (String key : map.keySet()) {
            System.out.println("key = " + key + " , value = " + map.get(key));
        }

        map.clear();
        System.out.println(map);
    }
}
