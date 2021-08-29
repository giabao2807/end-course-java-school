package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Course;
import connection.ConnectionProvider;

public class CourseDao {
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;

	public CourseDao() {
		connection = ConnectionProvider.getConnection();
	}
	public boolean saveCourse(Course course) {
		String query = "Insert into Course(Code,Name,Credit"+ "values (?,?,?)";
		try {
		pst = connection.prepareStatement(query);
		pst.setString(1, course.getCode());
		pst.setString(2, course.getName());
		pst.setInt(3, course.getCredit());
		pst.addBatch();
		return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean save(List<Course> list) {
		String query = "Insert into Course(Code,Name,Credit"+ "values (?,?,?)";
		try {
			pst = connection.prepareStatement(query);
			for (Course tg : list) {
				pst.setString(1, tg.getCode());
				pst.setString(2, tg.getName());
				pst.setInt(3, tg.getCredit());
				pst.addBatch();
			}
			int[] rs = pst.executeBatch();
			return count(rs)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public int getCourseByCode (String code) {
		String query ="select * from  Course  where Code = ?";
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, code);
			rs = pst.executeQuery();
			if(rs.next())
			{
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getCourseByName (String name) {
		String query ="select * from  Course  where Name = ?";
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if(rs.next())
			{
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	private static int count(int[] rs)
	{
		int count =0;
		for(int i : rs)
		{
			count +=i;
		}
		return count;
	}
	public List<Course> getAllCourse(){
		List<Course> courses = new ArrayList<>();
		String query = "SELECT * FROM db_Course.Course";
		try {
			st = connection.createStatement();
			rs = pst.executeQuery(query);
			while (rs.next()) {
				Course course = new Course(rs.getString("Code"), rs.getString("Name"), rs.getInt("Credit"));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return courses;
		
	}
}
