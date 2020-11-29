/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School
{
    HashMap<Integer, ArrayList<Student>> schoolList;

    public School()
    {
        schoolList = new HashMap<>();
    }

    public void add(String name, int grade)
    {
        Student aStudent = new Student(name, grade);

        ArrayList<Student> someList = new ArrayList<>();
        someList.add(aStudent);

        someList = schoolList.putIfAbsent(aStudent.getGrade(), someList);

        if (someList != null)
        {
            someList.add(aStudent);
            schoolList.replace(aStudent.getGrade(), someList);
        }
    }

    public List<String> roster()
    {
        ArrayList<String> answer = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Student>> entry : schoolList.entrySet())
        {
            Integer key = entry.getKey();
            ArrayList<Student> studentList = entry.getValue();

            for (int i = 0; i < studentList.size(); i++)
            {
                answer.add(studentList.get(i).getName());
            }
        }
        return answer;
    }

    public ArrayList<String> grade(int aGrade)
    {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Student> aList = schoolList.get(aGrade);

        for (int i = 0; aList!=null && i < aList.size(); i++)
        {
            answer.add(aList.get(i).getName());
        }
        return answer;
    }
}

class Student
{
    private String name;
    private int grade;

    public Student(String aName, int aGrade)
    {
        this.name = aName;
        this.grade = aGrade;
    }

    public int getGrade()
    {
        return grade;
    }

    public String getName()
    {
        return name;
    }

    public void setGrade(int grade)
    {
        this.grade = grade;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}