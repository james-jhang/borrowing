package tw.taipei.gc.borrowing.adapter.custodian.repository;

import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianDTO;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCustodianRepository implements CustodianRepository {

    private final List<CustodianDTO> custodians;

    public InMemoryCustodianRepository() {
        this.custodians = new ArrayList<>();
    }

    @Override
    public List<CustodianDTO> findAll() {
        return custodians;
    }

    @Override
    public Optional<CustodianDTO> findById(String id) {
        CustodianDTO target = null;
        for (CustodianDTO custodian : this.custodians) {
            if (custodian.getID().equals(id)) {
                target = custodian;
            }
        }
        return Optional.ofNullable(target);
    }

    @Override
    public Optional<CustodianDTO> findFirstByName(String name) {
        CustodianDTO target = null;
        for (CustodianDTO custodian : this.custodians) {
            if (custodian.getName().equals(name)) {
                target = custodian;
            }
        }
        return Optional.ofNullable(target);
    }

    @Override
    public Optional<CustodianDTO> save(CustodianDTO custodian) {
        this.custodians.add(custodian);
        return Optional.of(custodian);
    }

    @Override
    public boolean remove(CustodianDTO custodian) {
        return custodians.remove(custodian);
    }
}
