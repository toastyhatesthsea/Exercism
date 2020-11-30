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



}


class TesterMeows
{
    public static void main(String[] asdasdasdssadasd)
    {
        
    }
}