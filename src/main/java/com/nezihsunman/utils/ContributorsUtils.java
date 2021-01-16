package com.nezihsunman.utils;

import com.nezihsunman.resource.Contributors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContributorsUtils {
    public static List<Contributors> getMostTenContributors(JSONArray jsonArray) {
        List<Contributors> repositoryList = new ArrayList<Contributors>();
        List<Contributors> tempRepository = (List<Contributors>) jsonArray.stream()
                .map(item -> Contributors.convert((JSONObject) item))
                .sorted(Comparator.comparing(Contributors::getContributions))
                .collect(Collectors.toList());
        int size = tempRepository.size();
        if (size >= 10) {
            for (int i = size - 1; i > (size - 11); i--) {
                repositoryList.add(tempRepository.get(i));
            }
        } else {
            throw new RuntimeException();
        }
        return repositoryList;
    }
}
