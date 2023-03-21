package tw.taipei.gc.borrowing.usecase.custodian.register;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.taipei.gc.borrowing.adapter.custodian.presenter.register.RegisterCustodianPresenter;
import tw.taipei.gc.borrowing.adapter.custodian.repository.InMemoryCustodianRepository;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianDTO;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterCustodianUseCaseTest {

    private CustodianRepository custodianRepository;
    private DomainEventBus eventBus;

    @BeforeEach
    public void given() {
        custodianRepository = new InMemoryCustodianRepository();
        eventBus = new DomainEventBus();
    }

    @Test
    public void register_a_custodian() {
        RegisterCustodianUseCase registerCustodianUseCase = new RegisterCustodianUseCase(custodianRepository, eventBus);
        RegisterCustodianUseCaseInput registerCustodianUseCaseInput = new RegisterCustodianUseCaseInput();
        RegisterCustodianUseCaseOutput registerCustodianUseCaseOutput = new RegisterCustodianPresenter();

        registerCustodianUseCaseInput.setName("James Jhang");
        registerCustodianUseCase.execute(registerCustodianUseCaseInput, registerCustodianUseCaseOutput);
        assertEquals("James Jhang", registerCustodianUseCaseOutput.getName());

        String custodianID = registerCustodianUseCaseOutput.getID();
        CustodianDTO custodianDTO = custodianRepository.findById(custodianID).get();
        assertEquals("James Jhang", custodianDTO.getName());
    }
}
