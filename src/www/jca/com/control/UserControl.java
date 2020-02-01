package www.jca.com.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import www.jca.com.User;
import www.jca.com.db.DBConn;

public class UserControl implements DataInterface<User>{

	@Override
	public User selectOne(User param) {
		User user = new User();
		
		try(Connection conn = new DBConn().getConnection()){
			String sql = new StringBuilder().append("select * from users where id = ?").toString();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, param.getId());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int insert(User param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User param) {
		int result = 0;
		
		try (Connection connection = new DBConn().getConnection()){
			String sql = new StringBuilder().append("UPDATE users set")
					.append(" username =?, phone=? where id=?")
					.toString();
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, param.getUsername());
			pstmt.setString(2, param.getPhone());
			pstmt.setInt(3, param.getId());
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(User param) {
		int result = 0;
		
		try (Connection connection = new DBConn().getConnection()){
			String sql = new StringBuilder().append("DELETE FROM users where id=?")
					.toString();
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, param.getId());
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<User> selectList(User param) {
		// TODO Auto-generated method stub
		return null;
	}

}
