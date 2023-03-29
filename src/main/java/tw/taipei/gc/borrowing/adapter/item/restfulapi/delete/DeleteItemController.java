package tw.taipei.gc.borrowing.adapter.item.restfulapi.delete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.taipei.gc.borrowing.UseCaseFactory;
import tw.taipei.gc.borrowing.adapter.item.presenter.delete.DeleteItemPresenter;
import tw.taipei.gc.borrowing.adapter.item.presenter.delete.ItemViewModel;
import tw.taipei.gc.borrowing.usecase.item.delete.DeleteItemUseCaseInput;

@RestController
@RequestMapping("/api/items")
public class DeleteItemController {

    @DeleteMapping
    public ResponseEntity<ItemViewModel> deleteItem(@RequestParam String id) {
        DeleteItemUseCaseInput deleteItemUseCaseInput = new DeleteItemUseCaseInput();
        DeleteItemPresenter deleteItemPresenter = new DeleteItemPresenter();
        try {
            deleteItemUseCaseInput.setID(id);
            UseCaseFactory.DeleteItemUseCase().execute(deleteItemUseCaseInput, deleteItemPresenter);
            return ResponseEntity.ok().body(deleteItemPresenter.viewModel());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}