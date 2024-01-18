package module2.model.impl;

import module2.config.LiveableConfig;
import module2.model.Flora;
import module2.model.enums.LiveableType;

import static module2.model.enums.LiveableType.PLANT;

public class Plant extends Flora {

    public Plant(LiveableConfig liveableConfig) {
        super(liveableConfig);
    }

    @Override
    public LiveableType getLiveableType() {
        return PLANT;
    }
}