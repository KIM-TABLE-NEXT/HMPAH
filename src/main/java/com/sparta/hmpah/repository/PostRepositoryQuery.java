package com.sparta.hmpah.repository;

import com.sparta.hmpah.entity.Post;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryQuery {
  /**
   * 게시글 조회 (사용자)
   * @param username 사용자 이름
   * @return 게시글 조회 결과
   */
  public List<Post> findByUsername(String username);
}
