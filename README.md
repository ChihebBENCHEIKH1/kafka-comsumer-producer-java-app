# Kafka Consumer-Producer Java App

The Kafka Consumer-Producer Java App is a simple application that demonstrates the basic functionality of Apache Kafka by implementing a consumer and producer using Java.

## Prerequisites

Before running the Kafka Consumer-Producer Java App, ensure that you have the following prerequisites:

- Apache Kafka installed and running.
- Java Development Kit (JDK) installed on your machine.
- Knowledge of Kafka topics and how to create them.

## Setup

1. Clone the repository or download the source code.

2. Open the project in your preferred Java IDE.

3. Make sure to have the required Kafka dependencies added to your project's build path.

## Configuration

1. Open the `config.properties` file.

2. Update the Kafka broker details, such as bootstrap servers, topic names, and any other required configuration.

## Usage

1. Start the Kafka broker and create the necessary Kafka topics.

2. Run the application.

3. The application acts as both a consumer and producer.

   - As a consumer, it will start listening for messages on the specified Kafka topic and display them in the console.
   - As a producer, it will prompt you to enter messages to send to the Kafka topic.

4. Enter messages to be sent as a producer, and observe them being consumed and displayed in the console.

5. Use Ctrl+C to stop the application and exit.

## Example

Here's an example of how the Kafka Consumer-Producer Java App works:

1. Start the Kafka broker and create a topic called "my_topic".

2. Run the application.

3. As a consumer, the app starts listening to "my_topic" and displays any received messages in the console.

4. As a producer, enter messages such as "Hello, Kafka!" or "This is a test message." into the console.

5. Observe how the messages you entered are consumed by the app and displayed in the console.

6. Stop the application using Ctrl+C.

## Contributing

Contributions to the Kafka Consumer-Producer Java App are welcome. If you have any ideas, bug fixes, or improvements, feel free to submit a pull request.

When contributing, please adhere to the following guidelines:
- Follow the existing code style and conventions.
- Clearly document any significant changes or new features.
- Test your changes thoroughly before submitting a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
