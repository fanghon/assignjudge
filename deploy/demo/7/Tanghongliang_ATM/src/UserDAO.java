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
		// ��ȡ����
		Connection conn = DB.getConnection();
		PreparedStatement pst = null;

		try {
			// ����SQL���
			String sql = "select * from atm where name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);

			// �α�������ȡ����
			rs = pst.executeQuery();

			// �ƶ��α굽��һ����¼���жϼ�¼�Ƿ���ڣ����ڷ���true
			while (rs.next()) { // �ƶ��α굽��һ����¼���жϼ�¼�Ƿ���ڣ����ڷ���true
				name = rs.getString("name"); // ���ݱ��ֶ����ƣ���ȡ��Ӧ���͵�����
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
			// ��ȡ����
			Connection conn = DB.getConnection();
			PreparedStatement pst = null;
			try {
				// ����SQL���
				String sql = "update atm set Yuer = ? where name = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(2, user.getName()); // ����name����
				pst.setInt(1, user.getYuer());

				// �α�������ȡ����
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
			// ��ȡ����
			Connection conn = DB.getConnection();
			PreparedStatement pst = null;
			try {
				// ����SQL���
				String sql = "update atm set Password = ? where name = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(2, user.getName()); // ����name����
				pst.setString(1, user.getPassword());

				// �α�������ȡ����
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
		// 1 ��ȡ����
		Connection conn = DB.gC();
		// 2 ���� sql��䣬��atm���в���һ���˺ţ�nj(name)\666666(password)\0(yuer)
		PreparedStatement pst = null;
		try {
			String sql = "insert into jilu(type,jine,shijian) values(?,?,?) ";// ?�ǲ���ռλ��
			pst = conn.prepareStatement(sql);
			pst.setString(1, t); // ����name����
			pst.setString(2, j);
			pst.setString(3, s);
			// 3 ִ�в���
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
		// ��ȡ����
		Connection conn = DB.gC();
		PreparedStatement pst = null;

		try {
			// ����SQL���
			String sql = "select * from jilu";
			pst = conn.prepareStatement(sql);

			// �α�������ȡ����
			rs = pst.executeQuery();

			// �ƶ��α굽��һ����¼���жϼ�¼�Ƿ���ڣ����ڷ���true
			while (rs.next()||i<20) { // �ƶ��α굽��һ����¼���жϼ�¼�Ƿ���ڣ����ڷ���true
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
		// 1 ��ȡ����
				Connection conn = DB.gC();
				// 2 ���� sql��䣬��atm���в���һ���˺ţ�nj(name)\666666(password)\0(yuer)
				PreparedStatement pst = null;
				try {
					String sql = "delete from jilu";// ?�ǲ���ռλ��
					pst = conn.prepareStatement(sql);
					// 3 ִ�в���
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
