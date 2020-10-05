package es.arf.kairosds.blog.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import es.arf.kairosds.blog.dto.PostDTO;
import es.arf.kairosds.blog.service.PostService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/blog/post")
public class PostController {

	@Autowired
	private PostService service;

	@GetMapping("/")
	public Flux<PostDTO> getPosts() {
		return this.service.getPosts();
	}

	@GetMapping("/{idPost}")
	public Mono<PostDTO> getPost(@PathVariable Long idPost) {
		return this.service.getPostById(idPost);
	}

	@PostMapping("/")
	public Mono<PostDTO> createPost(@RequestBody Mono<PostDTO> post) {
		return this.service.createPost(post);
	}
	
	@PutMapping("/{idPost}")
	public Mono<PostDTO> updatePost(@RequestBody Mono<PostDTO> post) {
		return this.service.updatePost(post);
	}
	
	@DeleteMapping("/{idPost}")
	public Mono<PostDTO> deletePost(@PathVariable Long idPost) {
		return this.service.deletePost(idPost);
	}
}
