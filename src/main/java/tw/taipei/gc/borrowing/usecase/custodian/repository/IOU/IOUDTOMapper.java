package tw.taipei.gc.borrowing.usecase.custodian.repository.IOU;

import tw.taipei.gc.borrowing.model.user.IOU;
import tw.taipei.gc.borrowing.usecase.utils.DateHelper;

import java.util.UUID;

public class IOUDTOMapper {
    public static IOUDTO toDTO(IOU IOU) {
        IOUDTO IOUDTO = new IOUDTO();
        IOUDTO.setID(IOU.getID().toString())
                .setDeliveringDate(DateHelper.toString(IOU.getDeliveringDate()))
                .setCustodianID(IOU.getCustodianID().toString())
                .setUserID(IOU.getUserID().toString())
                .setItemID(IOU.getItemID().toString())
                .setStartDate(DateHelper.toString(IOU.getStartDate()))
                .setEndDate(DateHelper.toString(IOU.getEndDate()))
                .setItemReturned(IOU.isItemReturned())
                .setReturningDate(DateHelper.toString(IOU.getReturningDate()));
        return IOUDTO;
    }

    public static IOU toModel(IOUDTO IOUDTO) {
        return new IOU(
                UUID.fromString(IOUDTO.getID()),
                DateHelper.toDate(IOUDTO.getDeliveringDate()),
                UUID.fromString(IOUDTO.getCustodianID()),
                UUID.fromString(IOUDTO.getUserID()),
                UUID.fromString(IOUDTO.getItemID()),
                DateHelper.toDate(IOUDTO.getStartDate()),
                DateHelper.toDate(IOUDTO.getEndDate()),
                IOUDTO.isItemReturned(),
                DateHelper.toDate(IOUDTO.getReturningDate())
        );
    }
}
