import java.util.HashMap;

public class YachtOnes implements Yacht.YachtPredicateThing
{
    @Override
    public int process(HashMap<Integer, Integer> aMap, YachtCategory aYachtCategory)
    {
        int multiplier = 0;
        if (aYachtCategory.equals(YachtCategory.ONES))
        {
            multiplier = 1;
        } else if (aYachtCategory.equals(YachtCategory.TWOS))
        {
            multiplier = 2;
        } else if (aYachtCategory.equals(YachtCategory.THREES))
        {
            multiplier = 3;
        } else if (aYachtCategory.equals(YachtCategory.FOURS))
        {
            multiplier = 4;
        } else if (aYachtCategory.equals(YachtCategory.FIVES))
        {
            multiplier = 5;
        } else if (aYachtCategory.equals(YachtCategory.SIXES))
        {
            multiplier = 6;
        }

        int total = aMap.getOrDefault(multiplier, 0) * multiplier;
        return total;
    }
}
