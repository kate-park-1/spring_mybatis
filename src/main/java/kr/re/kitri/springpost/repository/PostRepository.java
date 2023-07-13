package kr.re.kitri.springpost.repository;

import kr.re.kitri.springpost.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Mapper
public interface PostRepository {
    // db 의존성 추가
    List<Post> selectAllPosts();
    Post selectPostById(int postId);
    void deletePost(int postId);
    void insertPost(Post post); // Post를 리턴하는 것은 sql방식이 아니므로 수정함
    void updatePost(Post post);
}
