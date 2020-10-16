import java.util.HashMap;

class Yacht
{

    private int[] dice;
    private YachtCategory aCategory;


    Yacht(int[] dice, YachtCategory yachtCategory)
    {
        this.dice = dice;
        this.aCategory = yachtCategory;
    }

    public int processDice(YachtPredicateThing aPredicate)
    {
        HashMap<Integer, Integer> amountOfIntegers = new HashMap<>();
        for (int anInt : dice)
        {
            Integer returnedValueIfNoValue = amountOfIntegers.putIfAbsent(anInt, 1);
            if (returnedValueIfNoValue != null)
            {
                amountOfIntegers.put(anInt, returnedValueIfNoValue + 1);
            }
        }
        return aPredicate.process(amountOfIntegers, aCategory);
    }

    int score()
    {
        int totalScore = 0;
        boolean ValidAnswer = true;
        HashMap<Integer, Integer> amountOfIntegers = new HashMap<>();

        if (this.aCategory.equals(YachtCategory.ONES) || aCategory.equals(YachtCategory.TWOS) || aCategory.equals(YachtCategory.THREES) ||
                aCategory.equals(YachtCategory.FOURS) || aCategory.equals(YachtCategory.FIVES) || aCategory.equals(YachtCategory.SIXES))
        {

            totalScore = processDice(new YachtOnes());
            return totalScore;

        } else if (aCategory.equals(YachtCategory.YACHT) || aCategory.equals(YachtCategory.FULL_HOUSE) || aCategory.equals(YachtCategory.FOUR_OF_A_KIND)
                || aCategory.equals(YachtCategory.CHOICE))
        {
            totalScore = processDice(new OfAKind());
            return totalScore;

        } else if (aCategory.equals(YachtCategory.BIG_STRAIGHT) || (aCategory.equals(YachtCategory.LITTLE_STRAIGHT)))
        {
            return processDice(new Straights());
        }
        return 0;
    }

    public interface YachtPredicateThing
    {
        int process(HashMap<Integer, Integer> aMap, YachtCategory aYachtCategory);
    }

}
