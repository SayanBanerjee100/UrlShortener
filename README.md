🔗 URLShortener — Scalable Spring Boot Backend

A backend service built using **Spring Boot** that converts long URLs into short, shareable links with analytics tracking.

This project demonstrates backend engineering concepts including **REST API design, database modeling, redirection logic, layered architecture, and scalable service design using MongoDB**.

---

🚀 Features

```
🔗 Generate Short URLs for long links
🔁 Automatic Redirect to original URL
📊 Click Analytics tracking
🗄 MongoDB Document Persistence
🧱 Layered Architecture (Controller → Service → Repository)
⚡ Base62 Short Code Generation
🐳 Dockerized Backend Service
📬 REST API Testing via Postman
🧩 Clean modular backend structure
```

---

🧠 Architecture

The application follows a **clean backend layered architecture** similar to production backend systems.

Client
↓
Controller Layer (REST APIs)
↓
Service Layer (Business Logic)
↓
Repository Layer (MongoDB Access)
↓
MongoDB Database

Layers

| Layer      | Responsibility                                    |
| ---------- | ------------------------------------------------- |
| Controller | Handles HTTP requests/responses                   |
| Service    | Business logic (short code generation & redirect) |
| Repository | MongoDB database interaction                      |
| Utility    | Short code generation logic                       |
| Database   | Persistent storage of URL mappings                |

---

🔄 URL Shortening Workflow

```
Client sends a long URL to /api/shorten
Server generates a unique short code
Mapping is stored in MongoDB
Short URL is returned to the client
When user visits short URL → system redirects to original URL
Click analytics are updated
```

Example:

Long URL

https://google.com

Generated Short URL

http://localhost:8080/api/abc123

---

🛠 Tech Stack

```
Java 17
Spring Boot
Spring Web (REST APIs)
MongoDB
Maven
Docker
Postman (API Testing)
```

---

📂 Project Structure

src/main/java/.../urlshortener
│
├── controller      → REST endpoints
├── service         → business logic
├── repository      → MongoDB repositories
├── model           → database entities
├── dto             → request/response objects
├── util            → short code generator
├── config          → caching / configuration
└── exception       → global exception handling

---

📬 API Endpoints

1️⃣ Create Short URL

POST /api/shorten

Request

{
"originalUrl": "https://google.com"
}

Response

{
"shortUrl": "http://localhost:8080/api/abc123"
}

---

2️⃣ Redirect to Original URL

GET /api/{shortCode}

Example

GET /api/abc123

Behavior

Redirects the user to the original URL stored in MongoDB.

---

3️⃣ Get URL Analytics

GET /api/stats/{shortCode}

Example

GET /api/stats/abc123

Response

{
"originalUrl": "https://google.com",
"clicks": 5,
"createdAt": "2026-03-05T10:30:00"
}

---

🗄 Database Schema

MongoDB Collection: `url_mapping`

Example document:

{
"id": "12345",
"originalUrl": "https://google.com",
"shortCode": "abc123",
"clickCount": 5,
"createdAt": "2026-03-05T10:30:00"
}

---

⚙️ Running Locally

1️⃣ Clone Repository

git clone <repo-url>

cd url-shortener

---

2️⃣ Start MongoDB

Make sure MongoDB is running locally on:

mongodb://localhost:27017

---

3️⃣ Run Spring Boot Application

./mvnw spring-boot:run

Application runs at:

http://localhost:8080

---

🐳 Docker Setup

Build image:

docker build -t url-shortener .

Run container:

docker run -p 8080:8080 url-shortener

Docker ensures consistent runtime across environments.

---

📬 API Testing (Postman Flow)

```
Create Short URL
POST /api/shorten

Copy returned short URL

Test redirect
GET /api/{shortCode}

Check analytics
GET /api/stats/{shortCode}
```

---

🎯 Learning Goals

This project was built to understand:

```
REST API design using Spring Boot
Backend system design concepts
MongoDB data persistence
URL redirection mechanisms
Scalable service architecture
Containerized backend deployment
```

---

👨‍💻 Author

Sayan Banerjee

Backend Developer | Java & Spring Boot Enthusiast
GDG Hackathon Team Lead — Top 10 out of 300 teams

---

📄 License

This project is for educational and learning purposes.
