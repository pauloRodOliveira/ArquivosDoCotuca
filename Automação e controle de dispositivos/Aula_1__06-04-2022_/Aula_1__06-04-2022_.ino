/*
  Primeira aula de DS304

  ALUNO: PAULO RODRIGUES
  PROFESSOR: SÉRGIO MARQUES
*/

#define MainLed 13
#define out OUTPUT
#define begin {
#define end }
int led2 = 13;
#define On digitalWrite(led2, HIGH);
#define Off digitalWrite(led2, LOW);
int contadorVezes = 10;
bool qualLed = true;

void setup()
  begin
    pinMode(MainLed, out); // Define if the door is output or input.
  end

void loop(){
    while(contadorVezes > 0){
      On;
      delay(1000);
      Off;
      delay(1000);
      contadorVezes--;
    }
  
    if(qualLed){
      led2 = 12;
    }else{
      led2 = 13;
    }
    qualLed = !qualLed;
  }
