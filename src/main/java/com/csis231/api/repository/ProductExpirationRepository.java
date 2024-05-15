package com.csis231.api.repository;

import com.csis231.api.model.ProductExpiration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductExpirationRepository extends JpaRepository<ProductExpiration, Long> {

    @Query("SELECT p FROM ProductExpiration p WHERE p.product = ?1 AND p.quantity > 0 ORDER BY p.expirationDate ASC")
    List<ProductExpiration> findAvailableByProductIdOrderByDateAsc(int productId);
}

