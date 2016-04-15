import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchApplication {

    private static final int NUMBER_OF_OPERATIONS = 10;
    
    private static ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
    
    private static Integer max = 0;

    public static void main(String[] args) throws Exception {

        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= NUMBER_OF_OPERATIONS; i++) {
            results.add(executorService.submit(new ComplexCalculation(i)));
        }
        //for every Future in the list, future.get() will wait to finish the related task
        for (Future<Integer> future: results) {
        	if(future.get() > max){
        		max = future.get();
        	}
		}
        System.out.println("All complex calculation finished.");
        System.out.println("Max result is: " +max);

        executorService.shutdown();
    }
}
