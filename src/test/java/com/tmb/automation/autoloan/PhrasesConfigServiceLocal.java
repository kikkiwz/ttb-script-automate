package com.tmb.automation.autoloan;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmb.automation.common.PhrasesConfigService;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class PhrasesConfigServiceLocal implements PhrasesConfigService {

    private HashMap<String, PhraseItem> buffer = new HashMap<>();
    public PhrasesConfigServiceLocal() {
        init();

    }

    public void init(){
        String path = System.getProperty("user.dir") + "/testdata/" + "phrases_config.json";
        File myFile = new File(path);
        InputStream targetStream = null;
        try {
            targetStream = new FileInputStream(myFile);
            String content = readFile(targetStream);
            ObjectMapper objectMapper = new ObjectMapper();
            List<PhraseItem> phraseItems = objectMapper.readValue(content, new TypeReference<List<PhraseItem>>() {
            });
            for(PhraseItem item : phraseItems){
                buffer.put(item.getKey(), item);
            }
            System.out.println(phraseItems.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static String readFile(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + System.lineSeparator());
        }

        return sb.toString();
    }


    @Override
    public String getValueTh(String key) {
        PhraseItem item = buffer.get(key);
        return item.getTh();
    }

    @Override
    public String getValueEn(String key) {
        PhraseItem item = buffer.get(key);
        return item.getEn();
    }

    @Override
    public String getValue(String language , String key) {
        if("en".equalsIgnoreCase(language )) return getValueEn(key);
        return getValueTh(key);
    }
}

