package ru.alexeykuznetsov.spbgti.sdlab.service;

import java.util.List;
import java.util.UUID;
import ru.alexeykuznetsov.spbgti.sdlab.dto.ArrayUnitCreateDto;
import ru.alexeykuznetsov.spbgti.sdlab.entity.ArrayUnit;

/**
 * Сервис для заполнения массива.
 *
 * @author Alexey Kuznetsov
 */
public interface ArrayUnitService {

  /**
   * Метод для заполнения массива числовыми данными.
   *
   * @return сущность, содержащая данные для сортировки
   */
  ArrayUnit createArrayUnit(ArrayUnitCreateDto dto);

  ArrayUnit getArrayUnitById(UUID id);

  ArrayUnit sortArrayUnitData(UUID id);

  void deleteArrayUnit(UUID id);

  ArrayUnit editArrayUnit(ArrayUnit arrayUnit);

  List<ArrayUnit> findAll();

  ArrayUnit getArrayUnitByIdForUpdate(UUID id);
}
