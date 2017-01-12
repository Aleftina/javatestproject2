package ua.javatests;

/**
<<<<<<< HEAD
=======

>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
 */
public class Primes {

    public static boolean isPrime(int i){
        for (int j = 2; j<=i; j++){
            if (i%j == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeFast(int i){
        int m = (int) Math.sqrt(i);
        for (int j = 2; j<=m; j++){
            if (i%j == 0){
                return false;
            }
        }
        return true;
    }


    public static boolean isPrimeWhile(int i){
        int j = 2;
        while (j<i){
            if (i%j == 0){
                return false;
            }
            j++;
        }
        return true;
// another variant of realization
//        while ((j<i) && (i%j != 0)){
//            j++;
//        }
//        return i%j == 0;
    }

    public static boolean isPrimeWhile(long i) {
        long j = 2;
        while (j<i){
            if (i%j == 0){
                return false;
            }
            j++;
        }
        return true;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
