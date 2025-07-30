# 🚗 Smart Ride-Sharing System

## 📘 Overview

This project simulates a **digital ride-sharing platform** for the city of **Codetropolis**, focusing on modular design and real-world system behavior. It handles user registration, ride requests, matching, trip management, fare calculation, feedback, analytics, and error handling — all within a predefined simulation.

Designed using **object-oriented principles**, this system ensures scalability, separation of concerns, and robustness, making it an ideal blueprint for real-world ride-hailing platforms.

---

## ✅ Features

- 👥 **User Roles:** Riders and Drivers with relevant attributes and histories
- 🚘 **Vehicle Types:** Each driver owns a unique vehicle of a specific type (e.g., SEDAN, SUV, BIKE)
- 📍 **Ride Request & Matching:** Based on vehicle preference and availability
- 🔄 **Ride Lifecycle:** From request to completion or cancellation, with status tracking
- 💰 **Flexible Fare Calculation:** Based on vehicle type with future extensibility (peak pricing, loyalty, etc.)
- 🌟 **Feedback & Ratings:** After each completed ride
- 📊 **Analytics:** Ride counts, top-rated drivers, ride history, and data filtering
- ⚠️ **Error Handling:** For invalid inputs, unavailable drivers, and missing data
- 🧩 **Modular Design:** Separate services for matching, billing, reporting, etc.

---

## 🛠 Tech Stack

- Language: Java (or specify your language)
- Concepts Used: 
  - Object-Oriented Programming
  - Encapsulation, Inheritance, Polymorphism
  - Streams/Filters (if using Java)
  - Optional Data Handling
  - Exception Management

---

## 💡 Simulation Highlights

- Minimum 2 riders and 3 drivers initialized
- 2 completed rides and 1 canceled ride
- Includes:
  - Optional field handling (missing email)
  - Lookup failure error
  - Sorting and filtering via custom queries

---

## 🧪 Sample Output

--- Initializing System ---

Driver Registered: Alice [Rating: 3.75 | Vehicle: SEDAN | Plate Number: AL1234
Driver Registered: Charlie [Rating: 4.25 | Vehicle: XUV | Plate Number: BO9987
Driver Registered: Darcy [Rating: 4.0 | Vehicle: BIKE | Plate Number: CL5678
Rider Registered: Namya [Email: Optional[namya@123]]
Rider Registered: Emma [Email: Optional[bob@123]]

------------------------------------------------------
The balance of rider Namya is recharged with Rs.100.0
New balance is 100.0

Invalid Input: Pickup and drop locations must be provided.

------------------------------------------------------
The balance of rider Namya is recharged with Rs.100.0
New balance is 200.0

Namya requested a SEDAN from 'Airport' to 'City Center'
Searching for available drivers...
Driver matched: Alice (SEDAN)
Driver Alice accepted the ride
Ride ID RIDE1 is now ONGOING
Driver Alice completed the ride
Ride completed successfully
Fare: ₹20.0
The fare amount is deducted from account of user
New balance is 180.0
The fare of Rs. 20.0is credited in account of  Alice
New balance of driver is 20.0
Transaction sucessfull!!

Feedback recorded: 5.0 stars
New average rating of driver Alice is : 4.166666666666667

------------------------------------------------------
--- Reporting & Analytics ---
✅ Total Rides Completed: 2
✅ Total Rides Cancelled: 0
Top Driver is: Charlie (4.25)

Namya's Ride History:
- RIDE1 | Destination: City Center | Vehicle: SEDAN | Fare: ₹20.0

Emma's Ride History:
- RIDE2 | Destination: Hotel Grand | Vehicle: BIKE | Fare: ₹16.0

Available Drivers:
- Alice [SEDAN]
- Charlie [XUV]
- Darcy [BIKE]

------------------------------------------------------
--- Data Queries (Streams & Filters) ---

Riders with names starting with 'E': 
Emma

Drivers sorted by rating: 
Charlie - 4.25
Alice - 4.166666666666667
Darcy - 4.0

Rides by Vehicle Type: 
SEDAN : 1
BIKE : 1


## 🚦 System Components

| Component         | Responsibility                                     |
|------------------|-----------------------------------------------------|
| `User`            | Abstract base class for Rider and Driver           |
| `Rider`           | Stores ride history, contact info, ride requests   |
| `Driver`          | Stores rating, vehicle details, performance data   |
| `Vehicle`         | Represents a driver’s vehicle (type, plate)        |
| `Ride`            | Tracks status, fare, feedback, and transitions     |
| `RideManager`     | Handles matching, lifecycle, and analytics         |
| `FareCalculator`  | Calculates fare based on vehicle type              |
| `DataQueryService`| Provides filtering and sorting functionalities     |
| `ErrorHandler`    | Reports issues like invalid IDs or data gaps       |

**📈 Analytics Summary (Example)**

✅ Total Rides Completed: 2

❌ Rides Cancelled: 1

🌟 Top Rated Driver: Clara (4.9)

📌 Most Active Rider: Emma

🚘 Rides by Vehicle:
SEDAN: 1
BIKE: 1
SUV: 0

**🔍 Data Query Examples**

Riders with names starting with E

Drivers sorted by rating

Rides filtered by status or vehicle type

Optional handling for users without emails
