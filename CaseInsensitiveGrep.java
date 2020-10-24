public class CaseInsensitiveGrep implements GrepTool.grepPredicate
{

    @Override
    public boolean isEqual(String aWord, String anotherWord)
    {
        return aWord.equalsIgnoreCase(anotherWord);
    }
}
