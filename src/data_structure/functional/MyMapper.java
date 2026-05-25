package data_structure.functional;

@FunctionalInterface
public interface MyMapper<T, R> {
    R map(T value);
}
