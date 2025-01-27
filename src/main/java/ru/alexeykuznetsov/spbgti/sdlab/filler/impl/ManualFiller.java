package ru.alexeykuznetsov.spbgti.sdlab.filler.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import ru.alexeykuznetsov.spbgti.sdlab.dto.ArrayUnitCreateDto;
import ru.alexeykuznetsov.spbgti.sdlab.filler.Filler;

/**
 * Реализация {@link Filler} для заполнения массива данными от пользователя.
 *
 * @author Alexey Kuznetsov
 */
@Component("MANUAL")
public class ManualFiller implements Filler {

  @Override
  public List<Integer> fill(ArrayUnitCreateDto dto) {
    return dto.getUnsortedData();
  }
}
