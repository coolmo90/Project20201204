package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("Hong", 80), new Student("Hwang", 90), new Student("Park", 87));
//		list.stream().filter(s-> s.getScore()/10 == 8)
//		.forEach(s -> System.out.println(s.getName()+ "," + s.getScore()));

		// 람다식으로
//		list.stream()
//		.filter(s-> s.getScore()/10 == 8)
//		.forEach(System.out::println);

		List<Student> student80s = list.stream().filter(s -> s.getScore() / 10 == 8).sorted()
				// 정렬한다 앞서고뒷선다라는 기준이있어야함
				.collect(Collectors.toList());
		// new 적고 뒤에도 다적어야하지만 구현돼잇는걸로
		for (Student student : student80s) {
			System.out.println("이름:" + student.getName() + "/ 점수 " + student.getScore());
		}
		Map<String, Integer> map = list.stream()
				.filter(s -> s.getScore() / 10 == 8).sorted()//
				.collect(//
				Collectors.toMap(//
								(t) -> t.getName(), //
								(t) -> t.getScore()//
						)//
				);
		Set<String> set = map.keySet();
		for (String key : set) {
			System.out.println("Key:" + key + ",Val: " + map.get(key));
		}
	}
}
