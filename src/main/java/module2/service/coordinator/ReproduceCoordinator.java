package module2.service.coordinator;

import module2.model.Fauna;
import module2.model.NatureObject;
import module2.model.Cell;
import module2.service.ReproduceService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReproduceCoordinator {

    ReproduceService reproduceService = new ReproduceService();

    public void reproduceOnCell(Cell cell, Fauna fauna) {

        Optional<NatureObject> bornEntity = reproduceService.reproduce(fauna.getLiveableType());

        bornEntity.ifPresent(natureObject -> cell.getListOfEntity().add(natureObject));
    }

}