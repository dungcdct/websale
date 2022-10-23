
package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.mindrot.jbcrypt.BCrypt;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import control.profile.updateAvatar;
import control.seller.addproduct;
import control.seller.removeProduct;
import entity.product;
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
			String checkaccount = "select a.username, a.password , u.fullname\r\n" + "from account a "
					+ "inner join users u on a.username =  u.username " + "where a.username = '" + username + "'\r\n";
			String fetchPass = "";
			try {
				ResultSet fetchAccount = stmt.executeQuery(checkaccount);
				while (fetchAccount.next()) {
					fetchPass = fetchAccount.getString("password").trim();

					if (BCrypt.checkpw(password.trim(), fetchPass)) {
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

			fetchInforUser = "select u.fullname, u.Addres , u.phone, u.email, a.name_image " + "from users u "
					+ "inner join avatar a on u.username = a.username " + "where u.username = '" + username + "'";

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
					+ "from users u\r\n" + "inner join avatar a on u.username = a.username\r\n"
					+ "inner join seller e on u.username = e.username\r\n" + "where u.username = '" + username + "'";
			try {
				ResultSet InforAccount = stmt.executeQuery(fetchInforUser);
				while (InforAccount.next()) {
					String fullname = InforAccount.getString("fullname");
					String address = InforAccount.getString("Addres");
					String phone = InforAccount.getString("phone");
					String email = InforAccount.getString("email");
					String nameImage = InforAccount.getString("name_image");
					String Idcard = InforAccount.getString("ID_Card");

					seller seller = new seller(username, fullname, address, phone, "seller", email, nameImage, Idcard);
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
		String updateAvatar = "UPDATE avatar\r\n" + "SET  name_image= '" + nameimage + "'\r\n" + "WHERE username='"
				+ username + "';";
		if (stmt != null) {
			try {
				int result = stmt.executeUpdate(updateAvatar);
				if (result > 0) {
					check = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return check;
	}

//	fetch id of user by username
	public static int takeIdByUsername(String username) {

		int IDseller = 0;
		Statement stmt = connectSqlServer();
		String fetchID = "select ID_Seller " + "from seller " + "where username = '" + username + "'";
		if (stmt != null) {
			try {
				ResultSet result = stmt.executeQuery(fetchID);
				if (result.next()) {
					IDseller = result.getInt("ID_Seller");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return IDseller;
	}

//	insert product to DB
	public static boolean addproduct(product product) {

		Statement stmt = connectSqlServer();
		String insertProduct = "insert into product values" + "(N'" + product.getNameproduct() + "',"
				+ product.getPrice() + ",N'" + product.getDescribe() + "','" + product.getNameimgOrVideo() + "',"
				+ product.getId_seller() + ") ";
		if (stmt != null) {
			try {
				int result = stmt.executeUpdate(insertProduct);
				if (result > 0) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public static int fetchIDmaxOfProduct() {
		int idmax = 0;
		Statement stmt = connectSqlServer();
		String fetchIDmax = "select  max(ID_product) maxID\r\n" + "from product";
		if (stmt != null) {
			try {
				ResultSet result = stmt.executeQuery(fetchIDmax);
				if (result.next()) {
					idmax = result.getInt("maxID");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return idmax;
	}

	public static List<product> loadProductInMain() {

		Statement stmt = connectSqlServer();
		String loadProduct = "SELECT top(27) * from product " + "ORDER BY newid()";
		if (stmt != null) {

			List<product> listProduct = new ArrayList<product>();

			try {
				ResultSet result = stmt.executeQuery(loadProduct);
				while (result.next()) {
					int id = result.getInt("ID_product");
					String name = result.getNString("name");
					int price = result.getInt("price");
					String describe = result.getString("describe");
					String nameimgorvideo = result.getString("nameImgOrVideo");
					int id_seller = result.getInt("ID_seller");

					product product = new product(id, name, price, describe, id_seller, nameimgorvideo);

					listProduct.add(product);

				}
				if (listProduct.size() > 0) {
					return listProduct;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<product> loadProductsBySeller(int idseller) {

		Statement stmt = connectSqlServer();
		String loadProduct = "select * from product\r\n" + "where ID_seller = " + idseller;
		if (stmt != null) {

			List<product> listProduct = new ArrayList<product>();

			try {
				ResultSet result = stmt.executeQuery(loadProduct);
				while (result.next()) {
					int id = result.getInt("ID_product");
					String name = result.getNString("name");
					int price = result.getInt("price");
					String describe = result.getString("describe");
					String nameimgorvideo = result.getString("nameImgOrVideo");
					int id_seller = result.getInt("ID_seller");

					product product = new product(id, name, price, describe, id_seller, nameimgorvideo);

					listProduct.add(product);

				}
				if (listProduct.size() > 0) {
					return listProduct;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static boolean removeProduct(int idproduct) {
		Statement stmt = connectSqlServer();
		String removeProduct = "DELETE FROM product WHERE ID_product = "+ idproduct;
		if (stmt != null) {
			try {
				int result = stmt.executeUpdate(removeProduct);
				
				if(result > 0) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static product Product(int idproduct) {
		
		Statement stmt = connectSqlServer();
		String Product = "select * from product where ID_product = "+ idproduct;
		if (stmt != null) {
			try {
				ResultSet result = stmt.executeQuery(Product);
				while (result.next()) {
					int id = result.getInt("ID_product");
					String name = result.getNString("name");
					int price = result.getInt("price");
					String describe = result.getString("describe");
					String nameimgorvideo = result.getString("nameImgOrVideo");
					int id_seller = result.getInt("ID_seller");

					product product = new product(id, name, price, describe, id_seller, nameimgorvideo);

					return product;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
