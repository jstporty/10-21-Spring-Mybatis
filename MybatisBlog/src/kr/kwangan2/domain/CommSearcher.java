package kr.kwangan2.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class CommSearcher implements Serializable {

	private static final long serialVersionUID = 41561651L;

	int blogId;
	String searchKey;
	String searchValue;

}
