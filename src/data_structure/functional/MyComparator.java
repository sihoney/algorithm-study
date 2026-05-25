package data_structure.functional;

// @FunctionalInterface:
// 추상 메서드가 1개인 인터페이스라는 뜻이다.
// 추상 메서드가 1개이기 때문에 람다식으로 구현할 수 있다.
@FunctionalInterface
public interface MyComparator<T> {
    // 구현하지 않는 추상 메서드.
    // MyComparator<Integer> comp = (a, b) -> Integer.compare(a, b);
    // 위 람다식이 이 compare 메서드의 구현체가 된다.
    int compare(T a, T b);

    // 인터페이스여도 Java 8부터 static 메서드와 default 메서드를 구현할 수 있다.
    // static 메서드는 MyComparator.naturalInt()처럼 인터페이스 이름으로 호출한다.
    // default 메서드는 comparator.reversed()처럼 객체를 통해 호출한다.

    static MyComparator<Integer> naturalInt() {
        // 정답: return (a, b) -> Integer.compare(a, b);
        // a가 b보다 작으면 음수, 같으면 0, 크면 양수를 반환하므로 오름차순 기준이다.
        return (a, b) -> Integer.compare(a, b);
    }

    static MyComparator<Integer> reverseInt() {
        // 정답: return (a, b) -> Integer.compare(b, a);
        // 비교 순서를 b, a로 뒤집으면 큰 값이 앞에 오므로 내림차순 기준이다.
        return (a, b) -> Integer.compare(b, a);
    }

    static MyComparator<int[]> comparingIntArrayIndex(int index) {
        // 정답: return (a, b) -> Integer.compare(a[index], b[index]);
        // int[] 두 개를 받아서 각 배열의 index 위치 값을 기준으로 오름차순 비교한다.
        return (a, b) -> Integer.compare(a[index], b[index]);
    }

    default MyComparator<T> reversed() {
        // 정답: return (a, b) -> compare(b, a);
        // 현재 comparator의 비교 대상 순서를 반대로 넣어서 정렬 방향을 뒤집는다.
        return (a, b) -> this.compare(b, a);
    }

    default MyComparator<T> thenComparing(MyComparator<T> next) {
        // 정답:
        // return (a, b) -> {
        //     int result = compare(a, b);
        //     if (result != 0) return result;
        //     return next.compare(a, b);
        // };
        // 첫 번째 비교 결과가 0이 아니면 그 결과를 쓰고, 0이면 다음 comparator로 다시 비교한다.
        return (a, b) -> {
            int result = compare(a, b);
            if(result != 0) return result;
            return next.compare(a, b);
        };
    }
}
