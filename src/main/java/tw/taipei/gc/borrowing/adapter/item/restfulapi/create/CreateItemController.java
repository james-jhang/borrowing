package tw.taipei.gc.borrowing.adapter.item.restfulapi.create;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;

import tw.taipei.gc.borrowing.adapter.item.presenter.create.CreateItemPresenter;
import tw.taipei.gc.borrowing.adapter.item.presenter.create.CreateItemViewModel;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCase;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCaseInput;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/items")
public class CreateItemController {

    @Autowired
    private CreateItemUseCase createItemUseCase;

    @PostMapping("/create")
    public ResponseEntity<CreateItemViewModel> createItem(@RequestBody ItemRequest newItem) {
        CreateItemUseCaseInput createItemUseCaseInput = new CreateItemUseCaseInput();
        CreateItemPresenter createItemPresenter = new CreateItemPresenter();
        try {
            createItemUseCaseInput.setName(newItem.getName());
            createItemUseCase.execute(createItemUseCaseInput, createItemPresenter);
            CreateItemViewModel viewModel = createItemPresenter.viewModel();
            return ResponseEntity.ok().body(viewModel);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

class ItemRequest {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}