Quarkus Kafka Event-Driven Tesla Project
========================
By Chebbah Mehdi and Zheng Florent


## Start the application

The application is composed of two applications communicating through Kafka.
Interactions with Kafka is managed by MicroProfile Reactive Messaging.

They can be started in dev mode using:

```bash
mvn -f producer quarkus:dev
```

and in another terminal:

```bash
mvn -f processor quarkus:dev
```

```bash
Or by simply running the 2 Quarkus services
```

Then, open your browser at `http://localhost:8080`.

## Warning


Wait the "prêt" status before launching another car to avoid errors.
