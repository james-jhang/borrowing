package tw.taipei.gc.borrowing.adapter.user.repository;

import tw.taipei.gc.borrowing.usecase.user.repository.UserDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private final List<UserDTO> users;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public List<UserDTO> findAll() {
        return users;
    }

    @Override
    public Optional<UserDTO> findById(String id) {
        UserDTO target = null;
        for (UserDTO user : this.users) {
            if (user.getID().equals(id)) {
                target = user;
            }
        }
        return Optional.ofNullable(target);
    }

    @Override
    public Optional<UserDTO> findFirstByName(String name) {
        UserDTO target = null;
        for (UserDTO user : this.users) {
            if (user.getName().equals(name)) {
                target = user;
            }
        }
        return Optional.ofNullable(target);
    }

    @Override
    public Optional<UserDTO> save(UserDTO user) {
        this.users.add(user);
        // TODO the passed-in user cannot be null
        return Optional.ofNullable(user);
    }

    @Override
    public boolean remove(UserDTO user) {
        return users.remove(user);
    }
}
