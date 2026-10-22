FROM python:3.12-slim

WORKDIR /app

COPY PythonApp/requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY PythonApp/app.py .

EXPOSE 5000

CMD ["python", "app.py"]
