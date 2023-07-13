package kr.re.kitri.springpost.controller;

import kr.re.kitri.springpost.model.Post;
import kr.re.kitri.springpost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> viewAllPosts(){ // api에서는 자가객체인 list를 api의 표준 타입인 json으로 바꿔서 던져준다.
        // 자바객체는 json과 패러다임이 동일해서 스프링에내장되어 있는 converter(json parser 중의 하나인 잭슨 라이브러리)에 의해 변환된다.
        // 스프링부트가 jackson 라이브러리를 사용하도록 자동 설정,내장되어 있다.
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{postId}")
    public Post viewPostById(@PathVariable int postId){ // 경로변수를 가져와서 몇번째 글을 상세보기 할것인지를 정해줘야 함.
        // {postId}는 문자열인데 숫자로 자동변환해준다.
        return postService.getPostById(postId);
    }

    @DeleteMapping("/posts/{postId}")
    public void removePost(@PathVariable int postId){ // 경로변수를 가져와서 몇번째 글을 삭제할것인지를 정해줘야 함.
        // {postId}는 문자열인데 숫자로 자동변환해준다.
        postService.removePost(postId);
    }

    @PostMapping("/posts") // FE에서 BE로 json방식으로 데이터를 전달한다.
    public Post registPost(@RequestBody Post post){ // body에 담겨져있는 데이터를 받아와서 처리한다.
        System.out.println(post);
        return postService.setPost(post);
    }

    @PutMapping("/posts/{postId}")  // 전체 업데이트를 구현해보겠다. 업데이트할 내용은 요청바디에서 넘어온다
    public Post updatePost(@PathVariable int postId, @RequestBody Post post){
        return postService.updatePost(postId, post);
    }
}


