package io.huna.springboot.service;

        import io.huna.springboot.domain.posts.PostsRepository;
        import io.huna.springboot.web.dto.PostsSaveRequestDto;
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
}
