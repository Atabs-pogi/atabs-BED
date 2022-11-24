package com.atabs.atabbe.service;

public class SalesService {


//    SAVE INFORMATION OF BUY(TOXIC DETAILS / FARMER DETAILS)
    public void transact(String[] items, long uuid, long farmer_id){
        try{
            //TODO: Connect to db
            //TODO: Execute Query then get transactionId
            // INSERT INTO Transaction(uuid, farmer_id) VALUES (:uuid, :farmer_id) // NEW TABLE
            //TODO: For each item in item, Execute Query below :)
            // INSERT INTO TransactionItem(transactionId, item_id, qty) VALUES (:transactionId ,:item,1) // NEW TABLE
        }catch(Exception e){

        }
    }
}
