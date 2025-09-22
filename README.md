# 🏋️ GymGenius Backend (Spring Boot + PostgreSQL)

## 📌 Overview

GymGenius is a **Health & Fitness Tracker** focusing on **training splits, workout progress, and nutrition tracking**. The backend is built with **Spring Boot** and **PostgreSQL**, providing secure APIs for user authentication, workout management, and progress tracking.

---

## 🔹 Core Features

### 1. User Authentication & Profiles

* **JWT Authentication** with Spring Security.
* Endpoints for **Sign up / Login / Logout**.
* User profile includes:

  * Weight
  * Height
  * Age
  * Fitness goal (bulking / cutting / maintenance).

### 2. Training Splits & Workout Plans

* Predefined templates:

  * Push/Pull/Legs
  * Upper/Lower
* Users can **create custom workout plans**.
* Track **sets, reps, and weights** per exercise.

### 3. Progress Tracking

* **Weight tracking graph** (time-series data).
* **Personal records** (1RM, max sets/reps for each lift).
* **Calendar view** of completed workouts.

### 4. Nutrition & Meal Logging *(Optional Feature)*

* Set **daily calorie & macro goals**.
* Log meals and calculate:

  * Calories
  * Protein
  * Carbs
  * Fats

---

## 🛠️ Tech Stack

* **Spring Boot** (REST API, service layer).
* **PostgreSQL** (relational database).
* **Spring Security + JWT** (authentication).
* **Hibernate/JPA** (ORM).
* **Lombok** (boilerplate reduction).

---

## 📂 Project Structure

```
gymgenius-backend/
 ┣ 📂 src/main/java/com/gymgenius
 ┃ ┣ 📂 config        # Security + JWT Config
 ┃ ┣ 📂 controllers  # REST API Controllers
 ┃ ┣ 📂 dto          # Request/Response DTOs
 ┃ ┣ 📂 entities     # JPA Entities (User, Workout, Exercise...)
 ┃ ┣ 📂 repositories # Spring Data JPA Repositories
 ┃ ┣ 📂 services     # Business Logic
 ┃ ┗ 📂 utils        # Utility Classes (JWT, Validation)
 ┣ 📂 src/main/resources
 ┃ ┣ application.yml # DB + Security configs
 ┗ pom.xml
```



