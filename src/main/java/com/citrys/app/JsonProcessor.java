package com.citrys.app;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Staff {

    private String name;
    private int age;
    private String[] position;
    private Map<String, BigDecimal> salary;//  Array

    public Map<String, BigDecimal> getSalary() {
        return salary;
    }

    public void setSalary(Map<String, BigDecimal> salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getPosition() {
        return position;
    }

    public void setPosition(String[] position) {
        this.position = position;
    }
}


public class JsonProcessor {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        Staff staff = createStaff();

        try {


            // Java objects to JSON string - compact-print
            String jsonString = mapper.writeValueAsString(staff);

            System.out.println(jsonString);

            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);

            System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Staff createStaff() {

        Staff staff = new Staff();

        staff.setName("mkyong");
        staff.setAge(38);
        staff.setPosition(new String[]{"Founder", "CTO", "Writer"});
        HashMap salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);

        return staff;

    }

}