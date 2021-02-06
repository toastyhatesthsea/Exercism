/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.*;

public class WordProblemSolver
{

    public WordProblemSolver()
    {
        whatToCompute = new String[3];
        parsedDataFromPhrase = new HashMap<>();
        numbers = new int[10];
        numberQueue = new LinkedList<>();
    }

    private String[] whatToCompute;
    private HashMap<String, Integer> parsedDataFromPhrase;
    private String[] operatorsInOrder;
    private int[] numbers;
    private Queue<Object> numberQueue;
    private String operator;

    public int solve(String somePhraseToCompute)
    {
        int answer = -1;
        boolean mustHaveNumber = true;
        boolean mustHaveOperator = true;
        int numbersIndex = 0;

        whatToCompute = somePhraseToCompute.split(" ");
        parsePhraseIntoHashMap(somePhraseToCompute);

        for (Map.Entry<String, Integer> anEntry : parsedDataFromPhrase.entrySet())
        {

        }

        for (int i = 0; i < whatToCompute.length; i++)
        {
            String data = whatToCompute[i];
            if (!data.equals("What") && i == 0)
            {
                throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
            } else if (!data.equals("is") && i == 1)
            {
                throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
            } else if (checkForOperatorPhrase(data) && i == 3)
            {
                //TODO Must evaluate properly based on which operator
            }
            if (mustHaveNumber)
            {
                try
                {
                    //TODO Must consider numbers with ? attached to the end, i.e. 35?
                    int aNumberParsed = Integer.parseInt(data);
                    if (numberQueue.size() > 0)
                    {
                        int firstNumber = (int) numberQueue.remove();
                        int calculatedAnswer = calculateStatement(firstNumber, aNumberParsed, operator);
                        numberQueue.add(calculatedAnswer);
                    }
                    else
                    {
                        numberQueue.add(aNumberParsed);
                    }
                    //numbers[numbersIndex] = aNumberParsed;
                    //numberQueue.add(aNumberParsed);
                } catch (Exception e)
                {
                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
                }
                mustHaveNumber = false;
            } else if (mustHaveOperator)
            {
                try
                {
                    boolean hasOperator = checkForOperatorPhrase(data);
                    if (hasOperator)
                    {
                        //TODO Must process operators correctly 
                    } else
                    {
                        throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
                    }
                } catch (Exception e)
                {
                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
                }
            }

        }


        return answer;
    }

    public boolean checkForOperatorPhrase(String someWord)
    {
        boolean answer = false;
        if (someWord.equals("divided"))
        {
            answer = true;
        } else if (someWord.equals("plus"))
        {
            answer = true;
        } else if (someWord.equals("minus"))
        {
            answer = true;
        } else if (someWord.equals("multiplied"))
        {
            answer = true;
        }
        return answer;
    }

    /**
     * Takes two numbers and processes them according to the String operator parameter
     * @param firstNumber int
     * @param secondNumber int
     * @param operator String
     * @return int
     */
    public int calculateStatement(int firstNumber, int secondNumber, String operator)
    {
        int answer = -1;
        switch (operator)
        {
            case "multiplied":
            {
                answer = firstNumber * secondNumber;
                break;
            }
            case ("subtract"):
            case ("minus"):
            {
                answer = firstNumber - secondNumber;
                break;
            }
            case ("divided"):
            {
                answer = firstNumber / secondNumber;
                break;
            }
            case ("plus"):
            {
                answer = firstNumber + secondNumber;
                break;
            }
        }
        return answer;
    }

    public void parsePhraseIntoHashMap(String somePhrase)
    {
        Scanner someScan = new Scanner(somePhrase);

        while (someScan.hasNext())
        {
            String aWord = someScan.next();
            Integer someValue = parsedDataFromPhrase.putIfAbsent(aWord, 1);

            if (someValue != null)
            {
                parsedDataFromPhrase.put(aWord, someValue + 1);
            }
        }
    }

    /**
     * Gathers operators from a string of words
     * > What is 3 plus 2 multiplied by 3?
     *
     * @param somePhrase String
     */
    public static String[] gatherOperatorWords(String[] somePhrase)
    {
        String[] answer = new String[somePhrase.length];
        int counter = 0;
        for (int i = 0; i < somePhrase.length; i++)
        {
            String meow = somePhrase[i];
            if (meow.equals("plus"))
            {
                answer[counter] = meow;
                counter++;
            } else if (meow.equals("minus"))
            {
                answer[counter] = meow;
                counter++;
            } else if (meow.equals("multiplied"))
            {
                try
                {
                    if (!somePhrase[i + 1].equals("by"))
                    {
                        throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
                    }
                } catch (Exception e)
                {
                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
                }

                answer[counter] = meow;
                counter++;
            }else if()

            else
            {
                answer[counter] = meow;
                counter++;
            }
        }
        return answer;
    }

    public void errorCheckers()
    {
        if (parsedDataFromPhrase.get("What") == null)
        {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
    }

}
