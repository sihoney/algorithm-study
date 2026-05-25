package data_structure.functional;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T value);
}
