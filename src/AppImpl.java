
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DecimalFormat;
import java.util.Random;

public class AppImpl extends UnicastRemoteObject implements AppInterface{
    protected AppImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
    public double facebookStock() throws RemoteException{
    	
    	//return (Math.random() * 206 + 123);
    	return (new Random().nextInt(83+1) + 123);
    }
    public double appleStock() throws RemoteException{
    	//return (Math.random() * 268 + 144);
    	return (new Random().nextInt(124+1) + 144);

    }
    public double sonyStock() throws RemoteException{
    	//return (Math.random() * 63 + 42);
    	return (new Random().nextInt(21+1) + 42);

    }
	public double microsoftStock() throws RemoteException{
    	//return (Math.random() * 152 + 95);
    	return (new Random().nextInt(57+1) + 95);

    }
    public double netflixStock() throws RemoteException{
    	//return (Math.random() * 383 + 234);
    	return (new Random().nextInt(149+1) + 234);

    }
    public double generateStock(int a,int b) throws RemoteException{
        //return (Math.random() * a + b);
    	return (new Random().nextInt(a+1) + b);

    }
	public double roundDecimal(double number) throws RemoteException {
		 DecimalFormat roundFormat = new DecimalFormat("0.0000");
	        return (Double.parseDouble(roundFormat.format(number)));
	}
	public double roundDecimal2(double number) throws RemoteException {
		 DecimalFormat roundFormat = new DecimalFormat("0.00");
	        return (Double.parseDouble(roundFormat.format(number)));
	}
	public void writeToFile(String a, String b) throws RemoteException {
		try {
            Files.write(Paths.get("src/history/" + a),  b.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
        	System.err.println("Remote exception: " + e.getMessage());
			e.printStackTrace();
        }
	}
	
	public String rateOfChange(String company) {
		String result = "";
		try {
		  AppInterface f = (AppInterface)Naming.lookup("//localhost/App");
		  

		  BufferedReader in = new BufferedReader(new FileReader(company));
          String[] last2 = new String[2];
          int count=0;
          while(in.ready()){
              last2[count++%2]=in.readLine();
          }
          double first = Double.parseDouble(last2[(0+count)%2]);
          double second = Double.parseDouble(last2[(1+count)%2]);
      	  result = String.valueOf(f.roundDecimal2((100*(second-first))/first));
      	  
      	  in.close();
		} catch(Exception e) {
			System.err.println("Remote exception: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
		
		
	}
	

}
