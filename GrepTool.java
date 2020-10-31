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
    private boolean moreThanOneFile;

    private int lineCount = 1;


    public String grep(String findThisString, Collection<String> aFlags, Collection<String> fileName)
    {
        String answer = "";
        File aFile;
        //this.lineCount = 0;

        processFlags(aFlags); //Process Flags
        if (fileName.size() > 1)
        {
            moreThanOneFile = true;
        }

        for (String aSingleFileName : fileName)
        {
            aFile = new File(aSingleFileName);
            try
            {
                Scanner scanFile = new Scanner(aFile);
                boolean foundLine = false;
                boolean finished = false;
                this.lineCount = 1;


                while (scanFile.hasNext() && !finished)
                {
                    String aLine = scanFile.nextLine();

                    foundLine = lineMatcher(aLine, findThisString);

                    //TODO Must add processing options for processing entire lines and just processing if there is a match in the file and printing filename
                    //TODO Must do processing for flags: -x and -l

                    String temp = "";
                    if (foundLine && matchFile && !this.invertMatch)
                    {
                        temp = aSingleFileName;
                        finished = true;

                    } else if (!foundLine && matchFile && this.invertMatch)
                    {
                        temp = aSingleFileName;
                        finished = true;
                    } else if (!foundLine && this.invertMatch)
                    {
                        temp = processAnswer(aLine, aSingleFileName);
                    } else if (foundLine && !this.invertMatch)
                    {
                        temp = processAnswer(aLine, aSingleFileName);
                    }

                    //Create new lines
                    if (answer.isEmpty() && !temp.isEmpty())
                    {
                        answer = temp;
                    } else if (!temp.isEmpty())
                    {
                        answer = answer.concat("\n" + temp);
                    }

                    this.lineCount++;
                }

            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }

        return answer;
    }

    /**
     * Amends and writes out the matched line according to different flags
     *
     * @param lineToProcess String
     * @return String
     */
    public String processAnswer(String lineToProcess, String fileName)
    {
        String lineNumber = "", fileString = "";


        if (lineNumberFlag)
        {
            lineNumber = this.lineCount + ":";
        }
        if (moreThanOneFile)
        {
            fileString = fileName + ":";
        }

        lineToProcess = fileString + lineNumber + lineToProcess;

        return lineToProcess;
    }

    public void processFlags(Collection<String> flags)
    {
        for (String aFlag : flags)
        {
            if (aFlag.equals("-n"))
            {
                this.lineNumberFlag = true;
            } else if (aFlag.equals("-l")) //Just looks for writing out filename instead of each line, takes precedence
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

    public boolean lineMatcher(String aLine, String stringToFind)
    {
        if (caseInsensitiveFlag)
        {
            stringToFind = stringToFind.toLowerCase();
            aLine = aLine.toLowerCase();
        }

        if (matchEntireLines)
        {
            return aLine.equals(stringToFind);
        } else
        {
            Scanner aScanLine = new Scanner(aLine);
            boolean answer = false;
            aScanLine.useDelimiter("[,!;: ]");
            //answer = aLine.contains(stringToFind);

            while (aScanLine.hasNext() && !answer)
            {
                String aWord = aScanLine.next();
                aWord = aWord.replaceAll("[^a-zA-Z]", "");
                //answer = aPred.isEqual(aWord, stringToFind);
                answer = aWord.contains(stringToFind);

            }
            return answer;
        }
    }

    public boolean invertedLineMatcher(String aLine, String stringToFind)
    {
        Scanner aScanLine = new Scanner(aLine);
        boolean answer = false;

        while (aScanLine.hasNext() && !answer)
        {
            String aWord = aScanLine.next();
            //answer = aPred.isEqual(aWord, stringToFind);
            if (this.caseInsensitiveFlag)
            {
                answer = aWord.equalsIgnoreCase(stringToFind);
            } else
            {
                answer = aWord.equals(stringToFind);
            }
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

        String pel = "Peleus'";
        String anotherPel = "Pelelklkl";

        boolean answer = pel.contains(anotherPel);

        String someLine = "How may you wake";

        //aTool.lineMatcher(someLine, "ay", new CaseInsensitiveGrep());
    }
}