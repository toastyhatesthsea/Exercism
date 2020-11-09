/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
//TODO Need to process number when it is without spaces

import java.util.Scanner;

public class PhoneNumber
{
    private String anPhoneNumber;

    public PhoneNumber(String aPhoneNumber)
    {

        aPhoneNumber = aPhoneNumber.replaceAll("[()-.+ ]", "");
        //aPhoneNumber = aPhoneNumber.strip();
        this.anPhoneNumber = aPhoneNumber;

        if (this.anPhoneNumber.length() > 11)
        {
            throw new IllegalArgumentException("more than 11 digits");
        } else if (this.anPhoneNumber.length() < 10)
        {
            throw new IllegalArgumentException("incorrect number of digits");
        }

        if (this.anPhoneNumber.length() == 11) //Get rid of potential leading 1
        {
            String firstDigit = this.anPhoneNumber.substring(0, 1);
            if (!firstDigit.equals("1"))
            {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
            this.anPhoneNumber = aPhoneNumber.substring(1); //Removes leading digit if it starts with 1
        }

        checkForErrors();


    }


    public String getNumber()
    {
        return this.anPhoneNumber;
    }


    public void checkForErrors() throws IllegalArgumentException
    {
        String areaCodeStr = "";
        String exchangeCodeString = "";
        Scanner numberScan = new Scanner(this.anPhoneNumber);
        int count = 0;

        /*
        while (numberScan.hasNext())
        {
            String someNumberLine = numberScan.nextLine();

            for (int i = 0; i < someNumberLine.length(); i++)
            {
                String aDigit = someNumberLine.substring(i, i + 1);
                checkDigit(aDigit);
            }

            if (count == 1)
            {
                AreaCodeCheck predicate = new AreaCodeCheck();
                predicate.process(someNumberLine);
            } else if (count == 2)
            {
                ExchangeCodeCheck predicate = new ExchangeCodeCheck();
                predicate.process(someNumberLine);
            }
            count++;
        }*/

        for (int i = 0; i < anPhoneNumber.length(); i++)
        {
            String aDigit = anPhoneNumber.substring(i, i + 1);
            checkDigit(aDigit);

            if (count == 0)
            {
                areaCodeStr = areaCodeStr.concat(anPhoneNumber.substring(i, i+1));
                if (areaCodeStr.length() == 3)
                {
                    AreaCodeCheck predicate = new AreaCodeCheck();
                    predicate.process(areaCodeStr);
                    count = 1;
                }
            } else if (count == 1)
            {
                exchangeCodeString = exchangeCodeString.concat(anPhoneNumber.substring(i, i+1));
                if (exchangeCodeString.length() == 3)
                {
                    ExchangeCodeCheck predicate = new ExchangeCodeCheck();
                    predicate.process(exchangeCodeString);
                    count = 2;
                }
            }

            /*if (i == 2)
            {
                count++;
            }*/

        }
    }


    public void checkDigit(String aDigit)
    {
        if (aDigit.matches("[a-zA-Z]"))
        {
            throw new IllegalArgumentException("letters not permitted");
        }
        if (!aDigit.matches("[0-9]"))
        {
            throw new IllegalArgumentException("punctuations not permitted");
        }
        //if(aDigit.matches())
    }

    public interface PhoneNumberPredicate
    {
        void process(String aNumber);
    }


}

class MeowTesters
{
    public static void main(String[] asdasdasd)
    {
        String aStr = "A B C D E";
        aStr = aStr.replaceAll("[()-. ]", "");

    }
}