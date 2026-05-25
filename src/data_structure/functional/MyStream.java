package data_structure.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MyStream<T> {
    private final List<T> values;

    private MyStream(List<T> values) {
        this.values = values;
    }

    public static <T> MyStream<T> of(List<T> values) {
        return new MyStream<>(new ArrayList<>(values));
    }

    public MyStream<T> filter(MyPredicate<T> predicate) {
        // TODO: predicate를 통과한 값만 담은 새 MyStream 반환
        List<T> filtered = new ArrayList<>();

        for(T item : this.values) {
            if(predicate.test(item)) {
                filtered.add(item);
            }
        }

        return MyStream.of(filtered);
        // throw new UnsupportedOperationException();
    }

    public <R> MyStream<R> map(MyMapper<T, R> mapper) {
        // TODO: mapper로 변환한 값들을 담은 새 MyStream 반환
        List<R> mapped = new ArrayList<>();

        for(T item : this.values) {
            mapped.add(mapper.map(item));
        }

        return MyStream.of(mapped);
        // throw new UnsupportedOperationException();
    }

    public MyStream<T> sorted(MyComparator<T> comparator) {
        // TODO: 정렬된 새 MyStream 반환
        List<T> copied = toList();

        MyCollections.sort(copied, comparator);

        return MyStream.of(copied);
        // throw new UnsupportedOperationException();
    }

    public List<T> toList() {
        // TODO: 내부 값을 복사해서 반환
        List<T> copied = new ArrayList<>();

        for(T item : values) {
            copied.add(item);
        }

        return copied;
        // throw new UnsupportedOperationException();
    }

    public <R> R collect(MyCollector<T, R> collector) {
        // TODO: collector에게 내부 값을 넘겨 최종 결과를 반환
        return collector.collect(new ArrayList<>(values)); // 안전하게 복사
        // throw new UnsupportedOperationException();
    }

    public <R> R reduce(R initialValue, MyReducer<R, T> reducer) {
        // TODO: initialValue부터 시작해서 values를 하나의 결과로 누적

        for(T value : values) {
            initialValue = reducer.reduce(initialValue, value);
        }

        return initialValue;
        // throw new UnsupportedOperationException();
    }

    public int count() {
        // TODO: values의 개수를 반환
        return values.size();
        // throw new UnsupportedOperationException();
    }

    public boolean anyMatch(MyPredicate<T> predicate) {
        // TODO: predicate를 통과하는 값이 하나라도 있으면 true 반환
        for(T value : values) {
            if(predicate.test(value)) {
                return true;
            }
        }
        return false;
        // throw new UnsupportedOperationException();
    }

    public boolean allMatch(MyPredicate<T> predicate) {
        // TODO: 모든 값이 predicate를 통과하면 true 반환
        for(T value : values) {
            if(!predicate.test(value)) {
                return false;
            }
        }

        return true;
        // throw new UnsupportedOperationException();
    }

    public boolean noneMatch(MyPredicate<T> predicate) {
        // TODO: predicate를 통과하는 값이 하나도 없으면 true 반환
        for(T value : values) {
            if(predicate.test(value)) {
                return false;
            }
        }

        return true;
        // throw new UnsupportedOperationException();
    }

    public T findFirst() {
        // TODO: 첫 번째 값을 반환. 값이 없으면 NoSuchElementException 발생
        if(values.isEmpty()) {
            throw new NoSuchElementException();
        }

        return values.get(0);
        // throw new UnsupportedOperationException();
    }
}
