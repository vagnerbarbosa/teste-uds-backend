package com.vagnerdantas.persistence.repository;

import com.vagnerdantas.persistence.domain.Acai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Copyright @author Vagner Dantas
 */
@Repository
public interface AcaiRepository extends JpaRepository<Acai, Integer> {

    String ID = "id";
    String SQL_NATIVE_CONSULT = "select w.id, w.action, w.created_at, w.number_issue from event w where w.number_issue = :id";

    @Query(value = SQL_NATIVE_CONSULT, nativeQuery = true)
    List<Acai> findAllById(@Param(ID) String id);
}
