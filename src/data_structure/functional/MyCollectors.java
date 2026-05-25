package data_structure.functional;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Java Collectors.toList(), Collectors.toSet() 같은 역할을 하는 유틸 클래스입니다.
 */
public class MyCollectors {
    private MyCollectors() {
    }

    public static <T> MyCollector<T, List<T>> toList() {
        return values -> new ArrayList<>(values);
    }

    public static <T> MyCollector<T, Set<T>> toSet() {
        return values -> new LinkedHashSet<>(values);
    }

    public static MyCollector<String, String> joining() {
        return values -> {
            StringBuilder sb = new StringBuilder();

            for(String value : values) {
                sb.append(value);
            }

            return sb.toString();
        };
    }

    public static MyCollector<String, String> joining(String delimiter) {
        return values -> {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < values.size(); i++) {
                if(i > 0) {
                    sb.append(delimiter);
                }
                sb.append(values.get(i));
            }

            return sb.toString();
        };
    }
}
