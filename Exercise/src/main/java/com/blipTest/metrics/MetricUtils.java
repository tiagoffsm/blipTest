package com.blipTest.metrics;

import java.sql.Timestamp;

/**
 * Created by Tiago Matos on 30/09/2016.
 */
public interface MetricUtils {

      default long timeCalc(Timestamp initTime, Timestamp finishTime) {
        return finishTime.getTime() - initTime.getTime();
    }
}
