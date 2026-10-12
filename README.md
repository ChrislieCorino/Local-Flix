# LocalFlix - Netflix style local content clone

A streaming UI prototype built with Java/Spring Boot + HTML/CSS/JavaScript.

## Project structure
- `backend/` — Spring Boot REST API, intended for NetBeans.
- `frontend/` — responsive UI, intended for VS Code / Live Server.

## Requirements
- Java 17+
- Maven 3.9+ (NetBeans can use bundled Maven)
- VS Code + Live Server extension (optional)

## Run backend in NetBeans
1. Open NetBeans.
2. File → Open Project → select `backend`.
3. Run `LocalFlixApplication.java`.
4. API is available at `http://localhost:8080/api/movies`.

Command line alternative:
`cd backend && mvn spring-boot:run`

## Run frontend in VS Code
1. Open the `frontend` folder.
2. Install/use Live Server.
3. Right click `index.html` → Open with Live Server.
4. The frontend calls `http://localhost:8080/api`.

## Features
- Responsive Netflix-inspired grid
- Hero section
- Hover cards with trailer preview/action
- Search
- Category/genre filters
- My List/watchlist persisted in backend memory while the server is running
- Trailer modal using embedded demo trailers
- Sample local content catalogue

## API
- `GET /api/movies`
- `GET /api/movies?q=river`
- `GET /api/movies?category=Drama`
- `GET /api/movies/{id}`
- `GET /api/categories`
- `GET /api/watchlist`
- `POST /api/watchlist/{id}`

Drop a star if you like my project. Thank you
