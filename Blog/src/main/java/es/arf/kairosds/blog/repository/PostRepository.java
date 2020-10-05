package es.arf.kairosds.blog.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import es.arf.kairosds.blog.entity.Post;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {

}
