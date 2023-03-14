package tw.taipei.gc.borrowing.usecase.user.repository;

import tw.taipei.gc.borrowing.model.user.User;

public class UserDTOMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getID().toString(),
                user.getName()
        );
    }
}
