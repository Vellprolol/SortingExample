package ru.alexeykuznetsov.spbgti.sdlab.dto;

import java.util.List;
import lombok.Data;
import ru.alexeykuznetsov.spbgti.sdlab.enums.FillerStrategy;

@Data
public class ArrayUnitCreateDto {

  private FillerStrategy fillerStrategy;

  private List<Integer> unsortedData;

  private Integer arraySize;

  private Integer minElement;

  private Integer maxElement;
}
