package es.arf.kairosds.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.arf.kairosds.blog.dto.PostDTO;
import es.arf.kairosds.blog.entity.Post;
import es.arf.kairosds.blog.repository.PostRepository;
import es.arf.kairosds.blog.service.PostService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository repository;
	
	
	public Flux<PostDTO> getPosts() {
		return this.repository.findAll()
				.map(this::toDTO); 
	}
	
	public Mono<PostDTO> getPostById(String id) {
		return this.repository.findById(id)
				.map(this::toDTO);
	}
	
	public Mono<PostDTO> createPost(Mono<PostDTO> post) {
		return post
				.map(this::toDomain)
				.flatMap(repository::save)
				.map(this::toDTO);
	}
	
	public Mono<PostDTO> updatePost(String id, Mono<PostDTO> post) {
		return post
				.flatMap(p -> {
					return getPostById(id)
							.map(this::toDomain)
							.flatMap(postStored -> {
								postStored.setAuthor(p.getAuthor());
								postStored.setText(p.getText());
								postStored.setTitle(p.getTitle());
								return repository.save(postStored);
							});
				})
				.map(this::toDTO);
	}
	
	public Mono<PostDTO> deletePost(String id) {
		return getPostById(id)
				.flatMap(post -> 
					repository.deleteById(id).then(Mono.just(post)));
	}
	
	private PostDTO toDTO(Post p) {
		return new PostDTO(p.getId(), p.getAuthor(), p.getTitle(), p.getText());
	}
	
	private Post toDomain(PostDTO p) {
		return new Post(p.getId(), p.getAuthor(), p.getTitle(), p.getText());
	}
}
