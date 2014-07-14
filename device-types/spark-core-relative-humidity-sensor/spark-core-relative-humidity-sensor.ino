// Create a variable that will store the humidity value
int humidity = 0;

void setup()
{
  // Register a Spark variable here
  Spark.variable("humidity", &humidity, INT);

  // Connect the humidity sensor to A7 and configure it
  // to be an input
  pinMode(A0, INPUT);
}

void loop()
{
  // Keep reading the humidity so when we make an API
  // call to read its value, we have the latest one
  humidity = map(analogRead(A0), 0, 4095, 0, 99);
}
