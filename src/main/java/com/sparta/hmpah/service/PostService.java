package com.sparta.hmpah.service;

import com.sparta.hmpah.dto.requestDto.PostRequest;
import com.sparta.hmpah.dto.responseDto.PostResponse;
import com.sparta.hmpah.entity.Post;
import com.sparta.hmpah.entity.User;
import java.util.List;

public interface PostService {
  /**
   * 게시글 조회 (옵션)
   * @param status 게시글 상태
   * @param location 게시글 위치
   * @param title 게시글 제목
   * @param user 게시글 조회 요청자
   * @return 게시글 조회 결과
   */
  public List<PostResponse> getPostListByOption(String status, String location, String title, User user);

  /**
   * 게시글 조회 (팔로워)
   * @param user 게시글 조회 요청자
   * @return 게시글 조회 결과
   */
  public List<PostResponse> getPostListByFollow(User user);

  /**
   * 게시글 조회 (참여중)
   * @param user 게시글 조회 요청자
   * @return 게시글 조회 결과
   */
  public List<PostResponse> getPostListByMember(User user);

  /**
   * 게시글 조회 (내가 쓴글)
   * @param user 게시글 조회 요청자
   * @return 게시글 조회 결과
   */
  public List<PostResponse> getMyPostList(User user);

  /**
   * 게시글 조회 (게시글 ID)
   * @Path postid 게시글 ID
   * @param user 게시글 조회 요청자
   * @return 게시글 조회 결과
   */
  public PostResponse getPostById(Long postid, User user);

  /**
   * 게시글 생성
   * @param postRequest 게시글 생성 요청정보
   * @param user 게시글 생성 요청자
   * @return 게시글 생성 결과
   */
  public PostResponse createPost(PostRequest postRequest, User user);

  /**
   * 게시글 수정
   * @param postid 게시글 ID
   * @param postRequest 게시글 수정 요청정보
   * @param user 게시글 수정 요청자
   * @return 게시글 수정 결과
   */
  public PostResponse updatePost(Long postid, PostRequest postRequest, User user);

  /**
   * 게시글 삭제
   * @param postid 게시글 ID
   * @param user 게시글 삭제 요청자
   * @return 게시글 삭제 결과
   */
  public String deletePost(Long postid, User user);

  /**
   * 게시글 좋아요
   * @param postid 게시글 ID
   * @param user 게시글 좋아요 요청자
   * @return 게시글 좋아요 결과
   */
  public String likePost(Long postid, User user);

  /**
   * 게시글 참여
   * @param postid 게시글 ID
   * @param user 게시글 참여 요청자
   * @return 게시글 참여 결과
   */
  public String joinPost(Long postid, User user);
}
