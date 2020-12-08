package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Exam05 {
	public static void main(String[] args) {

		Connection conn = DAO.getConnection();
		// 컬렉션추가
		List<EmployeeVO> list = new ArrayList<>();
		try {
			String sql = "select * from emp1";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDepartmentId(rs.getInt("department_id"));
				list.add(emp);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		Stream<EmployeeVO> stream = list.stream();
		stream.forEach(s -> s.showEmpInfo());

//	    40부서 사원		System.out.println("40부서 사원.>>>");
		OptionalDouble avg = list.stream()
				.filter(p -> p.getDepartmentId() == 40)
				.mapToInt((e) -> e.getSalary())
				.average();
		System.out.println("평균:" + avg.orElse(0.0));


	}
}
