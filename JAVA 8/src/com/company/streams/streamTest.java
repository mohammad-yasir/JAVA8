package com.company.streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class streamTest {
    public static void main(String[] args) {

        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                18,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                25,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

        Student student4 = new Student(
                "yasir",
                23,
                new Address("12326"),
                Arrays.asList(new MobileNumber("33343"), new MobileNumber("44454")));
        List<Student> students = Arrays.asList(student1, student2, student3);

        TempStudent tmpStud1 = new TempStudent(
                "Jayesh1",
                201,
                new Address("12341"),
                Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

        TempStudent tmpStud2 = new TempStudent(
                "Khyati1",
                202,
                new Address("12351"),
                Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

        String name = students.stream().map(Student::getName).collect(Collectors.joining(","));
        System.out.println(name);
        System.out.println("-----------");
        List<String> stringStudent = students.stream().map(Student::getName).collect(toList());
        System.out.println(stringStudent);
        System.out.println("-----------");
        List<String> uppercaseList = students.stream().map(Student::getName).map(String::toUpperCase).collect(toList());
        System.out.println(uppercaseList);
        System.out.println("-----------");
        students.stream().map(Student::getName).map(String::toUpperCase).forEach(System.out::println);
        System.out.println("-----------");
        List<String> sortedStudentList = students.stream().map(Student::getName).sorted().collect(toList());
        System.out.println(sortedStudentList);
        System.out.println("-----------");
        students.stream().map(Student::getName).sorted().forEach(System.out::println);
        System.out.println("-----------");
//        List<Student> convertedList =
                tmpStudents.stream().map(tmpStud -> new Student(tmpStud.name,tmpStud.age,tmpStud.address,tmpStud.mobileNumbers))
                        .forEach(System.out::println);
        System.out.println("-----------");

        List<MobileNumber> flatList = students.stream().map(Student::getMobileNumbers).flatMap(List::stream).collect(toList());
        System.out.println(flatList);
        System.out.println("-----------");
        students.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);
        System.out.println("-----------");
        students.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
        System.out.println("-----------");
        students.stream().sorted(Comparator.comparing(Student::getAge).reversed()).forEach(System.out::println);
        System.out.println("-----------");
        students.stream().filter(student -> student.getName().equals("Jayesh")).forEach(System.out::println);
        System.out.println("-----------");
        students.stream().filter(student -> student.getAddress().getZipcode().equals("1235")).forEach(System.out::println);
        System.out.println("-----------");
//        Optional<Student> studentOptional =
//                students.stream().filter(student -> student.getMobileNumbers().stream()
//                .anyMatch(mobileNumber -> Object)).
//                        collect(toList())();
//        System.out.println(studentOptional.isPresent()?studentOptional.get().getName() : "Not found");
        List<Student> stud2 = students.stream()
                .filter(student111 -> student111.getMobileNumbers().stream().anyMatch(x ->x.getNumber().equals("3333")))
                .collect(Collectors.toList());

        String result1 = stud2.stream().map(std -> std.getName()).collect(Collectors.joining(",", "[", "]"));
        System.out.println(result1);
        System.out.println("--------------------");

        List<Student> stud3 = students.stream()
                .filter(student111 -> student111.getMobileNumbers().stream().anyMatch(x ->x.getNumber().equals("1233") ||x.getNumber().equals("1234")))
                .collect(Collectors.toList());

        String result2 = stud3.stream().map(std -> std.getName()).collect(Collectors.joining(",", "[", "]"));
        System.out.println(result2);
        System.out.println("--------------------");

        Optional<Student> highestAge = students.stream().reduce((stu1,stu2) ->{
            if(stu1.getAge() > stu2.getAge())
                return  stu1;
            else
                return stu2;
        });
        System.out.println(highestAge.isPresent() ? highestAge.get() : "not found");
        System.out.println("--------------------");

        Optional<Student> highestAge1 = students.stream().reduce((stu1,stu2) ->stu1.getAge()>stu2.getAge() ? stu1 : stu2);
        System.out.println(highestAge1.isPresent() ? highestAge1.get() : "not found");

        int sumAge = students.stream().filter(x -> x.getAge()>18).map(Student::getAge).reduce(1,(a,b)-> a*b);
        System.out.println(sumAge);
        int maxAge = students.stream().map(Student::getAge).reduce(0,Integer::max);
        System.out.println(maxAge);
        System.out.println("--------------------");

        Integer studentOptional = students.stream().skip(1).limit(2).map(Student::getAge).reduce(0,Integer::sum);
        System.out.println(studentOptional);

        students.stream().allMatch(y->y.getAge()>18);


    }
}
