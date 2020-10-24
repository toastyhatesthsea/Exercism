/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;

public class GrepTool
{
    private boolean caseInsensitiveFlag;
    private boolean lineNumberFlag;
    private boolean matchFile;
    private boolean invertMatch;
    private boolean matchEntireLines;
    private int lineCount;


    public String grep(String findThisString, Collection<String> aFlags, Collection<String> fileName)
    {
        String answer = "";
        File aFile;
        this.lineCount = 0;

        processFlags(aFlags); //Process Flags

        for (String aSingleFileName : fileName)
        {
            aFile = new File(aSingleFileName);
            try
            {
                Scanner scanFile = new Scanner(aFile);

                while (scanFile.hasNext())
                {
                    boolean foundLine = false;
                    String aLine = scanFile.nextLine();

                    if (caseInsensitiveFlag)
                    {
                        foundLine = lineMatcher(aLine, findThisString, new CaseInsensitiveGrep());
                    }
                    else if


                    if (foundLine)
                    {
                        processAnswer(aLine);
                    }
                    this.lineCount++;
                }

            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }

        for (String aFlag : aFlags)
        {
            if (aFlag.equalsIgnoreCase("-i"))
            {
                grepPredicate ignoreCase = new CaseInsensitiveGrep();
            }
        }


        return answer;
    }

    public String processAnswer(String anAnswer)
    {
        //AdmendLine lineAdmender;
        if (caseInsensitiveFlag)
        {
            anAnswer = this.lineCount + ":"+ anAnswer;
        }
        return anAnswer;
    }

    public void processFlags(Collection<String> flags)
    {
        for (String aFlag : flags)
        {
            if (aFlag.equals("-n"))
            {
                this.lineNumberFlag = true;
            } else if (aFlag.equals("-l"))
            {
                this.matchFile = true;
            } else if (aFlag.equals("-v"))
            {
                this.invertMatch = true;
            } else if (aFlag.equals("-x"))
            {
                this.matchEntireLines = true;
            } else if (aFlag.equals("-i"))
            {
                this.caseInsensitiveFlag = true;
            }
        }
    }

    public boolean lineMatcher(String aLine, String stringToFind, grepPredicate aPred)
    {
        Scanner aScanLine = new Scanner(aLine);
        boolean answer = false;
        answer = aLine.contains(stringToFind);

        while (aScanLine.hasNext() && !answer)
        {
            String aWord = aScanLine.next();
            answer = aPred.isEqual(aWord, stringToFind);
        }

        return answer;
    }

    public interface grepPredicate
    {
        boolean isEqual(String aWord, String anotherWord);
    }

    public interface AdmendLine
    {
        String processLine(String aString);
    }
}

class Testers
{
    public static void main(String[] asdasdasd)
    {
        GrepTool aTool = new GrepTool();


        String someLine = "How may you wake";

        aTool.lineMatcher(someLine, "ay", new CaseInsensitiveGrep());
    }
}