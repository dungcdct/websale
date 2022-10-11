
package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import control.profile.updateAvatar;
import entity.seller;
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
			String avatar = "insert into avatar values('" + user.getUsername() + "','avatardefault.jpg')";
			try {
				int insertAccount = stmt.executeUpdate(account);
				if (insertAccount > 0) {

					int insertUsers = stmt.executeUpdate(users);
					stmt.executeUpdate(avatar);
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
			String checkaccount = "select a.username, a.password , u.fullname\r\n" + "from account a\r\n"
					+ "inner join users u on a.username =  u.username\r\n" + "where a.username = '" + username
					+ "'\r\n";
			String fetchPass = "";
			try {
				ResultSet fetchAccount = stmt.executeQuery(checkaccount);
				while (fetchAccount.next()) {
					fetchPass = fetchAccount.getString("password").trim();

					if (BCrypt.checkpw(password, fetchPass)) {
						fullname = fetchAccount.getString("fullname");
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fullname;
	}

	public static user fetchAllInforUser(String username) {

		String fetchInforUser;
		Statement stmt = connectSqlServer();
		if (stmt != null) {
			
				fetchInforUser = "select u.fullname, u.Addres , u.phone, u.email, a.name_image "
						+ "from users u "
						+ "inner join avatar a on u.username = a.username "
						+ "where u.username = '"+ username +"'";
			
			try {
				ResultSet InforAccount = stmt.executeQuery(fetchInforUser);
				while (InforAccount.next()) {
					String fullname = InforAccount.getString("fullname");
					String address = InforAccount.getString("Addres");
					String phone = InforAccount.getString("phone");
					String email = InforAccount.getString("email");
					String nameImage = InforAccount.getString("name_image");
					user user = new user(username, fullname, address, phone, "user", email, nameImage);
					return user;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static seller fetchAllInforSeller(String username) {

		String fetchInforUser;
		Statement stmt = connectSqlServer();
		if (stmt != null) {
				fetchInforUser = "select u.fullname, u.Addres , u.phone, u.email,e.ID_Card , a.name_image\r\n"
						+ "from users u\r\n"
						+ "inner join avatar a on u.username = a.username\r\n"
						+ "inner join seller e on u.username = e.username\r\n"
						+ "where u.username = '" + username + "'";
			try {
				ResultSet InforAccount = stmt.executeQuery(fetchInforUser);
				while (InforAccount.next()) {
					String fullname = InforAccount.getString("fullname");
					String address = InforAccount.getString("Addres");
					String phone = InforAccount.getString("phone");
					String email = InforAccount.getString("email");
					String nameImage = InforAccount.getString("name_image");
					String Idcard = InforAccount.getString("ID_Card");
					
					seller seller = new seller(username, fullname, address, phone, "seller" , email, nameImage ,Idcard);
					return seller;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static boolean updateAvatar(String username, String nameimage) {
		
		boolean check = false;
		Statement stmt = connectSqlServer();
		String updateAvatar ="UPDATE avatar\r\n"
				+ "SET  name_image= '"+ nameimage +"'\r\n"
				+ "WHERE username='"+ username +"';";
		if (stmt != null) {
			try {
				int result = stmt.executeUpdate(updateAvatar);
				if(result > 0) {
					check = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return check;
	}
}
