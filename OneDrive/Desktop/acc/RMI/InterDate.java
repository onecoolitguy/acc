import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterDate extends Remote {
    String display() throws RemoteException;
}
