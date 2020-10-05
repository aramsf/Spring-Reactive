package es.arf.kairosds.blog.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import es.arf.kairosds.blog.entity.Post;
import reactor.core.publisher.Mono;

public interface PostRepository extends ReactiveMongoRepository<Post, Long> {

	Mono<Post> findById(Long id);
	
}
