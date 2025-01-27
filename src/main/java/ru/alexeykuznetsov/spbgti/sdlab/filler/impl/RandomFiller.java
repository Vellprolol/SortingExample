package ru.alexeykuznetsov.spbgti.sdlab.filler.impl;

import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import ru.alexeykuznetsov.spbgti.sdlab.dto.ArrayUnitCreateDto;
import ru.alexeykuznetsov.spbgti.sdlab.filler.Filler;

/**
 * Реализация {@link Filler} для заполнения массива случайными числами.
 *
 * @author Alexey Kuznetsov
 */
@Component("RANDOM")
public class RandomFiller implements Filler {

  @Override
  public List<Integer> fill(ArrayUnitCreateDto dto) {
    return new Random().ints(dto.getArraySize(), dto.getMinElement(), dto.getMaxElement()).boxed().toList();
  }
}
