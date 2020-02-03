package io.huna.springboot.service;

        import io.huna.springboot.domain.posts.Posts;
        import io.huna.springboot.domain.posts.PostsRepository;
        import io.huna.springboot.web.dto.PostsResponseDto;
        import io.huna.springboot.web.dto.PostsSaveRequestDto;
        import io.huna.springboot.web.dto.PostsUpdateRequestDto;
        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("%d is not found", id)));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("%d is not found", id)));

        return new PostsResponseDto(entity);
    }
}
