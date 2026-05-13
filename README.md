# 🏢 Business Tycoon

A terminal-based business simulation game written in Java. You start with a random amount of capital, one building, and a goal: grow your business into a profitable empire by making smart financial decisions every day.

---

## 🎮 Gameplay Overview

Each in-game day, you manage one or more buildings, track inventory and shelf stock, and make decisions that affect your bottom line. At the end of every month, expenses are tallied and you either pay up or face the consequences.

**Core mechanics:**

- **Demand system** — demand represents how many products you sell per day. It grows over time and with building upgrades.
- **Inventory pipeline** — products live off-shelf in your warehouse until you restock. Empty shelves mean lost revenue.
- **Monthly expenses** — unpaid expenses accumulate interest. Fall too far behind and the game is over.
- **Leveling up** — hit cash, building, and upgrade thresholds to level up, unlock booster resets, and scale your operation.

---

## 🧠 Features

- Save and load game progress via `saveGame.txt`
- Up to 15 buildings, each with independent stats
- 4 one-time-per-level efficiency boosters
- Loan system with tiered interest rates
- Employee hiring with upfront cost and monthly wages
- Randomized market prices (buy/sell) each day
- Text-based building visualization that updates with levels

---

## ⚡ Efficiency Boosters

Each booster is usable once per level and expires at the end of the day:

| Booster | Effect |
|---|---|
| **Profit Booster** | +25% of daily revenue added to cash |
| **Expense Relief** | 25% discount on any expense payment |
| **Building Incentive** | 25% cashback on new building purchases |
| **Purchase Relief** | 25% cashback on inventory purchases |

---

## 📈 Level-Up Requirements

| Level | Cash Required | Buildings | Building Level |
|---|---|---|---|
| 1 → 2 | $150,000 | 3 | 2 |
| 2 → 3 | $400,000 | 6 | 4 |
| 3 → 4 | $700,000 | 10 | 6 |
| 4 → 5 | $1,000,000 | 15 | 8 |

---

## 🏦 Loan Options

| Amount | Interest |
|---|---|
| $1,000 | 7% |
| $2,500 | 6% |
| $5,000 | 6% |
| $10,000 | 5% |
| $25,000 | 5% |
| $50,000 | 4% |
| $150,000 | 3% |
| $300,000 | 2% |

> Loans are added to your total expenses and must be paid off by end of month to avoid a 20% penalty on all expenses.

---

## 🛠️ Tech Stack

- **Language:** Java
- **I/O:** `java.util.Scanner`, `java.io.BufferedReader`, `java.io.BufferedWriter`
- **Persistence:** Flat-file save system (`saveGame.txt`)
- **Structure:** Two-class OOP design (`Main.java`, `Business.java`)

---

## 🚀 Running the Game

**Requirements:** JDK 8 or higher

```bash
# Compile
javac Main.java Business.java

# Run
java Main
```

---

## 📁 Project Structure
```text
Business-Tycoon/
├── Main.java       # Game loop, state management, user input
├── Business.java   # Game logic, file I/O, helper methods
└── saveGame.txt    # Auto-generated on save

---

## ⚠️ Known Limitations

- Terminal-only interface, no GUI
- Save system stores a single slot
- Building stats are tracked via parallel arrays (no OOP model per building)
- No input validation on all edge cases

---

## 📌 Author

**Gurnit Chopra**
