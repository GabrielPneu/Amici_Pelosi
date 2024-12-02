package com.fpt.petstore.data;

import com.fpt.petstore.entities.*;

public class PetStoreData {

  public Customer customer_2 =
      new Customer("Rafal Lopes")
          .withUsername("rafalopes")
          .withEmail("rafalopes@gmail.com")
          .withPassword("12345")
          .withBirthday("12/09/1998")
          .withAddress("342 Barueri")
          .withPhone("11965454586")
          .withGender(BaseAccount.Gender.Male)
          .withAvatar("test.jpg");

  public Customer customer_3 =
      new Customer("Seu JOrge")
          .withUsername("jorgezito")
          .withEmail("jorgeseu@gmail.com")
          .withPassword("12345")
          .withBirthday("30/01/2000")
          .withAddress("54 Burguesia")
          .withPhone("0851235898")
          .withGender(BaseAccount.Gender.Female);

  public Customer customer_4 =
      new Customer("Sakura Haruno")
          .withUsername("saku")
          .withEmail("sk=haruno@gmail.com")
          .withPassword("12345")
          .withBirthday("06/12/2000")
          .withAddress("11 Aldeia")
          .withPhone("0914565476")
          .withGender(BaseAccount.Gender.Male);

  public Customer customer_5 =
      new Customer("Van gogh")
          .withEmail("bangohh@gmail.com")
          .withPassword("12345")
          .withBirthday("06/09/2000")
          .withAddress("235 Pirituba")
          .withPhone("11967474589")
          .withGender(BaseAccount.Gender.Female)
          .withUsername("vangohh@gmail.com");
  public Customer customer_6 =
      new Customer("Roberto Calor")
          .withEmail("rcarlos@gmail.com")
          .withPassword("12345")
          .withBirthday("21/12/2000")
          .withAddress("234 Imirim")
          .withPhone("11923454642")
          .withGender(BaseAccount.Gender.Male)
          .withUsername("rcarlos@gmail.com");

  public Customer[] ALL_CUSTOMERS = {
    customer_2, customer_3, customer_4, customer_5, customer_6
  };

  public Employee admin =
      new Employee("admin")
          .withAddress("Sao Paulo")
          .withEmail("admin@admin.com")
          .withPassword("admin")
          .withUsername("admin")
          .withBirthday("00/00/0000")
          .withGender(BaseAccount.Gender.Male)
          .withPhone("09168860230")
          .withRole(BaseAccount.UserRole.Admin);

  public Employee gabriel =
      new Employee("Gabriel Amancio")
          .withAddress("Sambodromo")
          .withEmail("amancio@gmail.com")
          .withPassword("12345")
          .withUsername("biel")
          .withPhone("09107256361")
          .withGender(BaseAccount.Gender.Male)
          .withBirthday("06/09/2000")
          .withRole(BaseAccount.UserRole.Moderator);

  public Employee pParker =
      new Employee("Peter Parker")
          .withAddress("Brooknlin")
          .withEmail("peterparker@gmail.com")
          .withPassword("spiderman")
          .withUsername("spiderman")
          .withPhone("09854798553")
          .withGender(BaseAccount.Gender.Male)
          .withBirthday("06/09/2000")
          .withRole(BaseAccount.UserRole.Write);

  public Employee[] ALL_EMPLOYEES = {admin, gabriel, pParker};

  FoodData _DATA_FOOD = new FoodData();
  ProductData _DATA_PRODUCT = new ProductData();

  Order order_1 =
      new Order("order-1")
          .withEmployee(gabriel)
          .withCustomer(customer_2)
          .withState(Order.State.DUE)
          .addOrderItem(_DATA_FOOD.food_2)
          .addOrderItem(_DATA_FOOD.food_2)
          .addOrderItem(_DATA_FOOD.food_2)
          .addOrderItem(_DATA_FOOD.food_3)
          .addOrderItem(_DATA_PRODUCT.product_3)
          .addOrderItem(_DATA_PRODUCT.product_3)
          .addOrderItem(_DATA_PRODUCT.product_3)
          .addOrderItem(_DATA_PRODUCT.product_1)
          .withPayment(
              new Payment("Tien Mat")
                  .withAmount(200)
                  .withTransactionDate("04/05/2021@11:26:07")
                  .                  withTransactionType(Payment.TransactionType.Cash))
          .withPayment(
              new Payment("Banking")
                  .withAmount(1000)
                  .withTransactionDate("04/05/2021@11:26:07")
                  .
                  withTransactionType(Payment.TransactionType.CustomerCredit))
          .withTransactionDate("04/05/2021@11:20:20"); // Ngay in hoa don

  Order order_2 =
      new Order("order_2")
          .withEmployee(admin)
          .withCustomer(customer_3)
          .withState(Order.State.DUE)
          .addOrderItem(_DATA_FOOD.food_4)
          .addOrderItem(_DATA_FOOD.food_4)
          .addOrderItem(_DATA_FOOD.food_4)
          .addOrderItem(_DATA_FOOD.food_4)
          .addOrderItem(_DATA_FOOD.food_2)
          .addOrderItem(_DATA_PRODUCT.product_1)
          .addOrderItem(_DATA_PRODUCT.product_1)
          .addOrderItem(_DATA_PRODUCT.product_5)
          .withPayment(
              new Payment("Cash")
                  .withAmount(1200)
                  .withTransactionDate("01/05/2021@10:20:20")
                  .
                  withTransactionType(Payment.TransactionType.Cash))
          .withTransactionDate("03/5/2021@10:20:20");

  public Order order_3 =
      new Order("order_3")
          .withEmployee(pParker)
          .withCustomer(customer_5)
          .withState(Order.State.DUE)
          .addOrderItem(_DATA_FOOD.food_2)
          .addOrderItem(_DATA_FOOD.food_5)
          .addOrderItem(_DATA_FOOD.food_3)
          .addOrderItem(_DATA_FOOD.food_3)
          .addOrderItem(_DATA_FOOD.food_3)
          .addOrderItem(_DATA_PRODUCT.product_12)
          .addOrderItem(_DATA_PRODUCT.product_12)
          .addOrderItem(_DATA_PRODUCT.product_8)
          .withPayment(
              new Payment("Tien Mat")
                  .withAmount(300)
                  .withTransactionDate("11/4/2021@10:20:20")
                  .
                  withTransactionType(Payment.TransactionType.Cash))
          .withPayment(
              new Payment("Banking")
                  .withAmount(2000)
                  .withTransactionDate("11/4/2021@10:20:20")
                  .
                  withTransactionType(Payment.TransactionType.CustomerCredit))
          .withTransactionDate("11/4/2021@10:20:20");

  public Order order_4 =
      new Order("order_4")
          .withEmployee(pParker)
          .withState(Order.State.DUE)
          .withCustomer(customer_5)
          .addOrderItem(_DATA_FOOD.food_2)
          .addOrderItem(_DATA_FOOD.food_5)
          .addOrderItem(_DATA_FOOD.food_3)
          .addOrderItem(_DATA_PRODUCT.product_1)
          .addOrderItem(_DATA_PRODUCT.product_3)
          .withPayment(
              new Payment("Tien Mat")
                  .withAmount(200)
                  .withTransactionDate("13/5/2021@12:20:20")
                  .
                  withTransactionType(Payment.TransactionType.Cash))
          .withPayment(
              new Payment("Banking")
                  .withAmount(200)
                  .withTransactionDate("13/5/2021@12:20:20")
                  .
                  withTransactionType(Payment.TransactionType.Cash))
          .withTransactionDate("12/04/2021@12:20:20");

  public Order order_5 =
      new Order("order_5")
          .withEmployee(pParker)
          .withState(Order.State.DUE)
          .withCustomer(customer_6)
          .addOrderItem(_DATA_FOOD.food_2)
          .addOrderItem(_DATA_FOOD.food_5)
          .addOrderItem(_DATA_FOOD.food_3)
          .addOrderItem(_DATA_PRODUCT.product_6)
          .addOrderItem(_DATA_PRODUCT.product_8)
          .addOrderItem(_DATA_PRODUCT.product_8)
          .withPayment(
              new Payment("Tien Mat")
                  .withAmount(200)
                  .withTransactionDate("14/3/2021@13:20:20")
                  .
                  withTransactionType(Payment.TransactionType.Cash))
          .withTransactionDate("14/03/2021@13:20:20");

  public Order order_6 =
      new Order("order_6")
          .withEmployee(pParker)
          .withCustomer(customer_6)
          .withState(Order.State.DUE)
          .addOrderItem(_DATA_FOOD.food_2)
          .addOrderItem(_DATA_FOOD.food_5)
          .addOrderItem(_DATA_FOOD.food_5)
          .addOrderItem(_DATA_FOOD.food_3)
          .addOrderItem(_DATA_PRODUCT.product_7)
          .addOrderItem(_DATA_PRODUCT.product_7)
          .addOrderItem(_DATA_PRODUCT.product_7)
          .addOrderItem(_DATA_PRODUCT.product_8)
          .withPayment(
              new Payment("Tien Mat")
                  .withAmount(200)
                  .withTransactionDate("15/2/2021@14:20:20")
                  .
                  withTransactionType(Payment.TransactionType.Cash))
          .withTransactionDate("15/04/2021@14:20:20");


  public Order[] ALL_ORDERS = {
    order_1, order_2, order_3, order_4, order_5, order_6
  };
}
