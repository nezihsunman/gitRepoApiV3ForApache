package com.nezihsunman.utils;

import com.nezihsunman.resource.Repository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepoUtils {
    public static List<Repository> getMostFiveUser(JSONArray jsonArray) {
        List<Repository> repositoryList = new ArrayList<Repository>();
        List<Repository> tempRepository = (List<Repository>) jsonArray.stream()
                .map(item -> Repository.convert((JSONObject) item))
                .sorted(Comparator.comparing(Repository::getForksCount))
                .collect(Collectors.toList());
        int size = tempRepository.size();
        if (size >= 5) {
            for (int i = size - 1; i > (size - 6); i--) {
                repositoryList.add(tempRepository.get(i));
            }
        } else {
            throw new RuntimeException();
        }
        return repositoryList;
    }
}
