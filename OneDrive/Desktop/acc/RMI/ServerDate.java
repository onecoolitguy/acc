import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.util.Date;

public class ServerDate extends UnicastRemoteObject implements InterDate {

    // constructor must declare RemoteException
    protected ServerDate() throws RemoteException {
        super();
    }

    @Override
    public String display() throws RemoteException {
        return new Date().toString();
    }

    public static void main(String[] args) {
        try {
            // start an RMI registry on port 1099 (if not already running)
            LocateRegistry.createRegistry(1099);

            // create and bind the remote object
            ServerDate obj = new ServerDate();
            Naming.rebind("DS", obj); // binds to the default registry on localhost:1099

            System.out.println("Server bound as 'DS' and ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}
