import java.rmi.Naming;

public class ClientDate {
    public static void main(String[] args) {
        try {
            // If server is on same machine use localhost.
            // If server is remote use "//serverHost/DS"
            InterDate h1 = (InterDate) Naming.lookup("//localhost/DS");
            String s1 = h1.display();
            System.out.println("Date from server: " + s1);
        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}
