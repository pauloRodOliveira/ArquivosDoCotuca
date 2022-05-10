#include Ultrasoni.h
Ultrasonic ultrasonic(5,4);


int sensor = A0;

int led = 2;

int  ledVerde = 3;

int limiteDeDisparo = 600;

int sensorValue = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(led, OUTPUT);
  pinMode(ledVerde, OUTPUT);
  pinMode(sensor, INPUT);

  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  sensorValue = analogRead(sensor);

  if(sensorValue < limiteDeDisparo){
    digitalWrite(led, HIGH);
    digitalWrite(ledVerde, LOW);
  }else{
    digitalWrite(led, LOW);
    digitalWrite(ledVerde, HIGH);
  }

  Serial.print("Leitura atual do sensor: " + sensorValue);
 }
