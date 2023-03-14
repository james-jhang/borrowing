package tw.taipei.gc.borrowing.usecase.user.member.register;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.user.Member;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTOMapper;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;

public class RegisterMemberUseCase extends UseCase<RegisterMemberUseCaseInput, RegisterMemberUseCaseOutput> {

    private UserRepository userRepository;

    public RegisterMemberUseCase(UserRepository userRepository, DomainEventBus eventBus) {
        super(eventBus);
        this.userRepository = userRepository;
    }

    @Override
    public void execute(RegisterMemberUseCaseInput input, RegisterMemberUseCaseOutput output) {
        Member member = new Member(input.getName());
        this.userRepository.save(UserDTOMapper.toDTO(member));
        output.setID(member.getID().toString());
        output.setName(member.getName());
    }
}
