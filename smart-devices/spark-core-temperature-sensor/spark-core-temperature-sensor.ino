// Create a variable that will store the temperature value
int temperature = 0;

void setup()
{
  // Register a Spark variable here
  Spark.variable("temperature", &temperature, INT);

  // Connect the temperature sensor to A7 and configure it
  // to be an input
  pinMode(A0, INPUT);
}

void loop()
{
  // Keep reading the temperature so when we make an API
  // call to read its value, we have the latest one
  temperature = map(analogRead(A0), 0, 4095, 0, 99);
}
