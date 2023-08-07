package com.flipkart.krystal.vajram;

import static com.flipkart.krystal.vajram.VajramID.vajramID;
import static com.flipkart.krystal.vajram.Vajrams.getVajramIdString;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;

abstract sealed class AbstractVajram<T> implements Vajram<T> permits ComputeVajram, IOVajram {

  @MonotonicNonNull private VajramID id;

  @Override
  public final VajramID getId() {
    if (id == null) {
      id =
          vajramID(
              getVajramIdString(getClass())
                  .orElseThrow(
                      () ->
                          new IllegalStateException(
                              "Unable to find vajramId for class %s".formatted(getClass()))));
    }
    return id;
  }
}
