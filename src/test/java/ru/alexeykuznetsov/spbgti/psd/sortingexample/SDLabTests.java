package ru.alexeykuznetsov.spbgti.psd.sortingexample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.alexeykuznetsov.spbgti.sdlab.service.SortingService;
import ru.alexeykuznetsov.spbgti.sdlab.service.impl.SortingServiceImpl;

class SDLabTests {

  SortingService sortingService = new SortingServiceImpl();

  @Test
  void shouldSortArray() {
    int[] array = new int[] {77, 10, 49, 72, 18, 79, 20, 88, 90, 31};
    sortingService.sortArrayByMergeSort(array);
    int[] sorted = new int[] {10, 18, 20, 31, 49, 72, 77, 79, 88, 90};

    Assertions.assertThat(array).isEqualTo(sorted);
  }

}
