package com.sruthi.dao;

import java.util.List;

import com.sruthi.model.Publisher;

public interface PublisherDAO {
	void addPublisher(Publisher pub) ;
	List<Publisher> displayPubId() ;
	void updateMailIdAndPhNo(Publisher pub) ;
	void deletePublisher(int pubId) ;
}
