FROM eclipse-temurin:17-jre-noble

USER root

RUN groupadd --system appuser \
    && useradd --system --gid appuser --home-dir /app --shell /usr/sbin/nologin appuser \
    && mkdir -p /app \
    && chown -R appuser:appuser /app

WORKDIR /app

COPY --chown=appuser:appuser calculator.jar /app/calculator.jar

USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "calculator.jar"]
