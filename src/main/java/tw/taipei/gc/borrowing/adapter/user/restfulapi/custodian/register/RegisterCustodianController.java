package tw.taipei.gc.borrowing.adapter.user.restfulapi.custodian.register;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.taipei.gc.borrowing.adapter.UseCaseFactory;
import tw.taipei.gc.borrowing.adapter.user.presenter.custodian.register.CustodianViewModel;
import tw.taipei.gc.borrowing.adapter.user.presenter.custodian.register.RegisterCustodianPresenter;
import tw.taipei.gc.borrowing.usecase.user.custodian.register.RegisterCustodianUseCase;
import tw.taipei.gc.borrowing.usecase.user.custodian.register.RegisterCustodianUseCaseInput;

@RestController
@RequestMapping("/api/custodians")
public class RegisterCustodianController {
    private final RegisterCustodianUseCase registerCustodianUseCase;

    public RegisterCustodianController() {
        this.registerCustodianUseCase = UseCaseFactory.getInstance().RegisterCustodianUseCase();
    }

    @PostMapping("/register")
    public ResponseEntity<CustodianViewModel> registerCustodian(@RequestBody CustodianRequest newCustodian) {
        RegisterCustodianUseCaseInput registerCustodianUseCaseInput = new RegisterCustodianUseCaseInput();
        RegisterCustodianPresenter registerCustodianPresenter = new RegisterCustodianPresenter();
        try {
            registerCustodianUseCaseInput.setName(newCustodian.getName());
            registerCustodianUseCase.execute(registerCustodianUseCaseInput, registerCustodianPresenter);
            return ResponseEntity.ok().body(registerCustodianPresenter.viewModel());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

class CustodianRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
