package com.example.demospring1.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegexService {

    public List<String> findRegex(String regexValue, String testData) {
        Pattern pattern = Pattern.compile(regexValue);
        Matcher matcher = pattern.matcher(testData);

        List<String> list = new ArrayList<>();
        List<Integer> listStart = new ArrayList<>();
        List<Integer> listEnd = new ArrayList<>();
        while (matcher.find()) {
            listStart.add(matcher.start());
            listEnd.add(matcher.end());
        }

        for (int i = 0; i < listStart.size() - 1; i++) {
            int start = listStart.get(i);
            while (listEnd.get(i) == listStart.get(i + 1)) {
                i++;
                if (i == listStart.size() - 1) {
                    break;
                }
            }
            list.add(testData.substring(start, listEnd.get(i)));
        }
        return list;
    }
}
