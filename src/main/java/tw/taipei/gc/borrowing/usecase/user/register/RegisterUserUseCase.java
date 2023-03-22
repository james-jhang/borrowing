package tw.taipei.gc.borrowing.usecase.user.register;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.user.User;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTOMapper;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;

public class RegisterUserUseCase extends UseCase<RegisterUserUseCaseInput, RegisterUserUseCaseOutput> {

    private final UserRepository userRepository;

    public RegisterUserUseCase(UserRepository userRepository, DomainEventBus eventBus) {
        super(eventBus);
        this.userRepository = userRepository;
    }

    @Override
    public void execute(RegisterUserUseCaseInput input, RegisterUserUseCaseOutput output) {
        User user = new User(input.getName());
        this.userRepository.save(UserDTOMapper.toDTO(user));
        output.setUserID(user.getID().toString());
        output.setName(user.getName());
    }
}
