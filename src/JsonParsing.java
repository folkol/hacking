import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class JsonParsing {

    public static void main(String[] args) {
        String json = "{\"name\": \"Matte\"}";
        JSONObject obj = (JSONObject) JSONValue.parse(json);
        System.out.println(obj.get("name"));
    }

}
