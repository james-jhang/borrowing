package tw.taipei.gc.borrowing.adapter.user.restfulapi.member.reserve;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.taipei.gc.borrowing.adapter.UseCaseFactory;
import tw.taipei.gc.borrowing.adapter.user.presenter.member.reserve.ReservationViewModel;
import tw.taipei.gc.borrowing.adapter.user.presenter.member.reserve.ReserveItemPresenter;
import tw.taipei.gc.borrowing.usecase.user.member.reserve.ReserveItemUseCase;
import tw.taipei.gc.borrowing.usecase.user.member.reserve.ReserveItemUseCaseInput;


// TODO use "users" instead of "members"
@RestController
@RequestMapping("/api/members")
public class ReserveItemController {

    private final ReserveItemUseCase reserveItemUseCase;

    public ReserveItemController() {
        this.reserveItemUseCase = UseCaseFactory.getInstance().ReserveItemUseCase();
    }

    @PostMapping("/reserve")
    public ResponseEntity<ReservationViewModel> reserve_item(@RequestBody ReservationRequest request) {
        ReserveItemUseCaseInput reserveItemUseCaseInput = new ReserveItemUseCaseInput();
        ReserveItemPresenter reserveItemPresenter = new ReserveItemPresenter();
        try {
            reserveItemUseCaseInput.setUserID(request.getUserID());
            reserveItemUseCaseInput.setItemID(request.getItemID());
            this.reserveItemUseCase.execute(reserveItemUseCaseInput, reserveItemPresenter);
            return ResponseEntity.ok().body(reserveItemPresenter.viewModel());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

class ReservationRequest {
    private String userID;
    private String itemID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
}
