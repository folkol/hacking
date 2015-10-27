import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class JsonSearch {
    static String json = "[\n" +
            "  {\n" +
            "    \"Name\": \"A+\",\n" +
            "    \"Type\": \"Array\",\n" +
            "    \"Designed by\": \"Arthur Whitney\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Ada\",\n" +
            "    \"Type\": \"Compiled, Imperative, Procedural, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Tucker Taft, Jean Ichbiah\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"C\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Imperative, Procedural\",\n" +
            "    \"Designed by\": \"Dennis Ritchie\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"C#\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Iterative, Object-oriented class-based, Reflective, Procedural\",\n" +
            "    \"Designed by\": \"Microsoft\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Java\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Imperative, Object-oriented class-based, Procedural, Reflective\",\n" +
            "    \"Designed by\": \"James Gosling, Sun Microsystems\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"JavaScript\",\n" +
            "    \"Type\": \"Curly-bracket, Interpreted, Reflective, Procedural, Scripting, Interactive mode\",\n" +
            "    \"Designed by\": \"Brendan Eich\"\n" +
            "  }" +
            "]";

    public static void main(String[] args) {
        List<JsonObject> collect = Json.createReader(new StringReader(json))
                .readArray()
                .stream()
                .filter(x -> x instanceof JsonObject)
                .map(x -> (JsonObject) x)
                .filter(x -> Objects.equals("Java", x.getString("Name")))
                .collect(toList());

        System.out.println(collect);
    }
}
