package com.pluralsight;

public class NameFormatter {
    private final String firstName;
    private final String middleName;
    private String lastName;
    private String suffix;
    private String prefix;

    private NameFormatter(NameFormatter formatter) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public static String format(String firstName, String lastName){
        return firstName + lastName;
    }
    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix){
        return prefix + firstName + middleName + lastName + suffix;
    }
    public static String format(String fullName){
        String firstName, lastName, middleName, prefix, suffix;
        if(!firstName.equals(null) && !lastName.equals(null) ){
            if(prefix.equals(null) && !middleName.equals(null) && suffix.equals(null)){
                return firstName + middleName + lastName;
            }
            if(!prefix.equals(null) && middleName.equals(null) && suffix(null)){
                return prefix + firstName + lastName;
            }
            if()
        }else{
            System.out.println("Please enter first and last name.");
        }

        return firstName;
    }
}
