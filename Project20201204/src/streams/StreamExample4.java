package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample4 {
	
	private static String avg;
	
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
	





//1.	salary 10,000 이상인 사원.	
		System.out.println("salary가 10,000 이상인 사원.>>>");
		list.stream()
		.filter((t) -> t.getSalary() > 10000)		
		.forEach(s-> s.showEmpInfo());
		
		
		
//2.    선적부서 : 급여합계(평균)
//		employee -> mopToInt
		System.out.println("선적부서 사원");
		list.stream()
		.filter(p->p.getDepartmentId() == 50)
		.mapToInt((e) -> e.getSalary())
		.average().getAsDouble();
		System.out.println("급여평균 :" + avg);
		
		list.stream()
		.filter((t) -> t.getSalary() < 10000)
		.forEach(s -> s.showEmpInfo());
//3.	급여(5000~10000)
//		사원번호, 이름, 메일, 급여
		System.out.println("salary가 5000~10000인 사원");
		list.stream()
		.filter((t) -> t.getSalary() > 5000)	
		.forEach(s-> s.showEmpInfo());
	

	}
}