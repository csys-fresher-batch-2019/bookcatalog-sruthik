package com.sruthi.model;

 public class Publisher {
 private int pubId;
 private String pubName;
 private String pubMailId;
 public int getPubId() {
	return pubId;
}



public void setPubId(int pubId) {
	this.pubId = pubId;
}



public String getPubName() {
	return pubName;
}



public void setPubName(String pubName) {
	this.pubName = pubName;
}



public String getPubMailId() {
	return pubMailId;
}



public void setPubMailId(String pubMailId) {
	this.pubMailId = pubMailId;
}



private long pubPhNo;
 
 

public long getPubPhNo() {
	return pubPhNo;
}



public void setPubPhNo(long pubPhNo) {
	this.pubPhNo = pubPhNo;
}



@Override
public String toString() {
	return "Publishers [pubId=" + pubId + ", pubName=" + pubName + ", pubMailId=" + pubMailId + ", pubPhNo=" + pubPhNo
			+ "]";
}
}
