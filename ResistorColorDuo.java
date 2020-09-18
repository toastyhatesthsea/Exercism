class ResistorColorDuo
{
    int value(String[] colors)
    {
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        int firstValue = -1, secondValue = -1;

        for (int i = 0; i < 2 && i < colors.length; i++)
        {
            if (firstValue == -1)
            {
                firstValue = getColor(colors[i]);
            } else
            {
                secondValue = getColor(colors[i]);
            }
        }

        if (secondValue == -1)
        {
            return firstValue;
        } else
        {
            return firstValue * 10 + secondValue;

        }

    }

    private int getColor(String aColor)
    {
        //not really necessary
        aColor = aColor.substring(0, 1).toUpperCase().concat(aColor.substring(1, aColor.length()));
        switch (aColor)
        {
            case "Black":
                return 0;
            case "Brown":
                return 1;
            case "Red":
                return 2;
            case "Orange":
                return 3;
            case "Yellow":
                return 4;
            case "Green":
                return 5;
            case "Blue":
                return 6;
            case "Violet":
                return 7;
            case "Grey":
                return 8;
            case "White":
                return 9;
        }
        return -1;

    }
}
