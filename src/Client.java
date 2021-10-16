

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws RemoteException {
        try {
            CarInterface cInterface = (CarInterface) Naming.lookup("rmi://localhost:8080/Server");

            BufferedReader bReader = new BufferedReader( new InputStreamReader(System.in));

            Car[] cars = new Car[4];
            cars[0] = new Car("Audi R8" , "Glossy Black" , 900);
            cars[1] = new Car("Mercedes EQS" , "Royal Black" , 1500);
            cars[2] = new Car("Tesla Model S Plaid + " , "Metallic Black" , 2000);
            cars[3] = new Car("Hummer H3" , "Military Camo" , 500);

            for (int i = 0; i < cars.length; i++){
                System.out.println("\nWant to register: " + cars[i]);
                System.out.print("Y/y to register, N/n to quit, or any other to skip: ");

                String input = bReader.readLine();

                if(input.equals("y") || input.equals("Y") ){
                    System.out.println("Registering Now!!!");

                    try{
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    cars[i].register(cInterface.plate(cars[i]));

                    System.out.println("Registered Successfully!!!\n" + cars[i]);
                } else if(input.equals("N") || input.equals("n") ){
                    System.out.println("Closing Connection!!!");
                    System.exit(0);
                } else {
                    System.out.println("Skipped registration!!!");
                    continue;
                }
            }

            System.out.println("\nAttention: No more cars!!!");
            System.out.println("Closing Connection!!!");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
