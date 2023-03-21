package tw.taipei.gc.borrowing.usecase.custodian.repository.IOU;

import tw.taipei.gc.borrowing.model.user.IOU;
import tw.taipei.gc.borrowing.usecase.utils.DateHelper;

import java.util.UUID;

public class IOUDTOMapper {
    public static IOUDTO toDTO(IOU IOU) {
        IOUDTO IOUDTO = new IOUDTO();
        IOUDTO.setID(IOU.getID().toString())
                .setCustodianID(IOU.getCustodianID().toString())
                .setUserID(IOU.getUserID().toString())
                .setItemID(IOU.getItemID().toString())
                .setStartDate(DateHelper.toString(IOU.getStartDate()))
                .setEndDate(DateHelper.toString(IOU.getEndDate()));
        return IOUDTO;
    }

    public static IOU toModel(IOUDTO IOUDTO) {
        return new IOU(
                UUID.fromString(IOUDTO.getID()),
                UUID.fromString(IOUDTO.getCustodianID()),
                UUID.fromString(IOUDTO.getUserID()),
                UUID.fromString(IOUDTO.getItemID()),
                DateHelper.toDate(IOUDTO.getStartDate()),
                DateHelper.toDate(IOUDTO.getEndDate())
        );
    }
}
