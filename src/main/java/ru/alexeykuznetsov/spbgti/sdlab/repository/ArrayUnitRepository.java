package ru.alexeykuznetsov.spbgti.sdlab.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexeykuznetsov.spbgti.sdlab.entity.ArrayUnit;

public interface ArrayUnitRepository extends JpaRepository<ArrayUnit, UUID> {

}
