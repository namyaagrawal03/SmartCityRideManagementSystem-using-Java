Problem: Smart City Transport Pass System
📘 Context
The city of "Codetropolis" has implemented a smart transport system where residents use rechargeable passes to access various modes of transport — Bus, Metro, and Bike Rental. Users have individual profiles and can interact with the system to load money, check their balance, use different transport options, and review travel history. The city wants the software to be modular, extensible, and robust.

✅ Requirements & Rules
Transport Modes & Costing - Each transport mode (Bus, Metro, Bike Rental) has its own usage cost. Each mode defines its own rules.

User Profile & Travel History - Each user has a name, balance, email and a log of their travel activity. User may or may not decide to use his/her email. The system must allow balance recharging, travel history viewing, and graceful handling when email is absent.

Discount Policy for Bike Rental - Bike Rental offers a 50% discount if a user has used it 2 or more times. This rule should be part of a discount system that allows certain transport types to define their own pricing conditions.

Error Handling - System should be capable to highlight what went wrong and continue functioning without crashing.

💡 Constraints
Bus cost: ₹20
Metro cost: ₹30
Bike Rental cost: ₹10
Minimum 2 users should be defined at the start
Sample Output
--- SMART CITY TRANSPORT PASS SYSTEM ---
[INFO] Initializing Users...
[User Created] Alice (Email: alice@example.com) - Balance: ₹100
[User Created] Bob (Email: not provided) - Balance: ₹30

--- Travel Simulation ---
[Alice chooses METRO]
[Alice] Successfully used Metro (₹30)
[Alice] New Balance: ₹70

[Alice chooses BIKE_RENTAL]
[Alice] Successfully used Bike Rental (₹10)
[Alice] New Balance: ₹60

[Alice chooses BIKE_RENTAL]
[Alice] Successfully used Bike Rental (₹10)
[Alice] New Balance: ₹50

[Alice chooses BIKE_RENTAL]
[DISCOUNT] Bike Rental discounted to ₹5
[Alice] Successfully used Bike Rental (₹5)
[Alice] New Balance: ₹45

[Bob chooses BUS]
[Bob] Successfully used Bus (₹20)
[Bob] New Balance: ₹10

[Bob chooses METRO]
[ERROR] Insufficient balance for Metro (Required: ₹30, Available: ₹10)

--- Recharge Simulation ---
[Alice recharges ₹50]
[Alice] New Balance: ₹95

[Bob recharges ₹100]
[Bob] New Balance: ₹110

--- Travel History ---
[Alice's Travel History]
1. METRO - ₹30
2. BIKE_RENTAL - ₹10
3. BIKE_RENTAL - ₹10
4. BIKE_RENTAL - ₹5

[Bob's Travel History]
1. BUS - ₹20

--- Department Summary (Final Balances) ---
Alice (Email: alice@example.com) - Balance: ₹95
Bob (Email: not provided) - Balance: ₹110
