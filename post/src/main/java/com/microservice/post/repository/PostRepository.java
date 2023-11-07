package com.microservice.post.repository;

import com.microservice.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//  CrudRepository doesnt support pagination and JpaRepository supports pagination    //
public interface PostRepository extends JpaRepository<Post, String> {

}
