package io.huna.springboot.web.dto;

import io.huna.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsUpdateDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsUpdateDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
