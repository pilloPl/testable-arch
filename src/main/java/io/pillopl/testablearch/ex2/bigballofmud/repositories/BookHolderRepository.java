package io.pillopl.testablearch.ex2.bigballofmud.repositories;

import io.pillopl.testablearch.ex2.bigballofmud.entities.BookHolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookHolderRepository extends JpaRepository<BookHolderEntity, UUID> {

}
