package org.word_convertor.service;


import org.word_convertor.controller.api.PostsData;

import java.util.List;

/**
 * Class org.word_convertor.service.Corrector
 * author Igor Novikov
 * 10.09.24
 */

public class CorrectorService {

    public List<PostsData> handle(List<PostsData> posts) {
        posts.forEach(post -> {
            post.setTitle(post.getTitle().substring(0, 1).toUpperCase()
                    + post.getTitle().substring(1));
            String newBody = post.getBody().substring(0, 1).toUpperCase()
                    + post.getBody().substring(1);

            String removeNewString = newBody.replace("\n", "");

            post.setBody(removeNewString);
        });

        return posts;
    }

}
