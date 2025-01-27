package ru.alexeykuznetsov.spbgti.sdlab.filler;

import java.util.List;
import ru.alexeykuznetsov.spbgti.sdlab.dto.ArrayUnitCreateDto;

public interface Filler {
  List<Integer> fill(ArrayUnitCreateDto dto);
}
