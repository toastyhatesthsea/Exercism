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
        aPhoneNumber = aPhoneNumber.strip();

        aPhoneNumber = aPhoneNumber.replaceAll("[()-.]", " ");
        this.anPhoneNumber = aPhoneNumber;
        checkForErrors();

        if (this.anPhoneNumber.length() > 11)
        {
            throw new IllegalArgumentException("more than 11 digits");
        } else if (this.anPhoneNumber.length() < 10)
        {
            throw new IllegalArgumentException("incorrect number of digits");
        }

    }


    public String getNumber()
    {
        return "";
    }


    public String checkForErrors() throws IllegalArgumentException
    {
        Scanner numberScan = new Scanner(this.anPhoneNumber);
        int count = 0;

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
        }

        for (int i = 0; i < anPhoneNumber.length(); i++)
        {
            String aDigit = anPhoneNumber.substring(i, i + 1);
            checkDigit(aDigit);

        }

        return "";
    }


    public void checkDigit(String aDigit)
    {
        if (aDigit.matches("[a-zA-Z]"))
        {
            throw new IllegalArgumentException("letters not permitted");
        }
        if (!aDigit.matches("[1-9]"))
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