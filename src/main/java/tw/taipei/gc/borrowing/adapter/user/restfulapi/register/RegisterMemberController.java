package tw.taipei.gc.borrowing.adapter.user.restfulapi.register;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.taipei.gc.borrowing.adapter.UseCaseFactory;
import tw.taipei.gc.borrowing.adapter.user.presenter.register.MemberViewModel;
import tw.taipei.gc.borrowing.adapter.user.presenter.register.RegisterMemberPresenter;
import tw.taipei.gc.borrowing.usecase.user.member.register.RegisterMemberUseCase;
import tw.taipei.gc.borrowing.usecase.user.member.register.RegisterMemberUseCaseInput;

@RestController
@RequestMapping("/api/users")
public class RegisterMemberController {

    private final RegisterMemberUseCase registerMemberUseCase;

    public RegisterMemberController() {
        this.registerMemberUseCase = UseCaseFactory.getInstance().RegisterMemberUseCase();
    }

    @PostMapping("/register")
    public ResponseEntity<MemberViewModel> registerMember(@RequestBody MemberRequest newMember) {
        RegisterMemberUseCaseInput registerMemberUseCaseInput = new RegisterMemberUseCaseInput();
        RegisterMemberPresenter registerMemberPresenter = new RegisterMemberPresenter();
        try {
            registerMemberUseCaseInput.setName(newMember.getName());
            this.registerMemberUseCase.execute(registerMemberUseCaseInput, registerMemberPresenter);
            return ResponseEntity.ok().body(registerMemberPresenter.viewModel());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

class MemberRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
