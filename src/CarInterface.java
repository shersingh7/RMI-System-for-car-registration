

import java.rmi.Remote;

public interface CarInterface extends Remote {
    String plate(Car car) throws java.rmi.RemoteException;
}
