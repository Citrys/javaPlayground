package com.citrys.app.classesstudy;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class NestedTest {
    private ArrayList<Member> members = new ArrayList<>();

    class Member { // Member is an inner class of Network

        private String name;

        private ArrayList<Member> friends;


        Member(String name) {

            this.name = name;

            friends = new ArrayList<>();

        }

        private String getName() {
            return this.name;
        }

        private void delrivative() {
            members.remove(this);
        }

    }

    Member enroll(String name) {

        Member newMember = new Member(name);

        members.add(newMember);

        return newMember;

    }

    void getMembers(){
        members.forEach((v) -> System.out.println(v.getName()));
    }

}


class TestNested {
    public static void main(String[] args) {
        NestedTest test = new NestedTest();
        test.enroll("New Member");
        NestedTest.Member other = test.enroll("Second");
        test.getMembers();
        String s = "Hello World! 3 + 3 = 6 true ";

        // create a new scanner with the specified String Object
        Scanner scanner = new Scanner(s);

        // find the next int token and print it
        // loop for the whole scanner
        while (scanner.hasNext()) {
            scanner.nextInt();
            // if the next is a int, print found and the int
            if (scanner.hasNextInt()) {
                System.out.println("Found :" + scanner.nextInt());
            }
            // if no int is found, print "Not Found:" and the token
            System.out.println("Not Found :" + scanner.next());
        }

        // close the scanner
        scanner.close();
    }
}