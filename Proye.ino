#include <dht.h>

#define RLOAD 22.0
#define RZERO 879.13 
#include "MQ135.h" 
dht DHT;
#define dht_temp A3
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27,20,4);

long tiempo;
int disparo = 2;   
int echo = 3;      
float distancia;
MQ135 gasSensor = MQ135(A0); 
int val; 
int sensorPin = A0; 
int sensorValue = 0; 


void setup() { 
        lcd.init();
    lcd.backlight();
   lcd.setCursor(10, 0);
  Serial.begin(9600);
    pinMode(disparo, OUTPUT);
  pinMode(echo, INPUT);
  digitalWrite(disparo, LOW);
  pinMode(sensorPin, INPUT); 
} 

void loop() { 
  val = analogRead(A0); 
  float ppm = gasSensor.getPPM(); 
  Serial.print ("ppm: "); 
  Serial.println (ppm); 
  delay(1000); 
  digitalWrite(disparo, HIGH); //Se envia el pulso de activacion del sensor
  delayMicroseconds(10);
  digitalWrite(disparo, LOW); 
  tiempo = pulseIn(echo, HIGH); // Obtengo el tiempo del sensor
  distancia = 0.0343*tiempo/2; //Calculo la distancia
  Serial.print(distancia);
  Serial.println("cm");//Muestro la distancia en el monitor serie
  delay(1000);
  
  //TEMPERATURA//
   DHT.read11(dht_temp);
  Serial.print("Temperatura = ");
  Serial.print(DHT.temperature);
  Serial.println(" C");
  //HUMEDAD RELATIVA//
  Serial.print("Humedad = ");
  Serial.print(DHT.humidity);
  Serial.println(" %");
  delay(1000);
 sensorValue = map(analogRead(A1), 0, 1023, 0, 100);
  Serial.print("Umbral de Ruido :");
  Serial.print(sensorValue); 
   Serial.println(" %");
     delay(1000);
  lcd.setCursor(0,0);
   lcd.print("d:");
      lcd.print(distancia);
        delay(100);
        lcd.setCursor(6,0);
       
   lcd.print("G:");
      lcd.print(ppm);
  delay(100);
      lcd.setCursor(12,0);
    
   lcd.print("R:");
      lcd.print(sensorValue);
       delay(100);
         lcd.setCursor(0,1);
   
   lcd.print("T: ");
      lcd.print(DHT.temperature);
      lcd.setCursor(8,1);
      lcd.print("H: ");
      lcd.print(DHT.humidity);
      lcd.print(" %");
        delay(100);
}
