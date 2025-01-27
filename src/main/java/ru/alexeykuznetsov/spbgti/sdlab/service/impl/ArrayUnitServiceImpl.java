package ru.alexeykuznetsov.spbgti.sdlab.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexeykuznetsov.spbgti.sdlab.dto.ArrayUnitCreateDto;
import ru.alexeykuznetsov.spbgti.sdlab.entity.ArrayUnit;
import ru.alexeykuznetsov.spbgti.sdlab.filler.Filler;
import ru.alexeykuznetsov.spbgti.sdlab.repository.ArrayUnitRepository;
import ru.alexeykuznetsov.spbgti.sdlab.service.ArrayUnitService;
import ru.alexeykuznetsov.spbgti.sdlab.service.SortingService;

@Service
@RequiredArgsConstructor
public class ArrayUnitServiceImpl implements ArrayUnitService {

  private final SortingService sortingService;
  private final ArrayUnitRepository repository;
  private final Map<String, Filler> fillerStrategy;

  @Override
  public ArrayUnit createArrayUnit(ArrayUnitCreateDto dto) {
    return repository.save(ArrayUnit.builder()
        .unsortedData(fillerStrategy.get(dto.getFillerStrategy().getName()).fill(dto))
        .build());
  }

  @Override
  public ArrayUnit getArrayUnitById(UUID id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public ArrayUnit getArrayUnitByIdForUpdate(UUID id) {
    return repository.findById(id).orElseThrow().setUnsortedDataString();
  }

  @Override
  public ArrayUnit sortArrayUnitData(UUID id) {
    ArrayUnit arrayUnit = getArrayUnitById(id);
    arrayUnit.setSortedData(sortingService.sortArrayByMergeSort(arrayUnit.getUnsortedData()));
    return repository.save(arrayUnit);
  }

  @Override
  public void deleteArrayUnit(UUID id) {
    repository.deleteById(id);
  }

  @Override
  public ArrayUnit editArrayUnit(ArrayUnit arrayUnit) {
    return repository.save(arrayUnit.setUnsortedData(arrayUnit.getUnsortedData()).setSortedData(null));
  }

  @Override
  public List<ArrayUnit> findAll() {
    return repository.findAll();
  }
}
