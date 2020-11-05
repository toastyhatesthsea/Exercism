/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/


public class PhoneNumber
{
    private String anPhoneNumber;

    public PhoneNumber(String aPhoneNumber)
    {
        aPhoneNumber = aPhoneNumber.strip();
        this.anPhoneNumber = aPhoneNumber;
    }


    public String getNumber()
    {
        return "";
    }

    public String getRidOfSpecialCharacters() throws IllegalArgumentException
    {
        for (int i = 0; i < anPhoneNumber.length(); i++)
        {
            Character aDigit = anPhoneNumber.charAt(i);
        }
    }


    public void errorCheck(String aDigit)
    {
        if (aDigit.matches("[a-zA-Z]"))
        {
            throw new IllegalArgumentException("letters not permitted");
        }
    }


}