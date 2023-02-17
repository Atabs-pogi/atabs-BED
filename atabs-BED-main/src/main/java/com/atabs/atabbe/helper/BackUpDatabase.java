package com.atabs.atabbe.helper;

import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackUpDatabase {


    public static boolean restore(String dbUsername, String dbPassword, String dbName, String sourceFile)
            throws IOException, InterruptedException {
        System.out.println("Backup Started at " + new Date());

        Date backupDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String backupDateStr = format.format(backupDate);
        String dbNameList = "portal";

        String fileName = "Daily_DB_Backup"; // default file name
        String folderPath = "D:\\Users\\Matthew\\Documents\\demo\\backup";
        File f1 = new File(folderPath);
        f1.mkdir(); // create folder if not exist

        String saveFileName = fileName + "_" + backupDateStr + ".sql";
        String savePath = folderPath + File.separator + saveFileName;

        String[] command = new String[]{
                "C://Program Files//MySQL//MySQL Server 8.0/bin/mysqldump ",
                "-u" + dbUsername,
                " -p" + dbPassword,
                " --database " + dbName,
                " -r " + sourceFile
        };
        Process runtimeProcess = Runtime.getRuntime().exec(command);
        int processComplete = runtimeProcess.waitFor();
        System.out.println("Backup Started at " + processComplete);
        return processComplete == 0;
    }


    public static boolean backUp(String path,String username,String password,String dbname){
        Date backupDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String backupDateStr = format.format(backupDate);
        String fileName = "Daily_DB_Backup"; // default file name
        String folderPath = "C:\\Users\\Lester\\Documents\\demo\\backup";
        File f1 = new File(folderPath);
        f1.mkdir(); // create folder if not exist
        String saveFileName = fileName + "_" + backupDateStr + ".sql";
        String savePath = folderPath + File.separator + saveFileName;


        String executeCmd = "C://Program Files//MySQL//MySQL Server 8.0/bin/mysqldump -u" + username + " -p" + password
                + " --add-drop-database -B " + dbname + " -r " + path;
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            System.out.println(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            System.out.println("processComplete" + processComplete);
            if (processComplete == 0) {
                System.out.println("Backup created successfully");
                return true;

            } else {
                System.out.println("Could not create the backup");
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return false;
    }

}
