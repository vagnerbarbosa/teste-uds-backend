package com.vagnerdantas.persistence.repository;

import com.vagnerdantas.persistence.domain.Acai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright @author Vagner Dantas
 */
@Repository
public interface AcaiRepository extends JpaRepository<Acai, Integer> {

}
