package io.pillopl.testablearch.ex2.bigballofmud.repositories;

import io.pillopl.testablearch.ex2.bigballofmud.entities.BookHolderEntity;
import io.pillopl.testablearch.ex2.bigballofmud.entities.HolderRentalFeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HolderRentalFeeRepository extends JpaRepository<HolderRentalFeeEntity, UUID> {

    HolderRentalFeeEntity findByBookHolderEntity(BookHolderEntity entity);

}
