package ru.gb.hw3.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private HashMap<String, HashSet<Person>> book;

    public PhoneBook(){
        book = new HashMap<String, HashSet<Person>>();
    }

    public void add(Person person){
        HashSet<Person> currentList;
        if(book.containsKey(person.getKey())){
            currentList = book.get(person.getKey());
        } else {
            currentList = new HashSet<Person>();
            book.put(person.getKey(), currentList);
        }
        currentList.add(person);
    }

    private ArrayList<String> getList(String key, Person.Field fieldType){
        ArrayList<String> result = new ArrayList<String>();
        if(book.containsKey(key)){
            for(Person p:book.get(key)){
                result.add(p.getField(fieldType));
            }
        }
        return result;
    }

    public ArrayList<String> getPhones(String surname){
        return getList(Person.getKey(surname), Person.Field.PHONE);
    }

    public ArrayList<String> getEmails(String surname){
        return getList(Person.getKey(surname), Person.Field.EMAIL);
    }
}
