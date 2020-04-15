package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        final String fileName = "input.txt";
        final int numOfStudents = 3325;

        final File file = new File(fileName);

        System.out.println("Hello Banner");

        System.out.println("\n");

        System.out.print("Creating the input file...");
        createBannerData(fileName, numOfStudents);
        System.out.println("done.");

        getFileStudentNames(file, numOfStudents);

        String nameFrequency = studentNameFrequency(getStudentNames(),
                getFileStudentNames(file, numOfStudents));

        System.out.println("\n");

        System.out.println("This is how many times each name appeared: " + nameFrequency + " ");

        System.out.println("\n");

        ArrayList<String> studentNameArrayList = arrayToList(getFileStudentNames(file, numOfStudents));
        Collections.sort(studentNameArrayList);
        System.out.println("Name Array List: " + studentNameArrayList);

        System.out.println("\n");

        checkForDuplicateID(file, numOfStudents);

        ArrayList<Student> studentList = getStudentList(file, numOfStudents);
        System.out.println("Student Array List: " + studentList);

        System.out.println("\n");

        Stack<Student> studentStack = pushStudentArrayListToStack(studentList);
        System.out.println("Student Stack: " + studentStack);

        System.out.println("\n");

        System.out.println("Popped Stack: " + popStudentStack(studentStack));

        Set<String> duplicateSet = checkForDuplicateIDSet(file, numOfStudents);
        System.out.println("\n");

        System.out.println("Here are the duplicates: " + duplicateSet);

        System.out.println("\n");

        System.out.println(checkNameFrequencyMap(getStudentNames(), getFileStudentNames(file, numOfStudents)));



    }

    //Methods

    private static List<String> getStudentNames() {

        return Arrays.asList("Jimmy", "Gilbert", "Brian", "Babob", "Tony", "Becky", "Joshua",
                "Diaz", "Laura", "Vicky");
    }

    private static String createStudent(int currentStudentID) {
        Random random = new Random();
        double studentGPA = 0.0;
        List<String> studentNames = getStudentNames();

        String studentName = studentNames.get(random.nextInt(10)); //Picks student name

        for (int j = 0; j < 4; j++) {
            studentGPA += random.nextDouble();                             //Generates random student GPA
        }

        return currentStudentID + "," + studentName + "," + studentGPA;
    }

    private static void createBannerData(String fileName, int numOfStudents) {
        int studentID = 90000; //would have made these variables but they were specified values in the PDF
        try (PrintWriter writer = new PrintWriter(fileName)) { //Try with resources
            for (int i = 0; i < numOfStudents; i++) {

                writer.println(createStudent(studentID));
                studentID++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error occurred when trying to pull the file");
        }
    }

    private static List<String> getFileStudentNames(File fileName, int numOfStudents) throws FileNotFoundException {
        Scanner scanner = new Scanner(fileName);
        String[] array = new String[numOfStudents];
        for(int i = 0; i < numOfStudents; i++){
            String data = scanner.nextLine();
            String[] splitData = data.split(",");
            String studentName = splitData[1];
            array[i] = studentName;

        }
       return Arrays.asList(array);
    }

    private static String studentNameFrequency(List<String> originalStudentList, List<String> generatedStudentList){
        int count = 0;
        StringBuilder studentFrequency = new StringBuilder(" ");
            for(String name: originalStudentList){
                for(String otherName: generatedStudentList){
                    if(name.equals(otherName)){
                        count ++;
                    }
                }
                studentFrequency.append(name).append(": ").append(count).append(" ");
                count = 0;
            }
            return studentFrequency.toString();
        }

    static ArrayList<String> arrayToList(List<String> names){
        return new ArrayList<>(names);
    }

        private static void checkForDuplicateID(File fileName, int numOfStudents) throws FileNotFoundException {
        boolean isDuplicate = false;
            Scanner scanner = new Scanner(fileName);
            ArrayList<String> array = new ArrayList<>();
            for(int i = 0; i < numOfStudents; i++){
                String data = scanner.nextLine();
                String[] splitData = data.split(",");
                String studentID = splitData[0];
                array.add(studentID);

            }
            for(int i = 0; i < numOfStudents; i++) {
                for (int j = i+1; j < numOfStudents; j++) {
                    if (array.get(i).equals(array.get(j))) {
                        isDuplicate = true;
                        break;
                    }
                }
            }
            if(isDuplicate){
                System.out.println("There are duplicate ID's");
            }else{
                System.out.println("There are no duplicate ID's");
            }
        }

        private static ArrayList<Student> getStudentList(File fileName, int numOfStudents) throws FileNotFoundException {
            Scanner scanner = new Scanner(fileName);
            ArrayList<Student> array = new ArrayList<>();
            for(int i = 0; i < numOfStudents; i++){
                String data = scanner.nextLine();
                String[] splitData = data.split(",");
                String studentID = splitData[0];
                String studentName = splitData[1];
                String studentGPA = splitData[2];
                Student student = new Student(Integer.parseInt(studentID),studentName,Double.parseDouble(studentGPA));
                array.add(student);
            }
            return array;
        }

        private static Stack<Student> pushStudentArrayListToStack(ArrayList<Student> studentArrayList){
            Stack<Student> studentStack = new Stack<>();
            for(Student student: studentArrayList){
                studentStack.push(student);
            }
            return studentStack;
        }

        private  static  Stack<Student> popStudentStack(Stack<Student> studentStack) {
            while (studentStack.size() != 0){
                studentStack.pop();
        }
            return studentStack;
        }

        private static  Set<String> checkForDuplicateIDSet(File fileName, int numOfStudents) throws FileNotFoundException {
            Scanner scanner = new Scanner(fileName);
            ArrayList<String> array = new ArrayList<>();
            for(int i = 0; i < numOfStudents; i++){
                String data = scanner.nextLine();
                String[] splitData = data.split(",");
                String studentID = splitData[0];
                array.add(studentID);

            }
            final Set<String> set = new HashSet<>();
            final Set<String> duplicateSet = new HashSet<>();
            for(int i = 0; i < numOfStudents; i++) {
                    if(!set.add(array.get(i))){
                        duplicateSet.add(array.get(i));
                    }
                }
            return duplicateSet;
        }

        private static HashMap<String,Integer> checkNameFrequencyMap(List<String> originalStudentList, List<String> generatedStudentList){
            HashMap<String,Integer> studentNameMap = new HashMap<>();
            int count = 0;
            for (String name: originalStudentList){
                for(String otherName: generatedStudentList){
                    if (name.equals(otherName)){
                        studentNameMap.putIfAbsent(name, count);
                        studentNameMap.put(name, count++);
                    }
                }
                count = 0;
            }
            return  studentNameMap;
        }
    }





