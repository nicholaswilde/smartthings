// Create a variable that will store the illuminance value
int illuminance = 0;

void setup()
{
  // Register a Spark variable here
  Spark.variable("illuminance", &illuminance, INT);

  // Connect the illuminance sensor to A7 and configure it
  // to be an input
  pinMode(A0, INPUT);
}

void loop()
{
  // Keep reading the temperature so when we make an API
  // call to read its value, we have the latest one
  illuminance = map(analogRead(A0), 0, 4095, 0, 99);
}
