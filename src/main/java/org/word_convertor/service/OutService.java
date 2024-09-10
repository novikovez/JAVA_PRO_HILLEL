package org.word_convertor.service;


import org.word_convertor.controller.api.PostsData;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class org.word_convertor.service.OutService
 * author Igor Novikov
 * 10.09.24
 */

public class OutService {
    public String getOutString(List<PostsData> post) {
        StringBuilder stringBuilder = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        post.forEach(postData -> {
            count.getAndIncrement();
            stringBuilder
                    .append(count.get())
                    .append(") ")
                    .append(postData.getTitle())
                    .append("\n")
                    .append(postData.getBody())
                    .append("\n");
        });
        return stringBuilder.toString();

    }
}
