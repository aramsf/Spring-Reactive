package es.arf.kairosds.blog.service;

import es.arf.kairosds.blog.dto.PostDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

	public Mono<PostDTO> createPost(Mono<PostDTO> post);
	
	public Flux<PostDTO> getPosts();
	
	public Mono<PostDTO> getPostById(Long id);
	
	public Mono<PostDTO> updatePost(Mono<PostDTO> post);
	
	public Mono<PostDTO> deletePost(Long id);
}
