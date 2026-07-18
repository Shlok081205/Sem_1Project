# Calendar & Event Management System 📅

> A logic-heavy console application that generates accurate calendars and manages recurring schedules — built entirely from scratch in Core Java.

A Semester 1 project ("DateWizard") that demonstrates raw algorithmic thinking — no date/time libraries used. Every calendar, leap year check, day calculation, and event projection is computed manually using loops and control flow.

---

## 🌟 Features

| Feature | Description |
|---|---|
| 📆 **Calendar Display** | Renders a formatted monthly calendar for any month/year (1924–3000) |
| 📅 **Recurring Events** | Add Weekly, Monthly, Annual, or One-Time events with date ranges |
| 🔁 **Event Projection** | Automatically projects recurring events across future years |
| 🔍 **Day Finder** | Calculates which day of the week any date falls on |
| ➕ **Day Adder** | Adds N days to a date and returns the resulting date |
| 📏 **Date Difference** | Computes the exact number of days between two dates |
| 🔄 **Palindrome Dates** | Finds all palindrome dates (DD/MM/YYYY reads same forwards/backwards) |
| ✅ **Leap Year Detection** | Accurate leap year logic (divisible by 400, or by 4 but not 100) |

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java (Core) | Single-file console application |
| `java.util.Scanner` | User input handling |
| Raw loops & switch | All date logic — no `java.time` or external libraries |

---

## 📁 Project Structure

```
Calender_and_Event_Managment_System/
│
└── Event.java          # Entire application — 1159 lines, 2 classes
    │
    ├── class EventManager       # Core logic engine
    │   ├── input()              # Menu — add Weekly/Monthly/Annual/One-Time events
    │   ├── displaydates()       # Project & display recurring events across years
    │   ├── displayEvents()      # Render calendar with events highlighted
    │   ├── calender()           # Generate and print a monthly calendar grid
    │   ├── Palindrome()         # Find palindrome dates in a given range
    │   ├── dayselector()        # Find the day of the week for any date
    │   ├── dayadder()           # Add N days to a given date
    │   ├── seprate()            # Parse "DD/MM/YYYY" string into int[3]
    │   ├── check()              # Validate a date (including leap year Feb check)
    │   └── dateday()            # Convert a date to a sequential day number
    │
    └── class Event              # Entry point
        └── main()               # Main menu — Calendar / Events / Tools / Exit
```

---

## ⚙️ How to Compile & Run

### Prerequisites
- Java 8+ (JDK installed)

### Compile

```bash
javac Event.java
```

### Run

```bash
java Event
```

---

## 🧭 App Menu

```
1. Display Calendar          → Shows a formatted calendar for any month/year
2. Manage Events             → Add & view Weekly / Monthly / Annual / One-Time events
3. Date Tools                → Day finder, date difference, day adder, palindrome finder
5. Exit
```

**Date format used throughout:** `DD/MM/YYYY` (e.g. `25/12/2024`)

---

## 🧠 Core Algorithms (No Libraries Used)

### Leap Year Detection
```java
if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))
    // Leap year — February has 29 days
```

### Day-of-Week Calculation
The `dateday()` method converts any date to a sequential integer (total days from a base date), then `% 7` gives the day of the week — enabling the calendar grid to start on the correct column.

### Recurring Event Projection
- **Weekly** events: max 2-day span, shown every week
- **Monthly** events: max 5-day span, shown every month on the same dates
- **Annual** events: max 15-day span, shown once per year
- **One-Time** events: max 15-day span, shown only in their specified year

### Palindrome Date Finder
Iterates through a date range, formats each date as `DDMMYYYY`, and checks if the string equals its reverse.

---

## 📊 Supported Date Range

| Limit | Value |
|---|---|
| Minimum year | 1924 |
| Maximum year | 3000 |
| Date format | `DD/MM/YYYY` |

---

## 👨‍💻 Author

**Shlok Patel** — Semester 1 Project

---

## 📄 License

This project was built for educational purposes as part of a semester project.
