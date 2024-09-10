package org.word_convertor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.word_convertor.config.Config;
import org.word_convertor.controller.api.GetResponse;
import org.word_convertor.controller.api.PostsData;
import org.word_convertor.service.CorrectorService;
import org.word_convertor.service.OutService;

import java.io.IOException;
import java.util.List;

/**
 * Class org.word_convertor.Main
 * author Igor Novikov
 * 30.08.24
 */

public class Main {
    static GetResponse getResponse = new GetResponse();
    static ObjectMapper objectMapper = new ObjectMapper();
    static CorrectorService correctorService = new CorrectorService();
    static OutService outService = new OutService();

    public static void main(String[] args) throws IOException, InterruptedException {
        String jsonResponse = getResponse.getData(Config.API_GET_POSTS);
        List<PostsData> posts = objectMapper.readValue(jsonResponse, new TypeReference<>() {
        });
        List<PostsData> result = correctorService.handle(posts);
        System.out.println(outService.getOutString(result));
    }


}
