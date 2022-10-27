package kr.kwangan2.domain;

import java.io.Serializable;

import lombok.Data;
@Data
public class CommSearcher implements Serializable {
	
	private static final long serialVersionUID = 132432432L;
	
	int blogId;
	String searchkey;
	String searchValue;

}
