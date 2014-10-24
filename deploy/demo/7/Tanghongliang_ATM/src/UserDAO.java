import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextPane;

public class UserDAO {
	/**
	 * @param args
	 */
	User getUser(String name) {
		User user = null;
		ResultSet rs = null;
		// 获取链接
		Connection conn = DB.getConnection();
		PreparedStatement pst = null;

		try {
			// 构建SQL语句
			String sql = "select * from atm where name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);

			// 游标逐条读取数据
			rs = pst.executeQuery();

			// 移动游标到下一条记录，判断记录是否存在，存在返回true
			while (rs.next()) { // 移动游标到下一条记录，判断记录是否存在，存在返回true
				name = rs.getString("name"); // 根据表字段名称，读取相应类型的数据
				String password = rs.getString("password");
				int yuer = rs.getInt("yuer");
				user = new User();
				user.setName(name);
				user.setPassword(password);
				user.setYuer(yuer);
				// System.out.println(name + "," + password + "," + yuer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(rs, pst, conn);
		}
		return user;
	}

	void updateUser(User user) {
		if (user != null) {
			int rs = 0;
			// 获取链接
			Connection conn = DB.getConnection();
			PreparedStatement pst = null;
			try {
				// 构建SQL语句
				String sql = "update atm set Yuer = ? where name = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(2, user.getName()); // 设置name参数
				pst.setInt(1, user.getYuer());

				// 游标逐条读取数据
				rs = pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DB.close(null, pst, conn);
			}
		}
	}

	void updateUserMima(User user) {
		if (user != null) {
			int rs = 0;
			// 获取链接
			Connection conn = DB.getConnection();
			PreparedStatement pst = null;
			try {
				// 构建SQL语句
				String sql = "update atm set Password = ? where name = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(2, user.getName()); // 设置name参数
				pst.setString(1, user.getPassword());

				// 游标逐条读取数据
				rs = pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DB.close(null, pst, conn);
			}
		}
	}

	//
	//
	//
	void insertjilu(String t, String j, String s) {
		// 1 获取连接
		Connection conn = DB.gC();
		// 2 构建 sql语句，在atm表中插入一个账号：nj(name)\666666(password)\0(yuer)
		PreparedStatement pst = null;
		try {
			String sql = "insert into jilu(type,jine,shijian) values(?,?,?) ";// ?是参数占位符
			pst = conn.prepareStatement(sql);
			pst.setString(1, t); // 设置name参数
			pst.setString(2, j);
			pst.setString(3, s);
			// 3 执行插入
			int res = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(null, pst, conn);
		}
	} // if

	String[][] xianshi() {
		ResultSet rs = null;
		String[][] str = new String[20][3];
		for(int k =0;k<20;k++){
			for(int j =0; j<3;j++)
			str[k][j]="";
		}
		int i = 0;
		// 获取链接
		Connection conn = DB.gC();
		PreparedStatement pst = null;

		try {
			// 构建SQL语句
			String sql = "select * from jilu";
			pst = conn.prepareStatement(sql);

			// 游标逐条读取数据
			rs = pst.executeQuery();

			// 移动游标到下一条记录，判断记录是否存在，存在返回true
			while (rs.next()||i<20) { // 移动游标到下一条记录，判断记录是否存在，存在返回true
				str[i][0]=rs.getString("type");;
				str[i][1]=rs.getString("jine");
				str[i][2]=rs.getString("shijian");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			DB.close(rs, pst, conn);
		}
		return str;
	}

	void delete(){
		// 1 获取连接
				Connection conn = DB.gC();
				// 2 构建 sql语句，在atm表中插入一个账号：nj(name)\666666(password)\0(yuer)
				PreparedStatement pst = null;
				try {
					String sql = "delete from jilu";// ?是参数占位符
					pst = conn.prepareStatement(sql);
					// 3 执行插入
					int res = pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DB.close(null, pst, conn);
				}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO udo = new UserDAO();
		udo.delete();
	}
}
