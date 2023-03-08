package tw.taipei.gc.borrowing.adapter.item.restfulapi.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.taipei.gc.borrowing.adapter.item.presenter.query.ListAllItemsPresenter;
import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCaseInput;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ListAllItemsController {

    @Autowired
    private ListAllItemsUseCase findAllItemsUseCase;

    @GetMapping("/list")
    public ResponseEntity<List<ListAllItemsPresenter.FindAllItemsViewModel>> listItems() {
        ListAllItemsUseCaseInput findAllItemsUseCaseInput = new ListAllItemsUseCaseInput();
        ListAllItemsPresenter findAllItemsPresenter = new ListAllItemsPresenter();

        try {
            this.findAllItemsUseCase.execute(findAllItemsUseCaseInput, findAllItemsPresenter);
            return ResponseEntity.ok().body(findAllItemsPresenter.viewModel());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

}
