package tw.taipei.gc.borrowing.adapter.custodian.restfulapi.deliver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.taipei.gc.borrowing.UseCaseFactory;
import tw.taipei.gc.borrowing.adapter.custodian.presenter.deliver.DeliverItemPresenter;
import tw.taipei.gc.borrowing.adapter.custodian.presenter.deliver.IOUViewModel;
import tw.taipei.gc.borrowing.usecase.custodian.deliver.DeliverItemUseCaseInput;

@RestController
@RequestMapping("/api/custodians")
public class DeliverItemController {

    @PostMapping("/deliver")
    public ResponseEntity<IOUViewModel> deliver_item(@RequestBody DeliverItemRequest request) {
        DeliverItemUseCaseInput deliverItemUseCaseInput = new DeliverItemUseCaseInput();
        DeliverItemPresenter deliverItemPresenter = new DeliverItemPresenter();
        try {
            deliverItemUseCaseInput.setCustodianID(request.getCustodianID());
            deliverItemUseCaseInput.setUserID(request.getUserID());
            deliverItemUseCaseInput.setReservationID(request.getReservationID());
            UseCaseFactory.DeliverItemUseCase().execute(deliverItemUseCaseInput, deliverItemPresenter);
            return ResponseEntity.ok().body(deliverItemPresenter.viewModel());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

class DeliverItemRequest {
    private String custodianID;
    private String userID;
    private String reservationID;

    public String getCustodianID() {
        return custodianID;
    }

    public void setCustodianID(String custodianID) {
        this.custodianID = custodianID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }
}
