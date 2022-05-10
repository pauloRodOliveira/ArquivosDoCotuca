/*
  AULA DE PROTOTIPAGEM DE DISPOSITIVOS DO DIA 13-04-2022

  PROFESSOR: Sérgio Marques
*/

int pinos[8] = {3,4,5,6,7,8,9,10};
int mainLed = 0;

void setup() {
  pinMode(2, OUTPUT);
  
  for(int pinoDaVez = 0; pinoDaVez <= 7; pinoDaVez++){
    pinMode(pinos[pinoDaVez], OUTPUT);
  }
  
}

void loop() {
  digitalWrite(2, HIGH);
  delay(500);
  digitalWrite(2, LOW);

  
  for(int pinoDaVez = 0; pinoDaVez <= 3; pinoDaVez++){
    mainLed = pinos[pinoDaVez];
    digitalWrite(mainLed, HIGH);
    delay(100);
    digitalWrite(mainLed, LOW);
    delay(100);
  }

  for(int pinoDaVez = 7; pinoDaVez >= 4; pinoDaVez--){
    mainLed = pinos[pinoDaVez];
    digitalWrite(mainLed, HIGH);
    delay(100);
    digitalWrite(mainLed, LOW);
    delay(100);
  }
}
