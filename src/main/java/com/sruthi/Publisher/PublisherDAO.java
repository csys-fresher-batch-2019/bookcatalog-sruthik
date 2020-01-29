package com.sruthi.Publisher;

import java.util.List;

public interface PublisherDAO {
	void addPublisher(Publisher pub) throws Exception;
	List<Publisher> displayPubId() throws Exception;
	void updateMailIdAndPhNo(Publisher pub) throws Exception;
	void deletePublisher(int pubId) throws Exception;
}
