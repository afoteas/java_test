package com.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MainMenu
{ 
     public static void main(String args[]) 
    { 
        Scanner in = new Scanner(System.in);
        System.out.println("Testing Framework");

        List<TestFrame> listOfTests = new ArrayList<TestFrame>();
        listOfTests.add(new ByteCountries());
        listOfTests.add(new DummyTest());
        listOfTests.add(new EncryTest());
        listOfTests.add(new CallableInterrupt());
        listOfTests.add(new PredicateTest());

        boolean quit = false;

        int menuItem;

        do {

              for(int i=1;i<listOfTests.size()+1;i++){
                System.out.println("TEST("+i+"): "+ listOfTests.get(i-1).getClass().getSimpleName());
              }
              System.out.println("EXIT(0)");

              menuItem = in.nextInt();


              if(menuItem<=listOfTests.size() && menuItem != 0){
                listOfTests.get(menuItem-1).test();
              }
              else if (menuItem == 0){
                  quit = true;
              }
              else{
                System.out.println("wrong choice!! try again");
              }

            

        } while (!quit);

        in.close();
        System.out.println("Bye-bye!");




    } 
} 