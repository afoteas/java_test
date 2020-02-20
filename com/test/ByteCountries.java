package com.test;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;  

class ByteCountries extends TestFrame
{
    public ByteCountries(){

    } 

    @Override
    public void test(){
        System.out.println("Hello, World"); 
        List<byte[]> items = new ArrayList<>();
        items.add((new byte[]{(byte)71,(byte)82}));
        items.add(new byte[]{(byte)71,(byte)82});
        items.add(new byte[]{(byte)71,(byte)82});
   
        try {
            String countryDecoded = new String(items.get(0), "UTF-8");
            System.out.println(countryDecoded); 
            System.out.println(new String(items.get(0), "UTF-8"));
            System.out.println(new String(items.get(1), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        boolean result1 = items.stream().allMatch(s->s.equals(items.get(0)));
        boolean result2 = items.stream().allMatch(s->Arrays.equals(s,items.get(0)));
        boolean result3 = Arrays.equals( items.get(1), items.get(2));
        System.out.println(result1); 
        System.out.println(result2); 
        System.out.println(result3); 
    }
}

