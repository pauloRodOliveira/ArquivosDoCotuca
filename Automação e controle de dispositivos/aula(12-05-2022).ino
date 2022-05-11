#include <LiquidCrystal.h>
 
//Define os pinos que serão utilizados para ligação ao display
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
 
void setup()
{
  //Define o número de colunas e linhas do LCD
  lcd.begin(16, 2);
}
 
void loop()
{
  lcd.clear();
  for(int i = 0; i < 6; i++){
    lcd.setCursor(5+i, 0);
    lcd.print("COTUCA");
    lcd.setCursor(10-i, 1);
    lcd.print("CAMPINAS");
    delay(300);
    lcd.clear();
  }

  for(int i = 0; i <= 10; i++){
   
    lcd.setCursor(10-i, 0);
    lcd.print("COTUCA");
    delay(300);
    lcd.clear();
  }

   for(int i = 0; i < 16; i++){
    lcd.setCursor(5-i, 1);
    lcd.print("CAMPINAS");
    delay(300);
    lcd.clear();
  }
   
  //Rolagem para a esquerda
  /*for (int posicao = 0; posicao < 3; posicao++)
  {
    lcd.setCursor(4, 1).scrollDisplayLeft();
    delay(300);
  }
   
  //Rolagem para a direita
  for (int posicao = 0; posicao < 6; posicao++)
  {
    lcd.scrollDisplayRight();
    delay(300);
  }*/
}