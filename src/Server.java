

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            CarInterface carInterface = new Implementation();
            LocateRegistry.createRegistry(8080);
            Naming.rebind("rmi://localhost:8080/Server", carInterface);
            System.out.println("Connecting to server for registering cars");
            InetAddress address = InetAddress.getByName(null);
            System.out.println("Connected: " + address);
            System.out.println("Warning: Server will disconnect if there is no more car.");

        } catch (RemoteException | MalformedURLException | UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
