import java.util.HashMap;
import java.util.Map;

public class Straights implements Yacht.YachtPredicateThing
{
    @Override
    public int process(HashMap<Integer, Integer> aMap, YachtCategory aYachtCategory)
    {
        int total = 30;
        int starter = 0;
        int end = 0;
        boolean correctAnswer = true;
        if (aYachtCategory.equals(YachtCategory.BIG_STRAIGHT))
        {
            starter = 2;
            end = 6;
        } else
        {
            starter = 1;
            end = 5;
        }

        for (int i = starter; i <= end && correctAnswer; i++)
        {
            int amount = aMap.getOrDefault(i, 0);

            if (amount == 0 || amount > 1)
            {
                correctAnswer = false;
                total = 0;
            }
        }

        return total;
    }
}
