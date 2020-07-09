package com.mindtree.newzz.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7965000859900886345L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 7, max = 60, message = "Title cannot be <7 or >60")
	@Column(length = 60)
	private String title;

	@Size(min = 10, max = 500, message = "Short description cannot be more than 500 characters or less than 10 characters")
	@Column(length = 500)
	private String shortDescription;

	@Size(min = 30, max = 10000, message = "Story length cannot be more than 10000 characters or less than 30 characters")
	@Column(length = 10000)
	private String story;

	@OneToOne
	@JsonIgnoreProperties(value = { "posts","comments" })
	private Editor editor;

	@NotNull
	private Date date;

	@ManyToMany
	private List<Tag> tags = new ArrayList<Tag>();

	@OneToMany(mappedBy = "post", targetEntity = Comment.class)
	@JsonIgnoreProperties(value = { "editor.posts","post.editor"})
	private List<Comment> comments = new ArrayList<Comment>();

	@Lob
	@Basic(fetch = FetchType.EAGER)
    private Byte[] image;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * @return the story
	 */
	public String getStory() {
		return story;
	}

	/**
	 * @param story the story to set
	 */
	public void setStory(String story) {
		this.story = story;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Post() {
		super();
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", shortDescription=" + shortDescription + ", story=" + story
				+ ", date=" + date + ", tags=" + tags + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id) && Objects.equals(title, other.title);
	}

	public Post(Long id, @Size(min = 7, max = 30, message = "Title cannot be <7 or >30") String title,
			@Size(min = 10, max = 100, message = "Short description cannot be more than 100 characters or less than 10 characters") String shortDescription,
			@Size(min = 30, max = 1000, message = "Story length cannot be more than 1000 characters or less than 30 characters") String story,
			Editor editor, Date date, List<Tag> tags, List<Comment> comments) {
		this.id = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.story = story;
		this.editor = editor;
		this.date = date;
		this.tags = tags;
		this.comments = comments;
	}

	/**
	 * @return the editor
	 */
	public Editor getEditor() {
		return editor;
	}

	/**
	 * @param editor the editor to set
	 */
	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	/**
	 * @return the image
	 */
	public Byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Byte[] image) {
		this.image = image;
	}

}
