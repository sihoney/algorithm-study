package data_structure.functional;

@FunctionalInterface
public interface MyReducer<R, T> {
    R reduce(R acc, T value);
}
