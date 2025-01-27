package ru.alexeykuznetsov.spbgti.sdlab.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.alexeykuznetsov.spbgti.sdlab.service.SortingService;

/**
 * Реализация {@link SortingService}.
 *
 * @author Alexey Kuznetsov
 */
@Service
public class SortingServiceImpl implements SortingService {

  @Override
  public List<Integer> sortArrayByMergeSort(List<Integer> toSort) {
    if (toSort == null || toSort.size() <= 1) { // Если список пустой или содержит 1 элемент, то он уже отсортирован
      return new ArrayList<>(toSort); // Возвращаем копию, чтобы не менять оригинальный
    }
    List<Integer> tempArray = new ArrayList<>(toSort); // Временный список для слияния
    List<Integer> sortedList = new ArrayList<>(toSort); // Копия для сортировки
    mergeSort(sortedList, tempArray, 0, sortedList.size() - 1);
    return sortedList; // Возвращаем новый отсортированный список
  }

  /**
   * Рекурсивный метод для сортировки слиянием.
   *
   * @param arr       - массив для сортировки
   * @param tempArray - временный массив для слияния
   * @param left      - индекс начала подмассива
   * @param right     - индекс конца подмассива
   */
  private void mergeSort(List<Integer> list, List<Integer> tempArray, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2; // Находим середину списка
      mergeSort(list, tempArray, left, mid); // Рекурсивно сортируем левую половину
      mergeSort(list, tempArray, mid + 1, right); // Рекурсивно сортируем правую половину
      merge(list, tempArray, left, mid, right); // Сливаем отсортированные половины
    }
  }


  /**
   * Метод для слияния двух отсортированных подмассивов.
   *
   * @param list      - список для сортировки
   * @param tempArray - временный список для слияния
   * @param left      - индекс начала левого подмассива
   * @param mid       - индекс середины (конец левого подмассива)
   * @param right     - индекс конца правого подмассива
   */
  private void merge(List<Integer> list, List<Integer> tempArray, int left, int mid, int right) {
    for (int i = left; i <= right; i++) {
      tempArray.set(i, list.get(i)); // Копируем все элементы в tempArray
    }
    int i = left; // Индекс для левой половины
    int j = mid + 1; // Индекс для правой половины
    int k = left; // Индекс для результирующего списка

    // Сливаем элементы из tempArray обратно в list
    while (i <= mid && j <= right) {
      if (tempArray.get(i) <= tempArray.get(j)) {
        list.set(k, tempArray.get(i)); // Если элемент в левой половине меньше или равен
        i++; // Увеличиваем индекс левой половины
      } else {
        list.set(k, tempArray.get(j)); // Если элемент в правой половине меньше
        j++; // Увеличиваем индекс правой половины
      }
      k++; // Увеличиваем индекс результирующего списка
    }
    // Копируем оставшиеся элементы из левой половины, если они есть
    while (i <= mid) {
      list.set(k, tempArray.get(i));
      i++;
      k++;
    }
    // Копируем оставшиеся элементы из правой половины, если они есть (не нужно, если слияние выполнено правильно, но для надежности)
    while (j <= right) {
      list.set(k, tempArray.get(j));
      j++;
      k++;
    }
  }
}
