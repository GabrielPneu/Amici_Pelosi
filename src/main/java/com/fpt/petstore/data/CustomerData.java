package com.fpt.petstore.data;

import com.fpt.petstore.entities.BaseAccount;
import com.fpt.petstore.entities.Customer;

public class CustomerData {
  public Customer customer_2 =
          new Customer("Rafael Alves Lopes")
                  .withEmail("rafalopes@gmail.com")
                  .withPassword("12345")
                  .withBirthday("12/12/2002")
                  .withAddress("Rua morada do sol, 172")
                  .withPhone("011966456721")
                  .withGender(BaseAccount.Gender.Male)
                  .withAvatar("test.jpg");
  public Customer customer_3 =
          new Customer("Gabriel Pereira Amancio")
                  .withEmail("gabi@gmail.com")
                  .withPassword("12345")
                  .withBirthday("23/07/2002")
                  .withAddress("Rua Gustavo Teixeira, 143")
                  .withPhone("011966456721")
                  .withGender(BaseAccount.Gender.Male);

  public Customer[] ALL_CUSTOMERS = {
          customer_2,
          customer_3,
  };
}
