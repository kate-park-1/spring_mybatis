package kr.re.kitri.springpost.service;

import kr.re.kitri.springpost.model.Post;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostServiceTests {
    @Autowired
    private PostService postService;

    @Test
    public void testGetAllPosts() { // 이 메서드를 테스트하려면 성공인지 실패인지 시나리오를 작성해야한다.
        List<Post> allPosts = postService.getAllPosts();
        // 테스트 성공인지 실패인지에 해당하는 시나리오를 여기 적어준다. ==> 이런 걸 지원해주는 것이 assert 함수이다.
//        if(allPosts.size() >) {
//            // 성공
//        } else {
//            // 실패
//        }
        //Assertions.assertThat(allPosts.size()).isGreaterThan(0);
        Assertions.assertTrue(allPosts.size()> 0);
    }

    @Test
    public void testGetPostById() { // 이 메서드를 테스트하려면 성공인지 실패인지 시나리오를 작성해야한다.
        Post post = postService.getPostById(23323);
        // 테스트 성공인지 실패인지에 해당하는 시나리오를 여기 적어준다. ==> 이런 걸 지원해주는 것이 assert 함수이다.
        Assertions.assertNotNull(post);
    }
}