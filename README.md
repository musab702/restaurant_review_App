# 🍽️ Restaurant Review Platform

A full-stack restaurant review application built with modern technologies, featuring powerful search capabilities, geolocation services, and comprehensive user management.

![Tech Stack](https://img.shields.io/badge/Frontend-Next.js%2014-blue) ![Backend](https://img.shields.io/badge/Backend-Spring%20Boot%203.4-green) ![Database](https://img.shields.io/badge/Database-Elasticsearch%208.12-orange) ![Auth](https://img.shields.io/badge/Auth-Keycloak%20OAuth2-red)

## 🚀 Features

### Core Functionality
- **Restaurant Discovery**: Search and browse local restaurants with advanced filtering
- **Review System**: Create, read, update, and delete restaurant reviews with ratings
- **Photo Management**: Upload and manage restaurant and review photos
- **Geolocation Services**: Find restaurants by location with radius-based search
- **User Authentication**: Secure OAuth2 authentication with Keycloak
- **Real-time Search**: Elasticsearch-powered search with text matching and geo-queries

### Advanced Features
- **Responsive Design**: Modern UI built with React, Next.js, and Tailwind CSS
- **Interactive Maps**: OpenStreetMap integration for restaurant locations
- **Rating Aggregation**: Automatic calculation of average restaurant ratings
- **Pagination**: Efficient handling of large datasets
- **File Upload**: Secure photo upload and storage system
- **RESTful API**: Clean, well-documented API endpoints

## 🏗️ Architecture

### Tech Stack

#### Frontend
- **Framework**: Next.js 14 with React 18
- **Styling**: Tailwind CSS with custom components
- **UI Components**: Radix UI primitives with shadcn/ui
- **State Management**: React Context API
- **Forms**: React Hook Form with Zod validation
- **Authentication**: react-oidc-context for OAuth2 integration
- **Maps**: Leaflet.js for interactive maps
- **HTTP Client**: Axios for API communication

#### Backend
- **Framework**: Spring Boot 3.4.4 with Java 21
- **Security**: Spring Security with OAuth2 Resource Server
- **Database**: Elasticsearch 8.12.0 for document storage and search
- **Data Mapping**: MapStruct for DTO/Entity conversions
- **Validation**: Jakarta Bean Validation
- **Storage**: File system storage for photos
- **Build Tool**: Maven

#### Infrastructure
- **Authentication**: Keycloak 23.0 as OAuth2/OIDC provider
- **Search & Analytics**: Elasticsearch with Kibana dashboard
- **Containerization**: Docker Compose for local development
- **Data Persistence**: Docker volumes for Elasticsearch and Keycloak data

### Project Structure

```
restaurant_review_App/
├── frontend/                    # Next.js frontend application
│   ├── app/                    # App Router pages and layouts
│   ├── components/             # Reusable React components
│   ├── services/               # API service layer
│   ├── providers/              # Context providers
│   └── domain/                 # TypeScript type definitions
├── restaurantReview/           # Spring Boot backend application
│   └── src/main/java/
│       ├── controllers/        # REST API endpoints
│       ├── services/           # Business logic layer
│       ├── domain/            # Entities and DTOs
│       ├── mappers/           # MapStruct mappers
│       └── config/            # Configuration classes
└── docker-compose.yaml        # Infrastructure setup
```

## 🛠️ Installation & Setup

### Prerequisites
- **Java 21** or higher
- **Node.js 18** or higher
- **Docker & Docker Compose**
- **Maven 3.6+**

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/restaurant_review_App.git
cd restaurant_review_App
```

### 2. Start Infrastructure Services
```bash
# Start Elasticsearch, Kibana, and Keycloak
docker-compose up -d

# Verify services are running
docker-compose ps
```

**Service URLs:**
- Elasticsearch: http://localhost:9200
- Kibana Dashboard: http://localhost:5601
- Keycloak Admin: http://localhost:9090 (admin/admin)

### 3. Configure Keycloak

1. Access Keycloak Admin Console: http://localhost:9090
2. Login with `admin/admin`
3. Create a new realm called `restaurant-review`
4. Configure OAuth2 clients for the frontend and backend applications
5. Set up users and roles as needed

### 4. Start Backend Application
```bash
cd restaurantReview
mvn clean install
mvn spring-boot:run
```

The backend API will be available at: http://localhost:8080

### 5. Start Frontend Application
```bash
cd frontend
npm install
npm run dev
```

The frontend will be available at: http://localhost:3000

## 📚 API Documentation

### Restaurant Endpoints
- `GET /api/restaurants` - Search restaurants with filters
- `GET /api/restaurants/{id}` - Get restaurant details
- `POST /api/restaurants` - Create new restaurant (authenticated)
- `PUT /api/restaurants/{id}` - Update restaurant (authenticated)

### Review Endpoints
- `GET /api/restaurants/{restaurantId}/reviews` - List restaurant reviews
- `GET /api/restaurants/{restaurantId}/reviews/{reviewId}` - Get specific review
- `POST /api/restaurants/{restaurantId}/reviews` - Create review (authenticated)
- `PUT /api/restaurants/{restaurantId}/reviews/{reviewId}` - Update review (authenticated)
- `DELETE /api/restaurants/{restaurantId}/reviews/{reviewId}` - Delete review (authenticated)

### Photo Endpoints
- `GET /api/photos/{id}` - Retrieve photo
- `POST /api/photos` - Upload photo (authenticated)

### Search Parameters
- `q` - Text search query
- `minRating` - Minimum rating filter
- `latitude` & `longitude` - Geolocation search
- `radius` - Search radius in kilometers
- `page` & `size` - Pagination parameters

## 🔧 Configuration

### Backend Configuration
```properties
# application.properties
spring.application.name=restaurant
spring.elasticsearch.uris=http://localhost:9200
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:9090/realms/restaurant-review
```

### Environment Variables
- `ELASTICSEARCH_URIS` - Elasticsearch connection string
- `KEYCLOAK_ISSUER_URI` - Keycloak realm issuer URI
- `STORAGE_LOCATION` - Photo upload directory (default: uploads/)

## 🚦 Development

### Frontend Development
```bash
cd frontend
npm run dev          # Start development server
npm run build        # Build for production
npm run lint         # Run ESLint
npm run format       # Format code with Prettier
```

### Backend Development
```bash
cd restaurantReview
mvn spring-boot:run  # Start development server
mvn test            # Run tests
mvn clean package   # Build JAR
```

### Database Management
- **Kibana**: Use http://localhost:5601 for Elasticsearch data visualization
- **Index Management**: Elasticsearch automatically creates indexes for restaurants
- **Data Import**: Use the test data loader for sample restaurants

## 🎯 Key Features Explained

### 1. Search Functionality
The application uses Elasticsearch for powerful search capabilities:
- **Full-text search** across restaurant names and descriptions
- **Geospatial queries** for location-based searches
- **Aggregation queries** for rating statistics
- **Filtering** by cuisine type, rating, and location

### 2. Authentication & Authorization
OAuth2/OIDC implementation with Keycloak:
- **JWT tokens** for stateless authentication
- **Role-based access control** for different user types
- **Secure API endpoints** with Spring Security
- **Frontend integration** with react-oidc-context

### 3. Photo Management
File upload and storage system:
- **Multipart file upload** with validation
- **File system storage** with UUID-based naming
- **Image serving** with proper content types
- **Photo association** with restaurants and reviews

### 4. Geolocation Services
Location-based features:
- **Address geocoding** for restaurant locations
- **Radius-based search** to find nearby restaurants
- **Interactive maps** with Leaflet.js integration
- **GeoPoint** storage in Elasticsearch

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- **Spring Boot** team for the excellent framework
- **Next.js** team for the powerful React framework
- **Elasticsearch** for search capabilities
- **Keycloak** for authentication services
- **Radix UI** and **shadcn/ui** for UI components
- **OpenStreetMap** for mapping services

## 📞 Support

For support, email [your-email@example.com] or create an issue in the repository.

---

**Built with ❤️ using Spring Boot, Next.js, and Elasticsearch**