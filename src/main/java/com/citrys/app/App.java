package com.citrys.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        SimpleWebService service = new SimpleWebService(8880);
        service.startServer();
    }
}
