docker build -t app-image . && docker run -d -p 8080:8082 --name app-container app-image