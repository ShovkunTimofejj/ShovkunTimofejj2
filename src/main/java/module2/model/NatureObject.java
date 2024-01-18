package module2.model;

import module2.config.LiveableConfig;
import module2.model.enums.LiveableType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class NatureObject {

    BigDecimal weight;

    public NatureObject(LiveableConfig liveableConfig) {
        this(liveableConfig.getWeight());
    }

    public abstract LiveableType getLiveableType();

}