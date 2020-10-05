package es.arf.kairosds.blog.dto;

public class PostDTO {

	private Long id;
	private String author;
	private String title;
	private String text;

	public PostDTO() {

	}

	public PostDTO(Long id, String author, String title, String text) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
