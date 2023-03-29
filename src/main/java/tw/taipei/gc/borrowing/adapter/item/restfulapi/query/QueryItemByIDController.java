package tw.taipei.gc.borrowing.adapter.item.restfulapi.query;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import tw.taipei.gc.borrowing.UseCaseFactory;
import tw.taipei.gc.borrowing.usecase.item.query.byid.QueryItemByIDUseCaseInput;
import tw.taipei.gc.borrowing.adapter.item.presenter.query.ItemViewModel;
import tw.taipei.gc.borrowing.adapter.item.presenter.query.QueryItemByIDPresenter;

@RestController
@RequestMapping("/api/items")
public class QueryItemByIDController {

    @GetMapping("/details")
    public ResponseEntity<ItemViewModel> queryItemByID(@RequestParam String id) {
        QueryItemByIDUseCaseInput queryItemByIDUseCaseInput = new QueryItemByIDUseCaseInput();
        QueryItemByIDPresenter queryItemByIDPresenter = new QueryItemByIDPresenter();

        try {
            queryItemByIDUseCaseInput.setID(id);
            UseCaseFactory.QueryItemByIDUseCase().execute(queryItemByIDUseCaseInput, queryItemByIDPresenter);
            ItemViewModel result = queryItemByIDPresenter.viewModel();
            return ResponseEntity.ofNullable(result);
        } catch (Exception e) {
            // TODO how to handle this exception?
            return ResponseEntity.badRequest().body(null);
        }
    }
}
