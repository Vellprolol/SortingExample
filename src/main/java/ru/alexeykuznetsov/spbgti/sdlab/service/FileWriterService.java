package ru.alexeykuznetsov.spbgti.sdlab.service;

/**
 * Сервис для записи отсортированного массива в файл.
 *
 * @author Alexey Kuznetsov
 */
public interface FileWriterService {

  /**
  * Метод для записи отсортированного массива в файл.
  *
  * @param arr - отсортированный массив
  */
  void writeData(int[] arr);
}
