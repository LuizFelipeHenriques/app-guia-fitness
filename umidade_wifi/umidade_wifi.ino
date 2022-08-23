#include <WiFi.h>
#include <WiFiMulti.h>
#include <PubSubClient.h>


#define pinSensorA 33
//#define pinSensorD 14


WiFiClient espClient;
PubSubClient client(espClient);
WiFiMulti wifiMulti;


const char* mqttServer = "mqtt.tago.io";// Servidor MQTT
const int mqttPort = 1883;// porta MQTT // pode ser passado qualquer valor como user
const char* mqttUser = "Default"; // Token do device no Tago.io
const char* mqttPassword = "b8f7aa38-696a-4206-8020-0fe9699c4fe8";
char topic[] = "tago/data/post";// Tópico MQTT a ser enviado para o Tago.io
char mytopic[] = "tago/my_topic";// Tópico MQTT a ser enviado para o Tago.io

int porta_rele1 = 26;
float umidade;
float temperatura;
int luminosidade;
String str_umi = "umidade";
#define LED 2


long previewMillis;
#define tempoMQTT  2000
bool estado = false;


void setup() {
 // pinMode(pinSensorD, INPUT);
  pinMode(porta_rele1, OUTPUT); 
  setupWifi();
  setupCliente();
  Serial.begin(115200);
}



void loop() {
  digitalWrite(porta_rele1, LOW);
  client.loop();
    long currentMillis =  millis();
  int  umidade = (analogRead(pinSensorA));
   int umidade_percentual = map(umidade, 4095, 1820, 0, 100);

  if (currentMillis - previewMillis > tempoMQTT) {
    previewMillis = currentMillis;
    verificaWifi();
    verificaCliente();
  
    enviaDado(str_umi, umidade_percentual);
if (umidade_percentual < 50) {
  digitalWrite(porta_rele1, HIGH);
  delay(10000);
}
  }
}


void enviaDado(String variable, float dado) {
  String dadoString = String(dado);
  String dadoXXX = "[{\"variable\":\"" + variable + "\",\"value\":" + dadoString + "}]";
  Serial.print("Enviando payload: ");
  Serial.println(dadoXXX);
  if (client.publish(topic, (char*) dadoXXX.c_str())) {
    Serial.println(String("Publish  " + dadoXXX + " "));
  } else {
    Serial.println(String("Publish " + dadoXXX + " failed"));
  }
}
