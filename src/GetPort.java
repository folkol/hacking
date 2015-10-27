import java.net.*;

public class GetPort {
    public static void main(String[] args) throws Exception {
        {
            URI uri = new URI("couchbase://localhost:8080/resource?apa");
            System.out.println(uri.getHost());
            System.out.println(uri.getPort());
        }
        {
            URI uri = new URI("couchbase://localhost/resource?apa");
            System.out.println(uri.getHost());
            System.out.println(uri.getPort());
        }
    }

    private static void giefUrl() {
        try {
            String fromSettings = "http://localhost:8080/apa?nisse";

            URI couchbaseURI = new URI(fromSettings);
            int port = 8091;
            if (couchbaseURI.getPort() != -1) {
                port = couchbaseURI.getPort();
            }
            URL couchbaseURL = new URL("http", couchbaseURI.getHost(), port, "");

//            configuration.addChild(node("host", couchbaseURL.toString()));
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
