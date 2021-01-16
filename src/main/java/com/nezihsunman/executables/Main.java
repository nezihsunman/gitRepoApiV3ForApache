package com.nezihsunman.executables;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import com.nezihsunman.HttpRequest.HttpRequest;
import com.nezihsunman.Apis.APIs;
import com.nezihsunman.resource.Contributor;
import com.nezihsunman.resource.Contributors;
import com.nezihsunman.resource.Repository;
import com.nezihsunman.utils.ContributorsUtils;
import com.nezihsunman.utils.JsonParserUtils;
import com.nezihsunman.utils.RepoUtils;
import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        FileWriter fileWriter = new FileWriter("text.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        InputStream inputStream = HttpRequest.sendHttpRequest(APIs.GET_URL);
        List<Repository> mostFiveRepo = RepoUtils.getMostFiveUser(JsonParserUtils.inputStreamToJsonArray(inputStream));
        for (int i = 0; i < mostFiveRepo.size(); i++) {
            String format = mostFiveRepo.get(i).toString();
            InputStream repoContributors = HttpRequest.sendHttpRequest(APIs.generateUrlForContributors(mostFiveRepo.get(i).getRepoName()));
            List<Contributors> topTenContributors = ContributorsUtils.getMostTenContributors(JsonParserUtils.inputStreamToJsonArray(repoContributors));
            for (int j = 0; j < topTenContributors.size(); j++) {
                InputStream contributor = HttpRequest.sendHttpRequest(APIs.generateUrlForUserName(topTenContributors.get(j).getLoginName()));
                String finalUser = format + Contributor.convert(JsonParserUtils.inputStreamToJsonObject(contributor)).toString() + " contribution: " + topTenContributors.get(j).getContributions();
                printWriter.println(finalUser);
            }
            printWriter.println("-----");
        }
        printWriter.close();
    }

}
