package com.flipkart.krystal.caramel.samples.basic.split;

import com.flipkart.krystal.caramel.model.CaramelField;
import com.flipkart.krystal.caramel.model.SimpleCaramelField;
import com.flipkart.krystal.caramel.model.Value;
import com.flipkart.krystal.caramel.model.ValueImpl;
import com.flipkart.krystal.caramel.samples.basic.Metric;

public class SubMetricPayload implements SubMetricPayloadDefinition {

  public interface SubMetricFields {
    CaramelField<Metric, SubMetricPayload> init =
        new SimpleCaramelField<>(
            "init", SubMetricPayload.class, SubMetricPayload::init, SubMetricPayload::setInit);
    CaramelField<Metric, SubMetricPayload> metric =
        new SimpleCaramelField<>(
            "metric", SubMetricPayload.class, SubMetricPayload::init, SubMetricPayload::setInit);
  }

  private final Value<Metric, SubMetricPayload> init = new ValueImpl<>(SubMetricFields.init, this);
  private final Value<Metric, SubMetricPayload> metric =
      new ValueImpl<>(SubMetricFields.metric, this);

  @Override
  public Metric init() {
    return init.getOrThrow();
  }

  public void setInit(Metric init) {
    this.init.set(init);
  }

  @Override
  public Metric getMetric() {
    return metric.getOrThrow();
  }

  public void setMetric(Metric metric) {
    this.metric.set(metric);
  }
}
