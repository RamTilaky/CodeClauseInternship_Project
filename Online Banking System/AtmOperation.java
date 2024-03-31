package mypackage;
import java.util.HashMap;
import java.util.Map;
public class AtmOperation  implements AtmOperationinter{
    ATM atm=new ATM();
    Map<Double,String> ministmt=new HashMap<Double,String>();
 //@override
    public void viewBalance() {
        System.out.println("Available Balance is : "+atm.getBalance());

    }


    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount%100==0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministmt.put(withdrawAmount, " Amount Withdrawn");
                if(withdrawAmount==1){
                	withdrawAmount++;
                	ministmt.put(withdrawAmount, " Amount Withdrawn");
                }
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please enter the amount in multiples of 100");
        }

    }


    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount," Amount Deposited");
        if(depositAmount==1){
        	depositAmount++;
        	ministmt.put(depositAmount," Amount Deposited");
        }
        System.out.println(depositAmount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();

    }


    public void viewMiniStatement() {
    	if(ministmt.isEmpty()){
    		System.out.println("===No Transactions Found===");
    	}
    	else{
        for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }
        viewBalance();
    	}


    }
}
