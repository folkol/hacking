
public class LastIndexOf {

    public static void main(String[] args) {
        String fileName = "scripts/css/an.main.master.css";
        int cut = fileName.lastIndexOf("/");
        System.out.println(fileName.substring(cut));
    }

}
