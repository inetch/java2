package ru.gb.hw3;

import ru.gb.hw3.phonebook.Person;
import ru.gb.hw3.phonebook.PhoneBook;

import java.util.HashMap;

public class MainClass {
    private static void printPhones(PhoneBook book, String surname){
        System.out.println(surname + ": " + book.getPhones(surname));
    }

    public static void main(String[] args) {
        String[] text = {"раз", "два", "три", "четыре", "тридцать", "семь", "сто", "раз", "двадцать", "восемь", "двадцать",
                "четыре", "восемнадцать", "сто", "шесть", "два", "ноль", "восемнадцать", "девятнадцать", "сорок", "тридцать",
                "пять", "сто", "шесть", "два"};

        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String s:text){
            if(dict.containsKey(s)){
                dict.put(s, dict.get(s) + 1);
            } else {
                dict.put(s, 1);
            }
        }

        System.out.println(dict);

        PhoneBook yellowBook = new PhoneBook();
        yellowBook.add(new Person("пеТров", "3328", "petrov@gmail.com"));
        yellowBook.add(new Person("Сидоров", "1345", "sidorov@mail.ru"));
        yellowBook.add(new Person("Петров", "7809", "poopsik1990@mail.ru"));
        yellowBook.add(new Person("Gates", "0987", "the_billy@outlook.com"));
        yellowBook.add(new Person("сидоров", "1345", "sidoROv@mail.ru"));

        printPhones(yellowBook, "сидоров");
        printPhones(yellowBook, "морозов");
        printPhones(yellowBook, "петров");
    }

}
