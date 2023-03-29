package tw.taipei.gc.borrowing.usecase;

import java.util.List;
import java.util.Optional;

public interface IRepository<T extends DTO> {
    List<T> findAll();
    Optional<T> findByID(String ID);
    void create(T arg);
    void update(T arg);
    void remove(String ID);
}
