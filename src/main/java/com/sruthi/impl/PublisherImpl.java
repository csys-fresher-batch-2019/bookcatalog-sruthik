package com.sruthi.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sruthi.ConnectionUtil;
import com.sruthi.Logger;
import com.sruthi.dao.PublisherDAO;
import com.sruthi.model.Publisher;
public class PublisherImpl implements PublisherDAO {
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public void addPublisher(Publisher pub) throws Exception {
		String sql = "insert into publishers(pub_id,pub_name,pub_mail_id,pub_ph_no)values(pub_id_sq.nextval,?,?,?)";
		
		//step 1:Get the connection
		Connection connection = ConnectionUtil.getConnection();
		//step 2:Prepare the query
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, pub.getPubName());
		pst.setString(2, pub.getPubMailId());
		pst.setString(3, pub.getPubPhNo());
		
		//step 3:Execute the query
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows inserted:"+rows);
	}
	
	

	@Override
	public void updateMailIdAndPhNo(Publisher pub) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update publishers set pub_mail_id = ?,pub_ph_no = ? where pub_id = ?";
		Connection connection = ConnectionUtil.getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, pub.getPubMailId());
        pst.setString(2, pub.getPubPhNo());
		pst.setInt(3, pub.getPubId());
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows updated:"+rows);
	}
	

@Override
public void deletePublisher(int pubId) throws Exception {
	String sql = "Delete publishers where pub_id = ?";
	Connection connection = ConnectionUtil.getConnection();
	PreparedStatement pst = connection.prepareStatement(sql);
    pst.setInt(1, pubId);
    int rows = pst.executeUpdate();
	LOGGER.info("No of rows deleted:"+rows);
	
}



@Override
public List<Publisher> displayPubId() throws Exception {
	List<Publisher> list = new ArrayList<Publisher>();
	String sql = "select pub_id,pub_name,pub_mail_id,pub_ph_no from publishers";
	
	Connection connection = ConnectionUtil.getConnection();
	Statement stmt=connection.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    while(rs.next()) {
    	int pubId = rs.getInt("pub_id");
    	String pubName = rs.getString("pub_name");
    	String pubMailId = rs.getString("pub_mail_id");
    	String pubPhNo = rs.getString("pub_ph_no");
    	Publisher pub = new Publisher();
    	pub.setPubId(pubId);
    	pub.setPubName(pubName);
    	pub.setPubMailId(pubMailId);
    	pub.setPubPhNo(pubPhNo);
    	LOGGER.debug("Publisher-Id"+pubId+"Publisher Name : "+pubName+"\nPublisher Mail-id : "+pubMailId+"\nPublisher Ph-no : "+pubPhNo);
    	list.add(pub);
    }
    
	
	return list;
}

}