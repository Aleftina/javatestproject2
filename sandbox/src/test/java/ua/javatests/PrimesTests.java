package ua.javatests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by olga on 02.01.17.
 */
public class PrimesTests {

    @Test
    public void testMaxPrime(){
        Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE));
    }

    @Test
    public void testNotPrime(){
        Assert.assertFalse(Primes.isPrimeWhile(Integer.MAX_VALUE-2));
    }

    @Test
    public void testPrimeFast(){
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test(enabled = false)
    public void testLongPrime(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrimeWhile(n));
    }
}