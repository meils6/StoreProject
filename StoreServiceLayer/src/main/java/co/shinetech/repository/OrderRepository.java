/*
* OrderRepository.java
*/
package co.shinetech.repository;

import co.shinetech.model.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rick on 1 May 2017.
 */
public interface OrderRepository extends CrudRepository<Order,Long>{
}