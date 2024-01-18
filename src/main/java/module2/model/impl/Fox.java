package module2.model.impl;

import module2.config.LiveableConfig;
import module2.model.Fauna;
import module2.model.enums.LiveableType;

import static module2.model.enums.LiveableType.FOX;

public class Fox extends Fauna {

    public Fox(LiveableConfig liveableConfig) {
        super(liveableConfig);
    }

    @Override
    public LiveableType getLiveableType() {
        return FOX;
    }
}