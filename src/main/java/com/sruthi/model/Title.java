package com.sruthi.model;

import java.time.LocalDate;

public class Title {
private int titleId;
private int pubId;
private int subId;
private int authorId;
private LocalDate pubDate;
private String titleName;
private int versionNumber;
private int price;
public int getTitleId() {
	return titleId;
}
public void setTitleId(int titleId) {
	this.titleId = titleId;
}
public int getPubId() {
	return pubId;
}
public void setPubId(int pubId) {
	this.pubId = pubId;
}
public int getSubId() {
	return subId;
}
public void setSubId(int subId) {
	this.subId = subId;
}
public int getAuthorId() {
	return authorId;
}
public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
public LocalDate getPubDate() {
	return pubDate;
}
public void setPubDate(LocalDate pubDate) {
	this.pubDate = pubDate;
}
public String getTitle() {
	return titleName;
}
public void setTitle(String title) {
	this.titleName = title;
}
public int getVersionNumber() {
	return versionNumber;
}
public void setVersionNumber(int versionNumber) {
	this.versionNumber = versionNumber;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}


@Override
public String toString() {
	return "Title [titleId=" + titleId + ", pubId=" + pubId + ", subId=" + subId + ", authorId=" + authorId
			+ ", pubDate=" + pubDate + ", titleName=" + titleName + ", versionNumber=" + versionNumber + ", price=" + price
			+ "]";
}
}
