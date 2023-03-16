package tw.taipei.gc.borrowing.adapter.user.restfulapi.register;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.taipei.gc.borrowing.adapter.UseCaseFactory;
import tw.taipei.gc.borrowing.adapter.user.presenter.register.UserViewModel;
import tw.taipei.gc.borrowing.adapter.user.presenter.register.RegisterUserPresenter;
import tw.taipei.gc.borrowing.usecase.user.register.RegisterUserUseCase;
import tw.taipei.gc.borrowing.usecase.user.register.RegisterUserUseCaseInput;

@RestController
@RequestMapping("/api/users")
public class RegisterUserController {

    private final RegisterUserUseCase registerUserUseCase;

    public RegisterUserController() {
        this.registerUserUseCase = UseCaseFactory.getInstance().RegisterMemberUseCase();
    }

    @PostMapping("/register")
    public ResponseEntity<UserViewModel> registerMember(@RequestBody UserRequest request) {
        RegisterUserUseCaseInput registerUserUseCaseInput = new RegisterUserUseCaseInput();
        RegisterUserPresenter registerUserPresenter = new RegisterUserPresenter();
        try {
            registerUserUseCaseInput.setName(request.getName());
            this.registerUserUseCase.execute(registerUserUseCaseInput, registerUserPresenter);
            return ResponseEntity.ok().body(registerUserPresenter.viewModel());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

class UserRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
