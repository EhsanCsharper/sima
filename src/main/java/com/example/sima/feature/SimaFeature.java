package com.example.sima.feature;

import com.example.sima.SimaCodes;
import com.example.sima.config.feature.FeatureConfig;

public class SimaFeature {
    public static final Boolean IS_SIMA_ACTIVE = FeatureConfig.getBoolean(SimaCodes.IS_SIMA_ACTIVE);
}
