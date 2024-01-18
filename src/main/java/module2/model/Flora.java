package module2.model;

import module2.config.LiveableConfig;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public abstract class Flora extends NatureObject {

    public Flora(LiveableConfig liveableConfig) {
        super(liveableConfig);
    }

}