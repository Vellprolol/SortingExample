package ru.alexeykuznetsov.spbgti.psd.sortingexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.alexeykuznetsov.spbgti.sdlab.SdLabApplication;
import ru.alexeykuznetsov.spbgti.sdlab.entity.ArrayUnit;
import ru.alexeykuznetsov.spbgti.sdlab.repository.ArrayUnitRepository;
import ru.alexeykuznetsov.spbgti.sdlab.service.ArrayUnitService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SdLabApplication.class)
class SDLabTests {

  @Autowired
  private ArrayUnitRepository repository;

  @Autowired
  private ArrayUnitService arrayUnitService;

  @AfterEach
  public void tearDown() {
    repository.deleteAll();
  }

  @ParameterizedTest
  @MethodSource("provideEntities")
  void shouldInsertData(Integer entityCount) {
    repository.saveAll(buildArrayUnit(entityCount));

    Assertions.assertThat(repository.findAll().size()).isEqualTo(entityCount);
  }

  @ParameterizedTest
  @MethodSource("provideEntities")
  void shouldSortData(Integer entityCount) {
    List<ArrayUnit> arrayUnits = buildArrayUnit(entityCount);
    repository.saveAll(arrayUnits);

    List<ArrayUnit> sortedUnits = arrayUnits.stream()
        .limit(100)
        .map(ArrayUnit::getId)
        .map(arrayUnitService::sortArrayUnitData)
        .toList();

    Assertions.assertThat(repository.findAll().size()).isEqualTo(entityCount);
    Assertions.assertThat(sortedUnits.stream().map(ArrayUnit::getSortedData).filter(Objects::nonNull).count()).isEqualTo(100L);
  }

  private static Stream<Arguments> provideEntities() {
    return Stream.of(
        Arguments.of(100),
        Arguments.of(1000),
        Arguments.of(10000)
    );
  }

  private List<ArrayUnit> buildArrayUnit(Integer entityCount) {
    Random random = new Random();
    List<ArrayUnit> arrayUnits = new ArrayList<>();
    for (int i = 0; i < entityCount; i++) {
      arrayUnits.add(ArrayUnit.builder()
          .unsortedData(random.ints(10, 1, 100).boxed().toList())
          .build());
    }
    return arrayUnits;
  }

}
