import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ComplexCalculation implements Callable<Integer> {

	private Integer orderNumber;
	
    public ComplexCalculation(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
    public Integer call() throws Exception {
		System.out.println("Complex calculation " + orderNumber + " started...");
        try {
        	 TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);
		} catch (InterruptedException e) {}
        
        Integer result = new Random().nextInt(10 + 1);
        System.out.println("Calculation " + orderNumber + " completed, result: " +result);
        
        return result;
    }
}
