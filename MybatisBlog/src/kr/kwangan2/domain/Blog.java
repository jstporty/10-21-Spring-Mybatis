package kr.kwangan2.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Blog {

	private int blogId;
	private int fkBlogAuthorId;
	private String blogName;
	private String blogTitle;
	private Author author;
	private List<Comm> comms;
	
	private Blog(Integer blogId) {
		this.blogId = blogId;
	}
}
