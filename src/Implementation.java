


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementation extends UnicastRemoteObject implements CarInterface {
    protected Implementation() throws RemoteException {
    }

    @Override
    public String plate(Car car) throws RemoteException {
        return "" + car.hashCode(); //Random number
    }
}
