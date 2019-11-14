package binarysearch;

class PowerOfFunction {

    public int pow(int x, int n, int d) {
        int ans = 1;

        if(x == 0){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        x = (x % d);
        
        while(n > 0) {
            if((n & 1) == 1) {
                ans = modulo_Euclidean((x * ans), d);
            }
            
            n =  n >> 1;  // n = n / 2
            x = modulo_Euclidean((x * x), d);
        }
        
        // System.out.println(ans);
        
        return modulo_Euclidean(ans, d);
    }

    int power(int x, int y, int p) 
    { 
        // Initialize result 
        long res = 1;      
         
        // Update x if it is more   
        // than or equal to p 
        x = x % p;  
      
        while (y > 0) 
        { 
            // If y is odd, multiply x 
            // with result 
            if((y & 1)==1) 

                res = ((res % p) * (x % p)) % p; 
      
            // y must be even now 
            // y = y / 2 
            y = y >> 1;  
            x = ((x % p) * (x % p)) % p;   
        } 
        return modulo_Euclidean(res, p); 
    } 
    
    static int modulo_Euclidean(long a, int b) {
        int m = (int) a % b;
        if(m < 0) {
            // m += (b < 0) ? -b : b; // avoid this form: it is UB when b == INT_MIN
            m = (b < 0) ? m - b : m + b;
        }
        return m;
    }


    public int pow2(int x, int n, int d) {
	    long rem = 1;
        int check = 0;
        
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        
        if(x < 0){
            x = Math.abs(x);
            if(n%2 != 0){
                check = 1;
            }
        }
        
        long temp = x%d;
        while(n != 0){
            if(n%2 != 0){
                rem = (rem*temp)%d;
            }
            
            temp = temp*temp;
            temp = temp%d;
        
            n = n/2;
            if(rem > d){
                rem = rem%d;
            }
        }
        
        if(check == 1){
            return d-(int)rem;
        }
    
        return (int)rem;
	}
    
    public static void main(String[] args) {
        System.out.println(" " + new PowerOfFunction().pow2(71045970, 41535484, 64735492));
        System.out.println("My Implementation: " + new PowerOfFunction().power(71045970, 41535484, 64735492));
    }
}

// 20805472