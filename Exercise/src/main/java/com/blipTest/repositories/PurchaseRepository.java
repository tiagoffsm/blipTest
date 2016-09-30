package com.blipTest.repositories;

import com.blipTest.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

/**
 * Created by Tiago Matos on 28/09/2016.
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findAll();

    Collection<Purchase> findAllByExpiresGreaterThanEqual(Timestamp currentDate);
}
