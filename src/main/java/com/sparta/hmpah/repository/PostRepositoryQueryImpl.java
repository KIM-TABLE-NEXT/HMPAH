package com.sparta.hmpah.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.hmpah.entity.Post;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostRepositoryQueryImpl implements PostRepositoryQuery{

  private final EntityManager em;
  private final JPAQueryFactory queryFactory;

  public List<Post> findByUsername(String username) {
    return em.createQuery("select p from Post p where p.user.nickname = :username", Post.class)
        .setParameter("username", username)
        .getResultList();
  }

}
