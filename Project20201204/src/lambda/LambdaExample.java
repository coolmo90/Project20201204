package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList( //
				new Student("Hong", "MALE", 70), //
				new Student("Hwang", "FEMALE", 80), //
				new Student("Park", "MALE", 90), //
				new Student("Choi", "FEMALE", 85) //
		);

		// 1. 여학생정보 : 이름 - 점수
		System.out.println("1.여학생 정보");
		for (Student stu : list) {
			if (stu.getSex().equals("FEMALE")) {
				System.out.println(stu.getName() + "-" + stu.getScore());
			}
		}

		// 2. 전체학생 : 점수 80점 초과

		System.out.println("2. 80점 초과 전체학생");
		for (Student stu : list) {
			if (stu.getScore() > 80) {
				System.out.println(stu.getName() + "-" + stu.getScore());
			}
		}

		// 3. 남학생의 총점 : 160점;

		System.out.println("3. 남학생의 총점");
		int sum = 0;
		for (Student stu : list) {
			if (stu.getSex().equals("MALE")) {
				sum += stu.getScore();
			}
		}
		System.out.println(sum);
		// 4. 여학생의 평균 : 82.5점;
		System.out.println("4. 여학생의 평균");
		int sum2 = 0, count = 0;
		for (Student stu : list) {
			if (stu.getSex().equals("FEMALE")) {
				sum2 += stu.getScore();
				count++;
			}
		}
		System.out.println((double) sum2 / count);
		System.out.println("======================================");
		// 반복문 (반복자) : 스트림(반복자)

		// 스트림 생성 - > 소진
		Stream<Student> stream = list.stream();

//		stream.forEach(new Consumer<Student>() {
//			@Override
//			public boolean test(Student t) {
//				return t.getSex().equals("MALE");	
//			}); 밑에 람다식으로 변경

		stream.filter((t) -> t.getSex().equals("FEMALE"))
				.forEach((t) -> System.out.println(t.getName() + "-" + t.getScore()));

		stream = list.stream();
		stream.filter((t) -> t.getScore() > 80).forEach((t) -> System.out.println(t.getName() + t.getScore()));

		int sum1 = list.stream().filter(t -> t.getSex().equals("MALE")).mapToInt((value) -> value.getScore()).sum();

		System.out.println("합: " + sum1);
	}
}

//80점이상                  //람다식으로 바꾸기 전
//                @Override
//                public boolean test(Student t) {
//	            return t.getScore() > 80;
//                }
//
//                }).forEach(new Consumer<Student>() {
//
//                 @Override
//                 public void accept(Student t) {
//                System.out.println(t.getName() + t.getScore());
//                 }
//
//                 });
//                }
//                }

//