package co.shinetech.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

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
		long id =1L;
		
		 tCustomer.setId(id);
		long customerMethod = tCustomer.getId();

		assertEquals( id, customerMethod);
		
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
		tCustomer.setZipCode(zip);
		
		assertEquals(zip, tCustomer.getZipCode());
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
		tCustomer.setTaxId(taxId);
		
		assertEquals(taxId,tCustomer.getTaxId());
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
		Date date = new Date(2017, 4, 10);
		
		Customer tCustomer = new Customer();
		tCustomer.setBirthDate(date);
		
		assertEquals(date,tCustomer.getBirthDate());
	}
	
	@Test
	public final void testAddAndGetOrders(){
		Customer tCustomer = new Customer();
		long id = 4L;
		List<Order> orders = new ArrayList<>();
		List<OrderItem> items = new ArrayList<>()
				;
		Date orderDate = new Date(2017, 4, 10);
		Date estimatedDelivery = new Date(2017, 4, 20);
		Order order = new Order(5L,orderDate,estimatedDelivery,OrderStatus.PROCESSED,PaymentMethod.DEBITCARD,tCustomer,items);
		Product product = new Product(5L,"Java Study 101",BigDecimal.valueOf(29.99),2,"Barcode",10,20,5,items);
		items.add(new OrderItem( 5L, BigDecimal.valueOf(29.99), 2,order,product));
		orders.add(order);
		
		tCustomer.addOrders(orders);
		
		List<Order> result = tCustomer.getOrdersStream().collect(Collectors.toList());
		String expected = order.toString() ;

		
		assertEquals("["+expected+"]",result.toString());
	}

	@Test
	public void testBuilder() {
		Date d = new Date();
		Customer customer = new Customer.Builder(1L)
				                .withAddress("Address")
								.withBirthDate(d)
								.withCountry("Country")
								.withEmail("Email")
								.withName("Name")
								.withPhone("Phone")
								.withTaxId("TaxId")
								.withZipCode("ZipCode")
								.create();

		assertEquals(customer.getName(),"Name");
		assertEquals(customer.getAddress(),"Address");
		assertEquals(customer.getBirthDate(),d);
		assertEquals(customer.getCountry(),"Country");
		assertEquals(customer.getEmail(),"Email");
		assertEquals(customer.getPhone(),"Phone");
		assertEquals(customer.getTaxId(),"TaxId");
		assertEquals(customer.getZipCode(),"ZipCode");
		assertEquals(customer.getId(),new Long(1L));
	}
}