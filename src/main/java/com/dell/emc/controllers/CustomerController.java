package com.dell.emc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dell.emc.exception.ResourceNotFoundException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.dell.emc.model.Customer;
import com.dell.emc.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

  @Autowired
  private CustomerService emcService;
  /**
   * Get all emcs list.
   *
   * @return the list
   */
  @GetMapping("/emcs")
  public List<Customer> getAllCustomers() {
    return emcService.findAll();
  }

  /**
   * Gets emcs by id.
   *
   * @param emcId the emc id
   * @return the emcs by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/emcs/{id}")
  public ResponseEntity<Customer> getCustomersById(@PathVariable(value = "id") Long emcId)
      throws ResourceNotFoundException {
        Customer emc = emcService.getCustomerByid(emcId);
    return ResponseEntity.ok().body(emc);
  }

  /**
   * Create emc emc.
   *
   * @param emc the emc
   * @return the emc
   */
  @PostMapping("/emcs")
  public Customer createCustomer(@Valid @RequestBody Customer emc) {
    return emcService.createCustomer(emc);
  }

  /**
   * Update emc response entity.
   *
   * @param emcId the emc id
   * @param emcDetails the emc details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/emcs/{id}")
  public ResponseEntity<Customer> updateCustomer(
      @PathVariable(value = "id") Long emcId, @Valid @RequestBody Customer emcDetails)
      throws ResourceNotFoundException {

    Customer emc = emcService.getCustomerByid(emcId);
    emc.setEmail(emcDetails.getEmail());
    emc.setLastName(emcDetails.getLastName());
    emc.setFirstName(emcDetails.getFirstName());
    final Customer updatedCustomer = emcService.createCustomer(emc);
    return ResponseEntity.ok(updatedCustomer);
  }

  /**
   * Delete emc map.
   *
   * @param emcId the emc id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/emcs/{id}")
  public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long emcId) throws Exception {
    Customer emc = emcService.getCustomerByid(emcId);
    emcService.deleteCustomer(emc);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
 

}
