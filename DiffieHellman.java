import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman
{

    public DiffieHellman()
    {

    }


    public BigInteger privateKey(BigInteger aBigInt)
    {
        Random aRan = new Random();

        BigInteger result = new BigInteger(aBigInt.bitLength(), aRan);

        while (result.compareTo(aBigInt) >= 0)
        {
            result = new BigInteger(aBigInt.bitLength(), aRan);
        }

        return result;
    }


    public BigInteger secret(BigInteger aPrime, BigInteger aPublic, BigInteger aSecret)
    {
        return null;
    }

    public BigInteger publicKey(BigInteger primeA, BigInteger primeB, BigInteger privateKey)
    {
        return null;
    }

}


class TesterMeows
{
    public static void main(String[] asdasdasdssadasd)
    {
        DiffieHellman diffie = new DiffieHellman();

        BigInteger aBigInt = BigInteger.valueOf(45);

        diffie.privateKey(aBigInt);
    }
}