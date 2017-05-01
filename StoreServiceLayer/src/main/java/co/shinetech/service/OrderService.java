/*
* CustomerService.java
*/
package co.shinetech.service;

import co.shinetech.model.Order;
import co.shinetech.repository.OrderRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Customer Service (CRUD).
 * Created by rodrigo on 4/7/2017.
 *
 * @RestController is Spring 4 annotation to transform the class in a REST controller, that will receive and response domain objects in HTTP body using JSON representation
 *                 marshalling and unmarshalling data between view and service layers.
 * @RequestParam does the mapping between HTTP query string parameters and a method parameter
 * @RequestBody get parameters passed in HTTP body
 * @ResponseBody send parameters through HTTP body
 */
@RestController
@RequestMapping(value="order")
public class OrderService implements Service<Order>{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @RequestMapping(value="/create",method=RequestMethod.POST)
    @JsonIgnoreProperties({"items"})
    public void create(@RequestBody Order o) {
        orderRepository.save(o);
    }

    @Override
    @RequestMapping(value="/findById",method=RequestMethod.GET)
    @JsonIgnoreProperties({"items"})
    public @ResponseBody Order findById(@RequestParam String id) {
        return orderRepository.findOne(Long.valueOf(id));
    }

    @Override
    @RequestMapping(value="/findAll",method=RequestMethod.GET)
    @JsonIgnoreProperties({"items"})
    public @ResponseBody Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @JsonIgnoreProperties({"items"})
    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public void update(@RequestBody Order o) {
        orderRepository.save(o);
    }

    @Override
    @JsonIgnoreProperties({"items"})
    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
    public void delete(@RequestBody Order o) {
        orderRepository.delete(o);
    }
}