package tw.taipei.gc.borrowing.usecase.custodian.register;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.user.Custodian;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianDTOMapper;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianRepository;

public class RegisterCustodianUseCase extends UseCase<RegisterCustodianUseCaseInput, RegisterCustodianUseCaseOutput> {

    private final CustodianRepository custodianRepository;

    public RegisterCustodianUseCase(CustodianRepository custodianRepository, DomainEventBus domainEventBus) {
        super(domainEventBus);
        this.custodianRepository = custodianRepository;
    }

    @Override
    public void execute(RegisterCustodianUseCaseInput input, RegisterCustodianUseCaseOutput output) {
        Custodian custodian = new Custodian(input.getName());
        this.custodianRepository.create(CustodianDTOMapper.toDTO(custodian));
        output.setCustodianID(custodian.getID().toString());
        output.setName(custodian.getName());
    }
}
