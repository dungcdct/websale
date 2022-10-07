
package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import entity.user;

public class DAO {

	public DAO() {
	}

	public static void main(String[] args) {
		try {
			Statement a = connectSqlServer();
			System.out.println(a);
			System.out.println("succes");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Statement connectSqlServer() {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-R6Q5367\\SQLEXPRESS:1433;databaseName=websale";
			String username = "websale";
			String password = "dung11b4";
			Connection connect = DriverManager.getConnection(url, username, password);
			Statement stmt = connect.createStatement();
			return stmt;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean register(user user, String password, String IDcard) {
		boolean result = false;
		Statement stmt = connectSqlServer();
		if (stmt != null) {
			String account = "insert into account values('" + user.getUsername() + "', '" + password + "')";
			String users = "insert into users " + "values('" + user.getUsername() + "', N'" + user.getFullname()
					+ "', N'" + user.getAddress() + "', '" + user.getPhone() + "', '" + user.getCategory() + "', '"
					+ user.getEmail() + "', '" + user.getTimeCreate() + "')";

			try {
				int insertAccount = stmt.executeUpdate(account);
				if (insertAccount > 0) {

					int insertUsers = stmt.executeUpdate(users);
					if (insertUsers > 0) {
						System.out.println("complete register :  " + user.getUsername());
						result = true;
					} else {
						String deleteaccountWrong = "DELETE FROM account WHERE username = '" + user.getUsername()
								+ "';";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (user.getCategory().equals("seller")) {
				String seller = "insert into seller values ('" + user.getUsername() + "', '" + IDcard + "')";
				try {
					int insertSeller = stmt.executeUpdate(seller);
					result = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
// if infor account user input is speciry , fullname will return , otherwise null.
	public static String checkLog(String username, String password) {

		String fullname = null;
		Statement stmt = connectSqlServer();
		if (stmt != null) {
			String checkaccount = "select a.username, a.password , u.fullname\r\n"
					+ "from account a\r\n"
					+ "inner join users u on a.username =  u.username\r\n"
					+ "where a.username = '"+ username +"'\r\n"
					;
			String fetchPass = "";
			try {
				ResultSet fetchAccount = stmt.executeQuery(checkaccount);
				while (fetchAccount.next()) {
					fetchPass = fetchAccount.getString("password").trim();
					
					if(BCrypt.checkpw(password, fetchPass)) {
						fullname = fetchAccount.getString("fullname");
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fullname;
	}
}
