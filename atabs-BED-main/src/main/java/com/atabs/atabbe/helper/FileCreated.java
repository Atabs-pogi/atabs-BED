package com.atabs.atabbe.helper;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileCreated {

    @Autowired
    ServletContext context;


    public static String dbPathFile(){
        Date backupDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String backupDateStr = format.format(backupDate);
        String fileName = "Database_Backup"; // default file name
        String folderPath = ".\\backup";
        File f1 = new File(folderPath);
        f1.mkdir(); // create folder if not exist
        String saveFileName = fileName + "_" + backupDateStr + ".sql";
        String savePath = folderPath + File.separator + saveFileName;

        return savePath;
    }


}
