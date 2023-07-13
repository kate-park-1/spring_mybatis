package kr.re.kitri.springpost.repository;

import kr.re.kitri.springpost.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class PostRepository_beforeeee {
    List<Post> posts = new ArrayList<>();
    // db 의존성 추가
    public List<Post> selectAllPosts() {// 자바에서는 generic 타입으로 array 가 아닌 list를 사용한다.

        posts.add(new Post(1,"제목1", "내용1", 0));
        posts.add(new Post(2,"제목2", "내용2", 10));
        posts.add(new Post(3,"제목3", "내용3", 20));
        return posts;
    }

    public Post selectPostById(long postId) {
        return null;
    }

    public String deletePost(long postId) {
        // db에서 postid의 글을 삭제한다.
        return "삭제되었습니다.";
    }

    public Post insertPost(Post post) {
        // db에서 post 데이터를 insert 한다.
        return post;
    }
}
