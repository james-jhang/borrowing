package tw.taipei.gc.borrowing.usecase.custodian.register;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.user.Custodian;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTOMapper;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;

public class RegisterCustodianUseCase extends UseCase<RegisterCustodianUseCaseInput, RegisterCustodianUseCaseOutput> {

    private final UserRepository userRepository;

    public RegisterCustodianUseCase(UserRepository userRepository, DomainEventBus domainEventBus) {
        super(domainEventBus);
        this.userRepository = userRepository;
    }

    @Override
    public void execute(RegisterCustodianUseCaseInput input, RegisterCustodianUseCaseOutput output) {
        Custodian custodian = new Custodian(input.getName());
        this.userRepository.save(UserDTOMapper.toDTO(custodian));
        output.setID(custodian.getID().toString());
        output.setName(custodian.getName());
    }
}
