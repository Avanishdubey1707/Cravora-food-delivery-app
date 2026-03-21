# 🍔 Cravora – Food Delivery Application

Cravora is a full-stack food delivery web application that allows users to browse food items, place orders, and manage their accounts seamlessly. It is built using modern technologies with a focus on scalability, security, and user experience.

---

## 🚀 Features

* 🔐 User Authentication (JWT-based login/signup)
* 🍽️ Browse and search food items
* 🛒 Add to cart and manage orders
* 💳 Online payment integration (Razorpay - Test Mode)
* 📦 Order placement and tracking (basic)
* 👨‍💼 Admin functionalities (add/update food items)
* 🌐 Fully responsive UI

---

## 🛠️ Tech Stack

### Frontend

* React.js
* JavaScript (ES6+)
* Axios
* CSS / Bootstrap

### Backend

* Spring Boot
* Spring Security
* JWT Authentication
* RESTful APIs

### Database

* MongoDB (Local)

### Deployment

* Render (Backend + Frontend)

---

## 📂 Project Structure

```
Cravora-food-delivery-app/
│
├── frontend/          # React application
│   ├── src/
│   └── components/
│
├── backend/           # Spring Boot application
│   ├── config/
│   ├── controller/
│   ├── service/
│   ├── model/
│   └── repository/
│
├── .gitignore
├── README.md
└── pom.xml
```

---

## ⚙️ Installation & Setup

### 1️⃣ Clone the repository

```bash
git clone https://github.com/Avanishdubey1707/Cravora-food-delivery-app.git
cd Cravora-food-delivery-app
```

---

### 2️⃣ Backend Setup (Spring Boot)

```bash
cd backend
```

* Configure `application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/cravora
jwt.secret.key=your_secret_key
```

* Run the application:

```bash
mvn spring-boot:run
```

---

### 3️⃣ Frontend Setup (React)

```bash
cd frontend
npm install
npm start
```

---

## 🔐 Environment Variables

Create `.env` file (Frontend):

```
REACT_APP_API_URL=http://localhost:8080
REACT_APP_RAZORPAY_KEY=your_test_key
```

---

## 🌍 Deployment

The application can be deployed using:

* Render (Backend + Frontend)
* MongoDB Atlas (Recommended for production)

---

## ⚠️ Known Issues

* ❗ 403 Forbidden error (Spring Security configuration)
* ❗ MongoDB local setup not suitable for production
* ❗ Sensitive keys should not be exposed in code

---

## 🚀 Future Improvements

* 📍 Real-time order tracking (Maps integration)
* 🤖 AI-based food recommendation system
* 📊 Admin dashboard with analytics
* 🔔 Push notifications
* 🧾 Order history with invoice download

---

## 👨‍💻 Author

**Avanish Dubey**

* 💼 AI Engineer | Java Developer | ML Enthusiast
* 🔗 GitHub: https://github.com/Avanishdubey1707

---

## ⭐ Contributing

Contributions are welcome!
Feel free to fork the repo and submit a pull request.

---

## 📄 License

This project is open-source and available under the MIT License.

---

## 💬 Feedback

If you have any feedback or suggestions, feel free to reach out!

---
