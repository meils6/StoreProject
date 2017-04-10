package co.shinetech.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import co.shinetech.model.Customer;

public class CustomerTest {

	@Test
	public final void testGetAndSetName() {
		Customer tCustomer = new Customer();
		String name = "Jimmy";
		tCustomer.setName(name);
		assertEquals(name, tCustomer.getName());
	}
	
	@Test
	public final void testGetAndSetId(){
		Customer tCustomer = new Customer();
		LongPK lpk = new LongPK(1L);
		
		tCustomer.setId(lpk);
		
		assertEquals(lpk, tCustomer.getId());
		
	}
	
	@Test
	public final void testGetAndSetAddress(){
		String address = "123 Test Street";
		Customer tCustomer = new Customer();
		
		tCustomer.setAddress(address);
		
		assertEquals(address,tCustomer.getAddress());		
	}
	
	@Test
	public final void testGetAndSetZipCode(){
		String zip = "1041";
		
		Customer tCustomer = new Customer();
		tCustomer.setZipcode(zip);
		
		assertEquals(zip, tCustomer.getZipcode());
	}
	
	@Test
	public final void testGetAndSetCountry(){
		String country = "New Zealand";
		
		Customer tCustomer = new Customer();
		tCustomer.setCountry(country);
		
		assertEquals(country,tCustomer.getCountry());
	}
	
	@Test
	public final void testGetAndSetTaxId(){
		String taxId = "111-1111-11";
		
		Customer tCustomer = new Customer();
		tCustomer.setTaxid(taxId);
		
		assertEquals(taxId,tCustomer.getTaxid());
	}
	
	@Test
	public final void testGetAndSetPhone(){
		String phone = "0221916654";
		
		Customer tCustomer = new Customer();
		tCustomer.setPhone(phone);
		
		assertEquals(phone,tCustomer.getPhone());
	}
	
	@Test
	public final void testGetAndSetEmail(){
		String email = "Java@Programming101.co.nz";
		
		Customer tCustomer = new Customer();
		tCustomer.setEmail(email);
		
		assertEquals(email,tCustomer.getEmail());
	}
	
	@Test
	public final void testGetAndSetBirthdate(){
		LocalDate date = LocalDate.of(2017, 4, 10);
		
		Customer tCustomer = new Customer();
		tCustomer.setBirthdate(date);
		
		assertEquals(date,tCustomer.getBirthdate());
	}
	
	@Test
	public final void testAddAndGetOrders(){
		
		Customer tCustomer = new Customer();
		tCustomer.setName("John Test");
		
		LongPK lpk = new LongPK(4L);
		List<Order> orders;
		List<OrderItem> items = new ArrayList<>();
		ZonedDateTime orderDate = ZonedDateTime.of(2017, 4, 10, 12, 0, 0, 0, ZoneId.of("Pacific/Auckland"));
		ZonedDateTime estimatedDelivery = orderDate.plusDays(10);
	
		Order order = new Order(lpk,orderDate,estimatedDelivery,OrderStatus.PROCESSED,PaymentMethod.DEBITCARD,tCustomer,items);
		
		Product product = new Product(lpk,"Java Study 101",BigDecimal.valueOf(29.99),2,"Barcode",10,20,5,items);
		
		
		 
		
		items.add(new OrderItem(lpk, BigDecimal.valueOf(29.99), 2,order,product));
		
		List<Order> result = tCustomer.getOrdersStream().collect(Collectors.toList());
		
		

		
		assertEquals(items,result);
	}
	
	
}