package com.sparta.hmpah.repository;

import com.sparta.hmpah.entity.Post;
import com.sparta.hmpah.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Post.class, idClass = Long.class)
public interface PageableRepository extends JpaRepository<Post, Long> {
  Page<Post> findAllByUser(User user, Pageable pageable);
}
