package tw.taipei.gc.borrowing.adapter.user.restfulapi.reserve;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.taipei.gc.borrowing.adapter.UseCaseFactory;
import tw.taipei.gc.borrowing.adapter.user.presenter.reserve.ReservationViewModel;
import tw.taipei.gc.borrowing.adapter.user.presenter.reserve.ReserveItemPresenter;
import tw.taipei.gc.borrowing.usecase.user.reserve.ReserveItemUseCase;
import tw.taipei.gc.borrowing.usecase.user.reserve.ReserveItemUseCaseInput;


@RestController
@RequestMapping("/api/users")
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
            reserveItemUseCaseInput.setStartDate(request.getStartDate());
            reserveItemUseCaseInput.setEndDate(request.getEndDate());
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
    private String startDate;
    private String endDate;

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
