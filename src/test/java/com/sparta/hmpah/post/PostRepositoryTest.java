package com.sparta.hmpah.post;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.sparta.hmpah.config.JpaConfig;
import com.sparta.hmpah.dto.requestDto.PostRequest;
import com.sparta.hmpah.dto.responseDto.PostResponse;
import com.sparta.hmpah.entity.Post;
import com.sparta.hmpah.entity.User;
import com.sparta.hmpah.entity.UserRoleEnum;
import com.sparta.hmpah.repository.PostRepository;
import com.sparta.hmpah.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(JpaConfig.class)
@Rollback(value = true)
public class PostRepositoryTest {

  @Autowired
  PostRepository postRepository;

  @Autowired
  UserRepository userRepository;

  @Test
  @DisplayName("유저 생성 테스트")
  void userInsertTest() {
    //given
    User user = new User();
    user.setId(100L);
    user.setPassword("knight314!");
    user.setEmail("tkdduq111@naver.com");
    user.setRole(UserRoleEnum.ADMIN);

    // when
    var savedUser = userRepository.save(user);

    // then
    assertThat(savedUser).isNotNull();
  }

  @Test
  @DisplayName("게시글 생성 테스트")
  void postInsertTest() {
    //given
    String title = "title";
    String content = "content";
    String location = "GANGNAM";
    Integer maxCount = 5;
    PostRequest postRequest = new PostRequest(title, content, location, maxCount);
    User user = userRepository.findById(1L).orElse(null);

    //when
    var savePost = postRepository.save(new Post(postRequest, user));

    //then
    assertThat(savePost).isNotNull();
  }

  @Test
  @DisplayName("게시글 수정 테스트")
  void postUpdateTest(){
    //given
    String title = "title";
    String content = "content";
    String location = "GANGNAM";
    Integer maxCount = 5;
    PostRequest postRequest = new PostRequest(title, content, location, maxCount);
    User user = userRepository.findById(1L).orElse(null);
    Post post = new Post(postRequest, user);
    postRepository.save(post);

    //when
    post.setTitle("new title");
    var savedPost = postRepository.save(post);

    //then
    assertEquals("new title",savedPost.getTitle());
  }
}
