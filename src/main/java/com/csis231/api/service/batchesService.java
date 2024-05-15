package com.csis231.api.service;

import com.csis231.api.repository.batchesRepository;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csis231.api.model.Product;
import com.csis231.api.model.batches;
import java.util.Date;
import java.util.List;
import com.csis231.api.repository.ProductRepository;


@Service
public class batchesService {


        private batchesRepository batchRepository;
        private ProductRepository productRepository;

        public List<batches> getAllBatches() {
            return batchRepository.findAll();
        }

        public batches getBatchById(int batchId) {
            return batchRepository.findById(batchId).orElse(null);
        }

        public batches addBatch(batches batch) {
            return batchRepository.save(batch);
        }

        public batches updateBatch(int batchId, batches updatedBatch) {
            batches existingBatch = getBatchById(batchId);
            if (existingBatch != null) {
                existingBatch.setProduct(updatedBatch.getProduct());
                existingBatch.setExperation_date(updatedBatch.getExperation_date());
                existingBatch.setQuantity(updatedBatch.getQuantity());
                return batchRepository.save(existingBatch);
            }
            return null;
        }

        public void deleteBatch(int batchId) {
            batchRepository.deleteById(batchId);
        }

    public List<batches> getBatchesExpiringWithinOneMonth() {
        return batchRepository.findBatchesExpiringWithinOneMonth();
    }

    public void removeExpiredProducts() {
        List<batches> expiredBatches = batchRepository.findExpiredBatches();
        expiredBatches.forEach(batch -> {
            Product product = batch.getProduct();
            product.setQuantityInStock(Math.max(0, product.getQuantityInStock() - batch.getQuantity()));
            productRepository.save(product); // Assuming Product entity has its own repository or is cascaded from batches.
            batchRepository.delete(batch);
        });
    }
    }

