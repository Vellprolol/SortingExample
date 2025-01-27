package ru.alexeykuznetsov.spbgti.sdlab.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FillerStrategy {
  MANUAL("MANUAL"),
  RANDOM("RANDOM");

  private final String name;
}
