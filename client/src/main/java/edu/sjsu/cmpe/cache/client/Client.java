package edu.sjsu.cmpe.cache.client;

import com.mashape.unirest.http.Unirest;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Calling CRDT Client Server");
        CRDTClient crdtClient = new CRDTClient();
        System.out.println("Step 1: put 1->a");
        boolean result = crdtClient.put(1, "a");
        System.out.println("result is " + result);
        System.out.println("sleeping 30s. Stop a server");
        Thread.sleep(30*1000);
       
        System.out.println("Step 2: put 1->b");
        crdtClient.put(1, "b");
        System.out.println("sleeping 30s. Start the stopped server");
        Thread.sleep(30*1000);
        
        System.out.println("Step 3: get(1)");
        String value = crdtClient.get(1);
        System.out.println("get(1)" + value);

        System.out.println("Exiting Client...");
        Unirest.shutdown();

    }

}
