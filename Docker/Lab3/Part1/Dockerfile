FROM maven:3.9.9-eclipse-temurin-17

USER root

RUN groupadd --system appuser \
    && useradd --system --gid appuser --home-dir /app --shell /usr/sbin/nologin appuser \
    && mkdir -p /app \
    && chown -R appuser:appuser /app

WORKDIR /app

COPY --chown=appuser:appuser . .

USER appuser

RUN mvn -B package

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/calculator.jar"]
