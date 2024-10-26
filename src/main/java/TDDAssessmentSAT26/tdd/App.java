package TDDAssessmentSAT26.tdd;

/**
 * Hello world!
 */
public final class App {
	
	public App() {
		// TODO Auto-generated constructor stub
	}
    public Integer Add(String numbers) {
    	int sum = 0;
    	StringBuilder negativeNumbers = new StringBuilder();
    	if(numbers.isEmpty()) {
    		return sum;
    	}else if(numbers.equals("1")) {
    		return 1;
    	}else {
    		String deliminator = "[,\\n]";
    		if (numbers.startsWith("//")) {
    	        int delimiterEndIndex = numbers.indexOf('\n');
    	        if (delimiterEndIndex != -1) {
    	            deliminator = "[" + numbers.substring(2, delimiterEndIndex) + "]";
    	            numbers = numbers.substring(delimiterEndIndex + 1); 
    	        }
    	    }
    		String[] intNumber = numbers.split(deliminator);
    		
    		for(String num: intNumber) {
    			int n = Integer.parseInt(num);
    			if(n< 0) {
    				negativeNumbers.append(n).append(" ");
    			}
    			sum += n;    		
    		}
    	}
    	
    	if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers.toString().trim());
        }
    	
    	
		return sum;
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App app = new App();
       
        System.out.println( app.Add("//;\\\\n1;2"));
    }
}
