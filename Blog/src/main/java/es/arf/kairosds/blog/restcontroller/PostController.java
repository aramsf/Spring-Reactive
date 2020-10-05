package es.arf.kairosds.blog.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.arf.kairosds.blog.dto.PostDTO;
import es.arf.kairosds.blog.service.PostService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/blog/posts")
public class PostController {

	@Autowired
	private PostService service;

	@GetMapping("/")
	public Flux<PostDTO> getPosts() {
		return this.service.getPosts();
	}

	@GetMapping("/{idPost}")
	public Mono<PostDTO> getPost(@PathVariable String idPost) {
		return this.service.getPostById(idPost)
				.switchIfEmpty(
						Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with id " + idPost + " not found")));
	}

	@PostMapping("/")
	public Mono<PostDTO> createPost(@RequestBody Mono<PostDTO> post) {
		return this.service.createPost(post);
	}
	
	@PutMapping("/{idPost}")
	public Mono<PostDTO> updatePost(@PathVariable String idPost, @RequestBody Mono<PostDTO> post) {
		return this.service.updatePost(idPost, post)
				.switchIfEmpty(
						Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with id " + idPost + " not found")));
	}
	
	@DeleteMapping("/{idPost}")
	public Mono<PostDTO> deletePost(@PathVariable String idPost) {
		return this.service.deletePost(idPost)
				.switchIfEmpty(
						Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with id " + idPost + " not found")));
	}
}
