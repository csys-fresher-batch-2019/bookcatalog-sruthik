package TestUsers;

import com.sruthi.DAOFactory;
import com.sruthi.dao.UserDAO;

public class TestDisplayUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        UserDAO dao = DAOFactory.getUserDAO();
        dao.displayUsers();
	}

}
