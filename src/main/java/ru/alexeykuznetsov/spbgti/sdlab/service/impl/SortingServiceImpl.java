package ru.alexeykuznetsov.spbgti.sdlab.service.impl;

import ru.alexeykuznetsov.spbgti.sdlab.service.SortingService;

/**
 * Реализация {@link SortingService}.
 *
 * @author Alexey Kuznetsov
 */
public class SortingServiceImpl implements SortingService {

  @Override
  public void sortArrayByMergeSort(int[] toSort) {
    if (toSort == null || toSort.length <= 1) {
      return;
    }
    int[] tempArray = new int[toSort.length];
    mergeSort(toSort, tempArray, 0, toSort.length - 1);
  }

  /**
   * Рекурсивный метод для сортировки слиянием.
   *
   * @param arr       - массив для сортировки
   * @param tempArray - временный массив для слияния
   * @param left      - индекс начала подмассива
   * @param right     - индекс конца подмассива
   */
  private void mergeSort(int[] arr, int[] tempArray, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2; // Находим середину массива
      mergeSort(arr, tempArray, left, mid); // Рекурсивно сортируем левую половину
      mergeSort(arr, tempArray, mid + 1, right); // Рекурсивно сортируем правую половину
      merge(arr, tempArray, left, mid, right); // Сливаем отсортированные половины
    }
  }


  /**
   * Метод для слияния двух отсортированных подмассивов.
   *
   * @param arr       - массив для сортировки
   * @param tempArray - временный массив для слияния
   * @param left      - индекс начала левого подмассива
   * @param mid       - индекс середины (конец левого подмассива)
   * @param right     - индекс конца правого подмассива
   */
  private void merge(int[] arr, int[] tempArray, int left, int mid, int right) {
    for (int i = left; i <= right; i++) {
      tempArray[i] = arr[i]; // Копируем все элементы в tempArray
    }
    int i = left; // Индекс для левой половины
    int j = mid + 1; // Индекс для правой половины
    int k = left; // Индекс для результирующего массива

    // Сливаем элементы из tempArray обратно в arr
    while (i <= mid && j <= right) {
      if (tempArray[i] <= tempArray[j]) {
        arr[k] = tempArray[i]; // Если элемент в левой половине меньше или равен
        i++; // Увеличиваем индекс левой половины
      } else {
        arr[k] = tempArray[j]; // Если элемент в правой половине меньше
        j++; // Увеличиваем индекс правой половины
      }
      k++; // Увеличиваем индекс результирующего массива
    }
    // Копируем оставшиеся элементы из левой половины, если они есть
    while (i <= mid) {
      arr[k] = tempArray[i];
      i++;
      k++;
    }
    // Копируем оставшиеся элементы из правой половины, если они есть (не нужно, если слияние выполнено правильно, но для надежности)
    while (j <= right) {
      arr[k] = tempArray[j];
      j++;
      k++;
    }
  }
}
