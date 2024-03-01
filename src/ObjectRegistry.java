import java.util.HashMap;

public class ObjectRegistry {
    private static HashMap<String, Object> objects = new HashMap<>();

    public static void register(String name, Object object) {
        objects.put(name, object);
    }

    public static Object get(String name) {
        return objects.get(name);
    }
}
