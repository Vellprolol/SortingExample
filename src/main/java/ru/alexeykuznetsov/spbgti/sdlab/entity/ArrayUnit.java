package ru.alexeykuznetsov.spbgti.sdlab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.alexeykuznetsov.spbgti.sdlab.converter.ArrayUnitDataConverter;

/**
 * Сущность для хранения данных.
 *
 * @author Alexey Kuznetsov
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "array_units")
public class ArrayUnit {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "unsorted_data")
  @Convert(converter = ArrayUnitDataConverter.class)
  private List<Integer> unsortedData;

  @Column(name = "sorted_data")
  @Convert(converter = ArrayUnitDataConverter.class)
  private List<Integer> sortedData;

  @Transient
  private String unsortedDataString;

  public ArrayUnit setUnsortedDataString() {
    unsortedDataString = unsortedData.stream().map(String::valueOf).collect(Collectors.joining(","));
    return this;
  }
}
