import java.rmi.Remote;
import java.rmi.RemoteException;


public interface AppInterface extends Remote{
    public double facebookStock() throws RemoteException;
    public double appleStock() throws RemoteException;
    public double sonyStock() throws RemoteException;
    public double microsoftStock() throws RemoteException;
    public double netflixStock() throws RemoteException;
    public double generateStock(int a,int b) throws RemoteException;
    public double roundDecimal(double b) throws RemoteException;
    public double roundDecimal2(double b) throws RemoteException;
    public void writeToFile(String a, String b) throws RemoteException;
    public String rateOfChange(String company) throws RemoteException;
}
