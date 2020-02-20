package com.test;

class EncryTest extends TestFrame
{
    private static final String ENCRYPTION_PREFIX = "encrypted_";

    public EncryTest(){

    } 

    @Override
    public void test(){
        System.out.println("Hello, World"); 

        String unencrypted = "poutses";
        String encrypted = ENCRYPTION_PREFIX.concat(null);

        System.out.println("result: " + encrypted.substring(ENCRYPTION_PREFIX.length())); 
    }

}