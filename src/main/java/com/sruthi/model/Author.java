package com.sruthi.model;

public class Author{
	private int authorId;
	private String authorName;
	private String authorMailId;
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorMailId() {
		return authorMailId;
	}
	public void setAuthorMailId(String authorMailId) {
		this.authorMailId = authorMailId;
	}

	private long authorPhNo;
	public long getAuthorPhNo() {
		return authorPhNo;
	}
	public void setAuthorPhNo(long authorPhNo) {
		
			
		this.authorPhNo = authorPhNo;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public String toString() {
		return "Authors [authorId=" + authorId + ", authorName=" + authorName + ", authorMailId=" + authorMailId
				+ ", authorPhNo=" + authorPhNo + "]";
	}
	
}
