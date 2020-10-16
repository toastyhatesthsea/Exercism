import java.util.HashMap;
import java.util.Map;

public class OfAKind implements Yacht.YachtPredicateThing
{
    @Override
    public int process(HashMap<Integer, Integer> aMap, YachtCategory aYachtCategory)
    {
        int total = 0;
        boolean fullHouseTwos = false;
        boolean fullHouseThrees = false;
        int fullHouseTotal = 0;
        //boolean answerFound = false;
        for (Map.Entry<Integer, Integer> entry : aMap.entrySet())
        {
            if (aYachtCategory.equals(YachtCategory.FOUR_OF_A_KIND) && entry.getValue() >= 4)
            {
                return entry.getKey() * 4;
            } else if (aYachtCategory.equals(YachtCategory.CHOICE))
            {
                total += entry.getKey() * entry.getValue();
            } else if (aYachtCategory.equals(YachtCategory.YACHT) && entry.getValue() == 5)
            {
                return 50;
            } else if (aYachtCategory.equals(YachtCategory.FULL_HOUSE))
            {
                if (entry.getValue() == 2 && !fullHouseTwos)
                {
                    fullHouseTwos = true;
                    fullHouseTotal += entry.getKey() * entry.getValue();
                } else if (entry.getValue() == 3 && !fullHouseThrees)
                {
                    fullHouseThrees = true;
                    fullHouseTotal += entry.getKey() * entry.getValue();
                }
            }
        }

        if (aYachtCategory.equals(YachtCategory.FULL_HOUSE) && fullHouseThrees && fullHouseTwos)
        {
            return fullHouseTotal;
        } else if (aYachtCategory.equals(YachtCategory.CHOICE))
        {
            return total;
        }
        return 0;
    }
}
