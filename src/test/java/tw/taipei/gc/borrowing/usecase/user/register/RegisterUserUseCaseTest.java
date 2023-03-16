package tw.taipei.gc.borrowing.usecase.user.register;

import tw.taipei.gc.borrowing.adapter.user.presenter.register.RegisterUserPresenter;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;
import tw.taipei.gc.borrowing.adapter.user.repository.InMemoryUserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterUserUseCaseTest {
    private UserRepository userRepository;
    private DomainEventBus eventBus;

    @BeforeEach
    public void given() {
        userRepository = new InMemoryUserRepository();
        eventBus = new DomainEventBus();
    }

    @Test
    public void register_a_member_with_name() {
        RegisterUserUseCase registerUserUseCase = new RegisterUserUseCase(this.userRepository, this.eventBus);
        RegisterUserUseCaseInput registerUserUseCaseInput = new RegisterUserUseCaseInput();
        RegisterUserUseCaseOutput registerUserUseCaseOutput = new RegisterUserPresenter();

        registerUserUseCaseInput.setName("James");
        registerUserUseCase.execute(registerUserUseCaseInput, registerUserUseCaseOutput);
        assertEquals("James", registerUserUseCaseOutput.getName());
    }
}
