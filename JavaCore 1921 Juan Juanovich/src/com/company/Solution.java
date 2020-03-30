package com.company;

/*

1921 Juan Juanovich
In the main method, the first parameter is the name of the file.
In this file, each line has the following form:
name day month year
where [name] - can consist of several words separated by spaces, and has type String.
[day] - int, [month] - int, [year] - int
data is separated by spaces.
Fill the PEOPLE list using data from the file.
Close streams.
Example input file:
Ivanov Ivan Ivanovich 31 12 1987
Vasya 15 5 2013

Requirements:
1. The Solution class must contain a public PEOPLE constant of type List, which must be immediately initialized.
2. The program should NOT read data from the console.
3. The program should read the contents of the file (use FileReader).
4. The stream of reading from the file (FileReader) should be closed.
5. The program should populate the PEOPLE list with data from the file.
6. The program should work correctly with double names, for example, Anna-Nadezhda.


*/

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();
    public static void main(String[] args) throws IOException {
     String fileName = args[0];
     try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
         while (fileReader.ready()) {
             String line = fileReader.readLine();
             String nameStr = line.replaceAll("[\\w]", "").trim();
             String[] digitalParts = line.substring(nameStr.length()).trim().split(" ");
             int day = Integer.parseInt(digitalParts[0]);
             int month = Integer.parseInt(digitalParts[1]);
             int year = Integer.parseInt(digitalParts[2]);
             Date date = new GregorianCalendar(year, month-1, day).getTime();
             PEOPLE.add(new Person(nameStr, date));
         }
     }

    }
}
