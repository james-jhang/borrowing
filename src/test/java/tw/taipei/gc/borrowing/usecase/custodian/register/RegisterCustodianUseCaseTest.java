package tw.taipei.gc.borrowing.usecase.custodian.register;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.taipei.gc.borrowing.adapter.custodian.presenter.register.RegisterCustodianPresenter;
import tw.taipei.gc.borrowing.adapter.user.repository.InMemoryUserRepository;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterCustodianUseCaseTest {

    private UserRepository userRepository;
    private DomainEventBus eventBus;

    @BeforeEach
    public void given() {
        userRepository = new InMemoryUserRepository();
        eventBus = new DomainEventBus();
    }

    @Test
    public void register_a_custodian() {
        RegisterCustodianUseCase registerCustodianUseCase = new RegisterCustodianUseCase(userRepository, eventBus);
        RegisterCustodianUseCaseInput registerCustodianUseCaseInput = new RegisterCustodianUseCaseInput();
        RegisterCustodianUseCaseOutput registerCustodianUseCaseOutput = new RegisterCustodianPresenter();

        registerCustodianUseCaseInput.setName("James Jhang");
        registerCustodianUseCase.execute(registerCustodianUseCaseInput, registerCustodianUseCaseOutput);
        assertEquals("James Jhang", registerCustodianUseCaseOutput.getName());

        String custodianID = registerCustodianUseCaseOutput.getID();
        UserDTO userDTO = userRepository.findById(custodianID).get();
        assertEquals("James Jhang", userDTO.getName());
    }
}
