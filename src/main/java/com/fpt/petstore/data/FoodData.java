package com.fpt.petstore.data;

import com.fpt.petstore.entities.Food;

public class FoodData {

  public Food food_1 =
          new Food("Ração Seca Nutrilus Pro+ Frango & Carne para Cães Adultos de Raças Médias e Grandes", 155)
                  .withType(Food.FoodType.DRY)
                  .withSortName("banh-thuong-cho-cho-dang-que")
                  .withDescription(
                          "Formulação premium com proteínas de alta qualidade, ideal para cães adultos de raças médias e grandes. Proporciona energia, músculos fortes e saúde geral, com um sabor irresistível de frango e carne.")
                  .withPic("food.jpg");

  public Food food_2 =
          new Food("Ração Premier Golden Formula Cães Adultos Frango e Arroz Mini Bits", 166)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Premier Golden Formula Cães Adultos Frango e Arroz Mini Bits")
                  .withDescription(
                          "Ideal para cães adultos de pequeno porte, com grãos menores que facilitam a mastigação. Feita com frango e arroz, oferece um sabor delicioso e nutrição completa.")
                  .withPic("food1.webp");
  public Food food_3 =
          new Food("Ração Royal Canin Maxi Adult para Cães Adultos Grandes a partir de 15 Meses de Idade", 383)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Royal Canin Maxi Adult para Cães Adultos Grandes a partir de 15 Meses de Idade")
                  .withDescription(
                          "Desenvolvida especialmente para cães de grande porte, esta ração promove saúde articular, digestão equilibrada e mantém a energia ideal. Ideal para cães a partir de 15 meses.")
                  .withPic("food2.webp");

  public Food food_4 =
          new Food("Ração Seca Nutrilus Light Frango para Cães Adultos Raças Médias e Grandes", 120)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Xuong-gam-sach-rang-cho-cho-vi-thit-bo")
                  .withDescription(
                          "Uma opção light, ideal para cães adultos de raças médias e grandes com tendência ao ganho de peso. Feita com frango, garante saciedade e saúde sem abrir mão do sabor.")
                  .withPic("food3.jpg");
  public Food food_5 =
          new Food("Ração Seca Nutrilus Pro+ Frango & Carne para Cães Adultos de Raças", 135)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Seca Nutrilus Pro+ Frango & Carne para Cães Adultos de Raças ")
                  .withDescription(
                          "Especialmente formulada para cães adultos de raças pequenas, combina frango e carne para atender às altas demandas energéticas desses pets com muita saúde e sabor.")
                  .withPic("food4.webp");
  public Food food_6 =
          new Food("Ração Seca PremieR Pet Golden Power Training Cães Filhotes Frango e Arroz - 15 Kg", 135)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Seca PremieR Pet Golden Power Training Cães Filhotes Frango e Arroz - 15 Kg")
                  .withDescription(
                          "Desenvolvida para filhotes em fase de crescimento, esta ração oferece energia, fortalecimento ósseo e suporte ao sistema imunológico. Feita com frango e arroz, é deliciosa e altamente nutritiva.")
                  .withPic("food5.jpg");
  public Food food_7 =
          new Food("Ração Seca Suprema Sabor Carne para Cães Adultos", 110)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Seca Suprema Sabor Carne para Cães Adultos")
                  .withDescription(
                          "Nutrição balanceada com sabor de carne suculenta, desenvolvida para atender às necessidades diárias de cães adultos. Combina sabor e benefícios para a saúde.")
                  .withPic("food6.webp");
  public Food food_8 =
          new Food("Ração Seca True para Gatos Adultos Castrados", 129)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Seca True para Gatos Adultos Castrados")
                  .withDescription(
                          "Nutrição premium com ingredientes naturais, desenvolvida para gatos castrados. Ajuda a manter o peso ideal, promove saúde urinária e oferece um sabor irresistível. ")
                  .withPic("food7.webp");
  public Food food_9 =
          new Food("Ração Seca Suprema Sabor Carne para Gatos Adultos", 100)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Seca Suprema Sabor Carne para Gatos Adultos")
                  .withDescription(
                          "Oferece nutrição equilibrada com sabor de carne irresistível. Ideal para gatos adultos, ajudando a manter energia e saúde no dia a dia.")
                  .withPic("food8.jpg");

  public Food food_10 =
          new Food(
                  "Ração Seca PremieR Pet Golden Gatos Adultos Castrados Carne", 104)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Seca PremieR Pet Golden Gatos Adultos Castrados Carne")
                  .withDescription(
                          "Nutrição balanceada com sabor de carne, desenvolvida para gatos castrados. Ajuda no controle do peso e na saúde do trato urinário com muita palatabilidade.")
                  .withPic("food9.jpg");

  public Food food_11 =
          new Food("Ração Seca Nutrilus Pro+ Salmão para Gatos Adultos Castrados", 114)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Seca Nutrilus Pro+ Salmão para Gatos Adultos Castrados")
                  .withDescription(
                          "Feita com salmão de alta qualidade, esta ração é ideal para gatos castrados. Fornece suporte ao controle de peso e saúde do trato urinário, além de ter um sabor delicioso.")
                  .withPic("food10.webp");
  public Food food_12 =
          new Food(
                  "Ração Seca Nutrilus Pro+ Frango para Gatos Adultos Castrados",
                  119)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Seca Nutrilus Pro+ Frango para Gatos Adultos Castrados")
                  .withDescription(
                          "Especialmente desenvolvida para gatos castrados, com frango como principal ingrediente. Promove a saúde urinária e ajuda no controle de peso com uma fórmula saborosa e nutritiva.")
                  .withPic("food11.jpg");
  public Food food_13 =
          new Food("Ração Seca Nutrilus Pro+ Carne para Gatos Adultos", 89)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Seca Nutrilus Pro+ Carne para Gatos Adultos")
                  .withDescription(
                          "Uma opção rica em proteínas e sabor de carne, ideal para gatos adultos. Oferece nutrição completa para manter a vitalidade e o bem-estar.")
                  .withPic("food12.webp");
  public Food food_14 =
          new Food(
                  "Ração Guabi Natural Frango e Arroz Integral para Gatos Adultos Castrados", 150)
                  .withType(Food.FoodType.DRY)
                  .withSortName("Ração Guabi Natural Frango e Arroz Integral para Gatos Adultos Castrados")
                  .withDescription("Ingredientes naturais, como frango e arroz integral, oferecem uma alimentação saudável e completa. Ideal para gatos castrados, ajudando no controle de peso e na saúde urinária.")
                  .withPic("food13.jpg");

  public Food[] ALL_FOODS = {
          food_1, food_2, food_3, food_4, food_5, food_6, food_7, food_8, food_9, food_10, food_11,
          food_12, food_13, food_14
  };
}
