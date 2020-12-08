package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exam04 {
	
	private int english;
	private int math;
	private String name;
	
	public static void main(String[] args) {

		
		
		List<String> list = null;

		list = Arrays.asList("학생1", "학생2", "학생3");

		Stream<String> stream = list.stream();
		stream.filter((t) -> t.length() > 3
				).forEach((t) -> System.out.println(t));

		String[] strAry = { "학생1", "학생2", "학생3" };
		Stream<String> strStream = Arrays.stream(strAry);

		int[] intAry = { 75, 80, 85, 95, 65 };
		IntStream intStream = Arrays.stream(intAry);
		int sum = intStream.sum();
		System.out.println("합 " + sum);
	}

}