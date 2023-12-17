package ru.alexeykuznetsov.spbgti.sdlab.service;

/**
 * Сервис для сортировки массива.
 *
 * @author Alexey Kuznetsov
 */
public interface SortingService {

  /**
   * Метод для сортировки переданного массива при помощи метода сортировки MergeSort.
   *
   * @param toSort - массив для сортировки
   */
  void sortArrayByMergeSort(int[] toSort);
}
