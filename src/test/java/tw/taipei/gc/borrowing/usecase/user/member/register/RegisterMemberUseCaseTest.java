package tw.taipei.gc.borrowing.usecase.user.member.register;

import tw.taipei.gc.borrowing.adapter.user.presenter.register.RegisterMemberPresenter;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;
import tw.taipei.gc.borrowing.adapter.user.repository.InMemoryUserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterMemberUseCaseTest {
    private UserRepository userRepository;
    private DomainEventBus eventBus;

    @BeforeEach
    public void given() {
        userRepository = new InMemoryUserRepository();
        eventBus = new DomainEventBus();
    }

    @Test
    public void register_a_member_with_name() {
        RegisterMemberUseCase registerMemberUseCase = new RegisterMemberUseCase(this.userRepository, this.eventBus);
        RegisterMemberUseCaseInput registerMemberUseCaseInput = new RegisterMemberUseCaseInput();
        RegisterMemberUseCaseOutput registerMemberUseCaseOutput = new RegisterMemberPresenter();

        registerMemberUseCaseInput.setName("James");
        registerMemberUseCase.execute(registerMemberUseCaseInput, registerMemberUseCaseOutput);
        assertEquals("James", registerMemberUseCaseOutput.getName());
    }
}
