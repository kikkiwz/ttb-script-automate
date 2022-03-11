package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.common.PhrasesConfigServiceMongoDb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CompareTPhrases {

    public static void main(String[] args) throws FileNotFoundException {
        File TPhrasesFile = new File("D:\\Autoloan\\AL Mapping T-Phrase Label Key and Value 1.csv");
        Scanner ReadFile = new Scanner(TPhrasesFile);
        ArrayList<String> keyNotFound = new ArrayList<>();
        PhrasesConfigServiceMongoDb phrasesConfigServiceMongoDb = new PhrasesConfigServiceMongoDb();

        while (ReadFile.hasNext()) {
            String data[] = ReadFile.nextLine().split(",");
            String key = data[0].trim();
            if (phrasesConfigServiceMongoDb.getValueEn(key) == null) {
                keyNotFound.add(key);
                continue;
            }
            phrasesConfigServiceMongoDb.getValueTh(key);
        }
        System.out.println("Key Not Found:....");
        for (String key : keyNotFound) {
            System.out.println(key);
        }


    }
}
