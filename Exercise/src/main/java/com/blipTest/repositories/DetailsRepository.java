package com.blipTest.repositories;

import com.blipTest.entities.Details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Tiago Matos on 28/09/2016.
 */
public interface DetailsRepository extends JpaRepository<Details, Long> {
    List<Details> findAll();
}
