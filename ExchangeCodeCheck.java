public class ExchangeCodeCheck implements PhoneNumber.PhoneNumberPredicate
{

    @Override
    public void process(String aNumber)
    {
        String aDigit = aNumber.substring(0, 1);

        if (aDigit.equals("0"))
        {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        } else if (aDigit.equals("1"))
        {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }
    }
}
