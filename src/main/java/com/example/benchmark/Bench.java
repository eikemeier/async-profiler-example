package com.example.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 1, time = 1)
public /* open */ class Bench {
  @Benchmark
  public final void empty() {}
}
