package TestUsers;

import java.util.List;
import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.UserDAO;
import com.sruthi.model.Users;

public class TestAddUsers {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception  {
	Users u = new Users();
	Scanner in = new Scanner(System.in);
	LOGGER.debug("Enter Username: ");
	u.setUserName(in.next());
	LOGGER.debug("Enter UserMail-Id: ");
	u.setUserMailId(in.next());
	LOGGER.debug("Enter Password: ");
	String password1 = in.next();
	 u.setSetPassword(password1);
	LOGGER.debug("Confirm Password: ");
	String password2 = in.next();
	u.setConfirmPassword(password2);
	if(password1.equals(password2)) {
		LOGGER.debug("Enter Phone-number: ");
		u.setPhNo(in.nextLong());
		UserDAO dao = DAOFactory.getUserDAO();
		dao.addUser(u);
	}
	else
		LOGGER.debug("Password Mismatch");
		
	
	
    
	
		
		
	}

}
