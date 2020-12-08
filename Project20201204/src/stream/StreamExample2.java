package stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		// 1 ~ 100
		// 짝수만 결과를 출력
		IntStream.rangeClosed(1, 100).filter(t -> t % 2 == 0).forEach(s -> System.out.println(s));

		int sum = IntStream.rangeClosed(1, 100).filter(t -> t % 2 == 0).sum();
		int[] intAry = { 2, 6, 4, 8, 1, 9 };
		IntStream is = Arrays.stream(intAry);
		int max = is.min().getAsInt();
		System.out.println(max);

		is = Arrays.stream(intAry);
		double avg = is.average().getAsDouble();
		System.out.println(avg);

		// 조건(filter)
		Arrays.stream(intAry).filter((a) -> a % 2 == 0).forEach((a) -> System.out.println(a));
	}
}
// Arrays.stream(intAry).filter(new IntPredicate() {

//
//			@Override
//			public boolean test(int a) {
//				return a % 2 == 0;
//			}
//		}).forEach(new IntConsumer() {
//
//			@Override
//			public void accept(int a) {
//				System.out.println(a);
//			}
//			
//		});
//			
//	}
//}

//		int[] intAry = { 2, 6, 4, 8, 1, 9 };
//		IntStream is = Arrays.stream(intAry);
//		OptionalInt max = is.max();
//		System.out.println(max);
//
//		int iMax = max.getAsInt();
//		System.out.println();	
//	}
//}