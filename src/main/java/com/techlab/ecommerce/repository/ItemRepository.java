package com.techlab.ecommerce.repository;

 import com.techlab.ecommerce.model.Item;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
