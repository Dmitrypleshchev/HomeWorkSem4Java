/*Организовать ввод и хранение данных пользователей. ФИО возраст, пол и выход из режима ввода информации
вывод в формате Фамилия И.О. возраст пол
добавить возможность выхода или вывода списка отсортированного по возрасту!)
*реализовать сортировку по возрасту с использованием индексов
*реализовать сортировку по возрасту и полу с использованием индексов*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.*;


class User {
  public String fullName;
  public Integer age;
  public String gender;
  public User (String fullName, Integer age, String gender){
    this.age = age;
    this.gender = gender;
    this.fullName = fullName;
  }
  public String getFullName(){
  return fullName;
  }
  public  Integer getAge(){
  return age;
  }

  public String getGender(){
  return gender;
  }

  public void displayUser(){
  System.out.println (fullName + " " + age + " " + gender);
  }
}

public class Main{
  public static List users = new ArrayList<>();
  public static int currentIndex = 0;
  
  public static void  main (String[] args) {
    Scanner scanner = new Scanner (System.in);

    while (true) {
      System.out.println("Введите команду: ");
      String command = scanner.nextLine().toLowerCase();

      if (command.equals("add")){
        addUser(scanner);
      }
    
      else if (command.equals("list")) {
        listUsers();
      }
      else if (command.equals("sort by age")) {
        sortByAge();
        listUsers();
      }
      else if (command.equals("sort by age and gender")) {
        sortByAgeAndGender();
        listUsers();
      }
      else if (command.equals("exit")) {
        break;
      }
      else{
        System.out.println("Команда неверная. Попробуйте снова)");
      }
    }
   }
   public static void addUser(Scanner scanner) {
    System.out.println ("Введите ФИО: ");
    String fullName = scanner.nextLine();

    System.out.println ("Введите возраст: ");
    int age = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Введите пол (М или Ж): ");
    String gender = scanner.nextLine().toLowerCase();

    User user = new User(fullName, age, gender);
    users.add(user);
    System.out.println("Пользователь успешно добавлен");
   }
  

   public static void listUsers() {
    for (User user : users){
      user.displayUser();
    }
   }

    public static void sortByAge() {
    int[] indexes = new int[users.size()];
    for (int i =0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    
    for (int i = 0; i < users.size() -1; i ++) {
      for (int j =0; j < users.size() - i - 1; j++) {
        if(((User) users.get(indexes[j])).getAge() > ((User) users.get(indexes[j+1])).getAge()) {
          int temp = indexes[j];
          indexes[j] = indexes[j+1];
          indexes[j+1] = temp; 

        }
      } 
    }

    List sortedUsers = new ArrayList();
    for (int index : indexes) {
      sortedUsers.add(users.get(index));
    }
    users = sortedUsers;
   }

   public static void sortByAgeAndGender() {
    int[] indexes = new int[users.size()];
    for(int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }

    for (int i = 0; i < users.size() -1; i ++) {
      for (int j =0; j < users.size() - i - 1; j++) {
        User current = (User) users.get(indexes[j]);
        User next = (User) users.get(indexes[j+1]);

        if (current.getAge() > next.getAge() || (current.getAge() == next.getAge() && current.getGender().compareTo(next.getGender()) > 0)) {
          int temp = indexes[j];
          indexes[j] = indexes[j+1];
          indexes[j+1] = temp;
        }
      }
    }

    List sortedUsers = new ArrayList();
    for (int index : indexes) {
      sortedUsers.add(users.get(index));
    }
    users = sortedUsers;
   }
  }
