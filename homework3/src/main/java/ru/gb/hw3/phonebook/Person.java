package ru.gb.hw3.phonebook;

public class Person {
    private String surname;
    private String phone;
    private String email;
    private String normalSurname;

    public enum Field{
        PHONE
      , EMAIL
    }

    public Person(String surname, String phone, String email){
        this.surname = surname;
        this.phone = phone;
        this.email = email.toLowerCase();
        this.normalSurname = surname.toLowerCase();
    }

    public String getSurname(){
        return this.surname;
    }

    public String getKey(){
        return normalSurname;
    }

    public static String getKey(String surname){
        return surname.toLowerCase();
    }

    public String getPhone(){
        return this.phone;
    }

    public String getEmail(){
        return this.email;
    }

    public String getField(Field f){
        switch (f){
            case EMAIL: return this.email;
            case PHONE: return this.phone;
        }
        throw new RuntimeException();
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Person)) {
            return false;
        }
        if (o == this) {
            return true;
        }

        Person that = (Person) o;
        if(that.getKey().equals(this.getKey())  &&
           that.getPhone().equals(this.getPhone()) &&
           that.getEmail().equals(this.getEmail())){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode(){
        return (getKey() + getEmail() + getPhone()).hashCode();
    }
}
