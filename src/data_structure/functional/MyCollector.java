package data_structure.functional;

import java.util.List;

/**
 * MyStream.collect(...)에서 사용할 수집 규칙입니다.
 */
@FunctionalInterface
public interface MyCollector<T, R> {
    R collect(List<T> values);
}
