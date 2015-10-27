public class StringFormat {
    public static void main(String[] args) {
        String name = "Bertin Jansson", occupation = "Lollare";

        String message = String.format("Name: %s, Occupation: %s", name, occupation);

        System.out.println(message);
    }
}
