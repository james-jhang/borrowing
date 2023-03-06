package tw.taipei.gc.borrowing.usecase;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    List<T> findAll();
    Optional<T> findById(String id);
    Optional<T> findFirstByName(String name);
    Optional<T> save(T arg);
    boolean remove(T arg);
}
