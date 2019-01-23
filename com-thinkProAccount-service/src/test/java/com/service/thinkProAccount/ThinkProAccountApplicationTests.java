package com.service.thinkProAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.service.thinkProAccount.domain.Account;
import com.service.thinkProAccount.domain.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThinkProAccountApplicationTests {

	private Session session;

	// ...

///*	@Test
//	public void givenData_whenInsert_thenCreatesMtoMrelationship() {
//		String[] customerData = { "Peter Oven", "Allan Norman" };
//		String[] accountData = { "IT Project", "Networking Project" };
//		Set<Account> accounts = new HashSet<>();
//
//		for (String acc : accountData) {
//			accounts.add(new Account(0, acc, acc, acc, acc, acc, null));
//		}
//
//		for (String emp : customerData) {
//			Customer customer = new Customer(0, emp.split(" ")[0], emp.split(" ")[1], emp, 0, emp, accounts);
//
//			assertEquals(0, customer.getAccounts().size());
//			customer.setAccounts(accounts);
//			session.persist(customer);
//
//			assertNotNull(customer);
//		}
//	}
//
//	@Test
//	public void givenSession_whenRead_thenReturnsMtoMdata() {
//		@SuppressWarnings("unchecked")
//		List<Customer> customerList = session.createQuery("FROM Customer").list();
//
//		assertNotNull(customerList);
//
//		for (Customer customer : customerList) {
//			assertNotNull(customer.getAccounts());
//		}
//	}*/

}
