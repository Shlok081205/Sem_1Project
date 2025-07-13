import java.util.*;

class EventManager {

    String Annual[] = new String[1000];
    String AnnualName[] = new String[500];
    int annual = 0;

    String Monthly[] = new String[1000];
    String MonthlyName[] = new String[500];
    int monthly = 0;
    String Weekly[] = new String[1000];
    String WeekelyName[] = new String[500];
    int weekely = 0;
    String One_Time[] = new String[1000];
    String One_TimeName[] = new String[500];
    int onetime = 0;

    Scanner sc = new Scanner(System.in);

    EventManager() {
        System.out.println(
                "\t\tWelcome to DateWizard \n\tYour all-in-one tool for exploring dates, finding days,calculating durations,\n\tidentifying palindrome dates,and managing your personalized calendar!");
    }

    void input() {
        int n = 0;
        String g = "";
        String[] d = new String[2];
        int[][] diff = new int[2][];
        int start;
        int end;
        System.out.println();
        do {
            System.out.println("Press 1 To Add Weekly Event");
            System.out.println("Press 2 To Add Monthly Event");
            System.out.println("Press 3 To Add Annual Event");
            System.out.println("Press 4 To Add One Time Event");
            System.out.println("Press 5 To Exit");
            g = sc.next();
            if (g.charAt(0) >= '0' && g.charAt(0) <= '9') {
                n = Integer.parseInt(g);
            } else {
                n = 0;
            }

            switch (n) {
                case 1: {

                    do {
                        System.out.println("The Dates Must Not Exceed the Time Limit of 2 Days");
                        System.out.print("Enter  Weekely Event Name: ");
                        WeekelyName[weekely / 2] = sc.next();
                        d = this.enterDates();
                        diff[0] = seprate(d[0]);
                        diff[1] = seprate(d[1]);
                        start = dateday(diff[0]);
                        end = dateday(diff[1]);
                    } while ((end - start) > 2);

                    Weekly[weekely] = d[0];
                    Weekly[weekely + 1] = d[1];
                    weekely += 2;

                    break;
                }
                case 2: {
                    do {
                        System.out.println("The Dates Must Not Exceed the Time Limit of 5 Days");
                        System.out.print("Enter MonthlyEvent Name: ");
                        MonthlyName[monthly / 2] = sc.next();
                        d = this.enterDates();
                        diff[0] = this.seprate(d[0]);
                        diff[1] = this.seprate(d[1]);
                        start = this.dateday(diff[0]);
                        end = this.dateday(diff[1]);
                    } while ((end - start) > 5);

                    Monthly[monthly] = d[0];
                    Monthly[monthly + 1] = d[1];
                    monthly += 2;
                    break;
                }
                case 3: {
                    do {
                        System.out.println("The Dates Must Not Exceed the Time Limit of 15  Days");
                        System.out.print("Enter Annual Event Name: ");
                        AnnualName[annual / 2] = sc.next();
                        d = this.enterDates();
                        diff[0] = this.seprate(d[0]);
                        diff[1] = this.seprate(d[1]);
                        start = this.dateday(diff[0]);
                        end = this.dateday(diff[1]);
                    } while ((end - start) > 15);

                    Annual[annual] = d[0];
                    Annual[annual + 1] = d[1];
                    annual += 2;
                    break;
                }
                case 4: {
                    do {
                        System.out.println("The Dates Must Not Exceed the Time Limit of 15 Days");
                        System.out.print("Enter One Time Event Name: ");
                        One_TimeName[onetime / 2] = sc.next();
                        d = this.enterDates(); 
                        diff[0] = this.seprate(d[0]);
                        diff[1] = this.seprate(d[1]);
                        start = this.dateday(diff[0]);
                        end = this.dateday(diff[1]);
                    } while ((end - start) > 15);

                    One_Time[onetime] = d[0];
                    One_Time[onetime + 1] = d[1];
                    onetime += 2;
                    break;
                }
                case 5: {
                    System.out.println("Exitting..............");
                    break;
                }
                default: {
                    System.out.println("Enter Valid Number");
                }
            }

        } while (n != 5);
    }

    int[] seprate(String a) {
        int date[] = new int[3];
        try {
            String d[] = a.split("/");

            for (int i = 0; i < 3; i++) {
                date[i] = Integer.parseInt(d[i]);
            }

            return date;
        } catch (Exception e) {
            return date;
        }
    }

    boolean check(int[] date) {
        boolean b = true;
        try {
            if (date[2] >= 1924 && date[2] <= 3000 && date[1] >= 1 && date[1] <= 12) {
                switch (date[1]) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12: {
                        if (date[0] >= 1 && date[0] <= 31) {
                        } else {
                            b = false;
                        }
                        break;
                    }

                    case 4:
                    case 6:
                    case 9:
                    case 11: {
                        if (date[0] >= 1 && date[0] <= 30) {
                        } else {
                            b = false;
                        }
                        break;
                    }

                    case 2: {
                        if ((date[2] % 400 == 0) || (date[2] % 100 != 0 && date[2] % 4 == 0)) {
                            if (date[0] >= 1 && date[0] <= 29) {
                            } else {
                                b = false;
                            }
                        } else {
                            if (date[0] >= 1 && date[0] <= 28) {
                            } else {
                                b = false;
                            }
                        }
                        break;
                    }

                    default: {
                        b = false;
                    }

                }
                return b;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    int dateday(int[] date) {

        int countdays = 0;

        for (int i = 1924; i < date[2]; i++) {
            if ((i % 400 == 0) || (i % 100 != 0 && i % 4 == 0)) {
                countdays += 366;
            } else {
                countdays += 365;
            }
        }
        for (int i = 1; i < date[1]; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    countdays += 31;
                    break;
                }

                case 4:
                case 6:
                case 9:
                case 11: {
                    countdays += 30;
                    break;
                }

                case 2: {
                    if ((date[2] % 400 == 0) || (date[2] % 100 != 0 && date[2] % 4 == 0)) {
                        countdays += 29;
                    } else {
                        countdays += 28;
                    }
                    break;
                }
            }
        }

        countdays += date[0];
        return countdays;
    }

    String daydate(int days) {

        int year = 1924;
        int month = 1;
        int day = 1;

        while (day >= 0) {
            int yeardays = 365;
            if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
                yeardays = 366;
            }
            if (days >= yeardays) {
                days -= yeardays;
                year++;
            } else {
                break;
            }

        }

        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
            daysInMonth[1] = 29;
        }
        while (days >= 0) {
            int monthdays = daysInMonth[month - 1];
            if (days >= monthdays) {
                days -= monthdays;
                month++;
            } else {
                break;
            }
        }

        day = days + 1;

        String date = day + "/" + month + "/" + year;
        return date;
    }

    String dayname(int days) {

        days = ((days) % 7);
        String dayName = "";

        switch (days) {
            case 0: {
                dayName = "Monday";
                break;
            }
            case 1: {
                dayName = "Tuesday";
                break;
            }
            case 2: {
                dayName = "Wednesday";
                break;
            }
            case 3: {
                dayName = "Thursday";
                break;
            }
            case 4: {
                dayName = "Friday";
                break;
            }
            case 5: {
                dayName = "Saturday";
                break;
            }
            case 6: {
                dayName = "Sunday";
                break;
            }
        }
        return dayName;

    }

    void displaydates() {
        System.out.println("Annual Events: ");
        for (int i = 0, j = 0; i < annual; i += 2, j++) {
            System.out.println(AnnualName[i / 2] + " Event " + (j + 1) + "  Start Date: " + Annual[i] + " End Date: "
                    + Annual[i + 1]);
            int[] s = this.seprate(Annual[i]);
            int[] e = this.seprate(Annual[i + 1]);
            int sd = this.dateday(s);
            int ed = this.dateday(e);

            String sn = this.dayname(sd);
            String en = this.dayname(ed);
            System.out.println("\t\tStart Day: " + sn + "  End Day: " + en);
            System.out.println();
        }
        System.out.println("Monthly Events: ");
        for (int i = 0, j = 0; i < monthly; i += 2, j++) {
            System.out.println(MonthlyName[i / 2] + " Event " + (j + 1) + "  Start Date: " + Monthly[i] + " End Date: "
                    + Monthly[i + 1]);
            int[] s = this.seprate(Monthly[i]);
            int[] e = this.seprate(Monthly[i + 1]);
            int sd = this.dateday(s);
            int ed = this.dateday(e);

            String sn = this.dayname(sd);
            String en = this.dayname(ed);
            System.out.println("\t\tStart Day: " + sn + "  End Day: " + en);
            System.out.println();
        }
        System.out.println("Weekely Events: ");
        for (int i = 0, j = 0; i < weekely; i += 2, j++) {
            System.out.println(WeekelyName[i / 2] + " Event " + (j + 1) + "  Start Date: " + Weekly[i] + "  End Date: "
                    + Weekly[i + 1]);
            int[] s = this.seprate(Weekly[i]);
            int[] e = this.seprate(Weekly[i + 1]);
            int sd = this.dateday(s);
            int ed = this.dateday(e);

            String sn = this.dayname(sd);
            String en = this.dayname(ed);
            System.out.println("\t\tStart Day: " + sn + "  End Day: " + en);
            System.out.println();
        }
        System.out.println("One-Time Events: ");
        for (int i = 0, j = 0; i < onetime; i += 2, j++) {
            System.out.println(One_TimeName[i / 2] + " Event " + (j + 1) + "  Start Date: " + One_Time[i]
                    + " End Date: " + One_Time[i + 1]);
            int[] s = this.seprate(One_Time[i]);
            int[] e = this.seprate(One_Time[i + 1]);
            int sd = this.dateday(s);
            int ed = this.dateday(e);

            String sn = this.dayname(sd);
            String en = this.dayname(ed);
            System.out.println("\t\tStart Day: " + sn + " End Day: " + en);
            System.out.println();
        }

    }

    String[] enterDates() {
        String[] dates = new String[2];
        boolean b[] = new boolean[2];
        int[][] date = new int[2][3];
        int s = 0;
        int e = -1;
        int c = 0;

        do {
            do {
                if (c != 0) {
                    System.out.println("ERROR: INPUT DATES AGAIN");
                }
                System.out.println("Enter Starting Dates Starting from 1/1/1924 and Ending at 31/12/3000");
                System.out.println("Enter Dates in format DD/MM/YYYY");

                System.out.println("Enter Starting Date");
                dates[0] = sc.next();
                date[0] = this.seprate(dates[0]);
                b[0] = this.check(date[0]);

                System.out.println("Enter Ending Date");
                dates[1] = sc.next();
                date[1] = this.seprate(dates[1]);
                b[1] = this.check(date[1]);

                c++;
            } while (b[0] == false && b[1] == false);

            s = this.dateday(date[0]);
            e = this.dateday(date[1]);
            c++;
        } while ((e - s) < 0);

        return dates;
    }

    void Palindrome() {

        String dates = "";
        boolean b = false;
        int[] date = new int[3];
        int c = 0;

        do {
            if (c != 0) {
                System.out.println("ERROR: INPUT DATES AGAIN");
            }
            System.out.println("Enter Starting Dates Starting from 1/1/1924 and Ending at 31/12/3000");
            System.out.println("Enter Dates in format DD/MM/YYYY");

            System.out.println("Enter Date");
            dates = sc.next();
            date = this.seprate(dates);
            b = this.check(date);

            c++;
        } while (b == false);

        if (date[0] >= 1 && date[0] <= 9) {
            dates = "0" + date[0];
        } else {
            dates = "" + date[0];
        }
        if (date[1] >= 1 && date[1] <= 9) {
            dates = dates + "0" + date[1];
        } else {
            dates = dates + "" + date[1];
        }
        dates = dates + "" + date[2];

        String newDate = "";

        for (int i = dates.length() - 1; i >= 0; i--) {
            newDate = newDate + dates.charAt(i);
        }

        b = newDate.equalsIgnoreCase(dates);
        if (b == false) {
            System.out.println("Entered Date is Not A Palindrome Date");
        } else {
            System.out.println("Entered Date is  A Palindrome Date");
        }

    }

    void displayEvents(int month, int year) {
        int day = 0;

        int[] startdate = new int[3];
        int[] enddate = new int[3];

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                day = 31;
                break;
            }

            case 4:
            case 6:
            case 9:
            case 11: {
                day = 30;
                break;
            }

            case 2: {
                if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
                    day = 29;
                } else {
                    day = 28;
                }
                break;
            }
        }

        startdate[0] = 1;
        startdate[1] = month;
        startdate[2] = year;

        enddate[0] = day;
        enddate[1] = month;
        enddate[2] = year;

        day = this.dateday(startdate);
        int ed = this.dateday(enddate);

        int count = 1;
        System.out.println("Your Weekely Events: ");
        for (int i = 0; i < weekely - 1; i += 2) {

            int d1[] = this.seprate(Weekly[i]);
            int d2[] = this.seprate(Weekly[i + 1]);

            int days1 = dateday(d1);
            int days2 = dateday(d2);
            while (days1 <= ed) {

                if (days1 >= day && days1 <= ed) {
                    String daydate1 = this.daydate(days1);
                    String daydate2 = this.daydate(days2);

                    System.out.println(WeekelyName[i / 2] + " Event " + count + " :\tStarting Date: " + daydate1
                            + " Ending Date: " + daydate2);
                    count++;
                }

                days1 += 7;
                days2 += 7;

                if (days1 >= ed) {
                    break;
                }

            }
        }

        count = 1;
        System.out.println("Your Monthly Events: ");
        for (int i = 0; i < monthly - 1; i += 2) {

            int d1[] = this.seprate(Monthly[i]);
            int d2[] = this.seprate(Monthly[i + 1]);

            int days1 = dateday(d1);
            int days2 = dateday(d2);
            while (days1 <= ed) {

                if (days1 >= day) {
                    String daydate1 = this.daydate(days1);
                    String daydate2 = this.daydate(days2);

                    System.out.println(MonthlyName[i / 2] + " Event " + count + " :\tStarting Date: " + daydate1
                            + " Ending Date: " + daydate2);
                    count++;
                }

                String currentmonth = this.daydate(days1);
                int m[] = this.seprate(currentmonth);
                int daysInMonth = 0;

                switch (m[1]) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12: {
                        daysInMonth = 31;
                        break;
                    }

                    case 4:
                    case 6:
                    case 9:
                    case 11: {
                        daysInMonth = 30;
                        break;
                    }

                    case 2: {
                        if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
                            daysInMonth = 29;
                        } else {
                            daysInMonth = 28;
                        }
                    }
                }
                days1 += daysInMonth;
                days2 += daysInMonth;

                if (days1 >= ed) {
                    break;
                }
            }

        }

        count = 1;
        System.out.println("Your Annual Events: ");
        for (int i = 0; i < annual - 1; i += 2) {

            int d1[] = this.seprate(Annual[i]);
            int d2[] = this.seprate(Annual[i + 1]);

            int days1 = dateday(d1);
            int days2 = dateday(d2);
            while (days1 <= ed) {

                if (days1 >= ed) {
                    break;
                }

                if (days1 >= day && days1 <= ed) {
                    String daydate1 = this.daydate(days1);
                    String daydate2 = this.daydate(days2);

                    System.out.println(AnnualName[i / 2] + " Event " + count + " :\tStarting Date: " + daydate1
                            + " Ending Date: " + daydate2);
                    count++;
                }

                String currentyear = this.daydate(days1);
                int daysInYear = 0;
                int y[] = this.seprate(currentyear);
                if ((y[2] % 400 == 0) || (y[2] % 100 != 0 && y[2] % 4 == 0)) {
                    daysInYear = 366;
                } else {
                    daysInYear = 365;
                }

                days1 += daysInYear;
                days2 += daysInYear;

            }

        }

        count = 1;
        System.out.println("Your One-Time Events: ");
        for (int i = 0; i < onetime - 1; i += 2) {

            int d1[] = this.seprate(One_Time[i]);
            int d2[] = this.seprate(One_Time[i + 1]);

            int days1 = dateday(d1);
            int days2 = dateday(d2);

            if (days1 >= day && days1 <= ed) {
                String daydate1 = this.daydate(days1);
                String daydate2 = this.daydate(days2);

                System.out.println(One_TimeName[i / 2] + " Event " + count + " :\tStarting Date: " + daydate1
                        + " Ending Date: " + daydate2);
                count++;
            }

        }

    }

    void dayadder() {
        int n = 0;
        int m = 0;
        String date = "";
        String day = "";

        do {
            System.out.println("Press 1 for Annual Events");
            System.out.println("Press 2 for Monthly Events");
            System.out.println("Press 3 for Weekely Events");
            System.out.println("Press 4 for One-Time Events");
            System.out.println("Press 5 for Exit");

            n = sc.nextInt();

            switch (n) {
                case 1: {
                    System.out.println(
                            "Press the Number Show Besides the Event To  Add or Subtract Extra Number of Days");
                    for (int i = 0; i < annual; i++) {
                        System.out.println("Event " + (i + 1) + " :" + Annual[i]);
                    }
                    m = sc.nextInt();

                    System.out.println(
                            "How Many Days do you want to Add or Subtract(Use - sign before the nubmer if you wwant to subtract)");
                    int j = sc.nextInt();
                    date = Annual[m - 1];
                    int[] sep = this.seprate(date);
                    j += dateday(sep);
                    date = daydate(j);
                    day = dayname(j);

                    System.out.println("New Date: " + date + " Day: " + day);

                    break;
                }
                case 2: {
                    System.out
                            .println("Press the Number Show Besides the Event To Add or Subtract Extra Number of Days");
                    for (int i = 0; i < monthly; i++) {
                        System.out.println("Event " + (i + 1) + " :" + Monthly[i]);
                    }
                    m = sc.nextInt();

                    System.out.println(
                            "How Many Days do you want to Add or Subtract(Use - sign before the nubmer if you wwant to subtract)");
                    int j = sc.nextInt();
                    date = Monthly[m - 1];
                    int[] sep = this.seprate(date);
                    j += dateday(sep);
                    date = daydate(j);
                    day = dayname(j);

                    System.out.println("New Date: " + date + " Day: " + day);

                    break;
                }
                case 3: {
                    System.out
                            .println("Press the Number Show Besides the Event To Add or Subtract Extra Number of Days");
                    for (int i = 0; i < weekely; i++) {
                        System.out.println("Event " + (i + 1) + " :" + Weekly[i]);
                    }
                    m = sc.nextInt();

                    System.out.println(
                            "How Many Days do you want to Add or Subtract(Use - sign before the nubmer if you wwant to subtract)");
                    int j = sc.nextInt();
                    date = Weekly[m - 1];
                    int[] sep = this.seprate(date);
                    j += dateday(sep);
                    date = daydate(j);
                    day = dayname(j);

                    System.out.println("New Date: " + date + " Day: " + day);

                    break;
                }
                case 4: {
                    System.out
                            .println("Press the Number Show Besides the Event To Add or Subtract Extra Number of Days");
                    for (int i = 0; i < onetime; i++) {
                        System.out.println("Event " + (i + 1) + " :" + One_Time[i]);
                    }
                    m = sc.nextInt();

                    System.out.println(
                            "How Many Days do you want to Add or Subtract(Use - sign before the nubmer if you wwant to subtract)");
                    int j = sc.nextInt();
                    date = One_Time[m - 1];
                    int[] sep = this.seprate(date);
                    j += dateday(sep);
                    date = daydate(j);
                    day = dayname(j);

                    System.out.println("New Date: " + date + " Day: " + day);

                    break;
                }
                case 5: {
                    System.out.println("Exitting.........");
                    break;
                }

                default:
                    System.out.println("Please Enter Valid Number");
                    break;
            }

        } while (n != 5);
    }

    void dayselector() {
        int n = 0;
        String dayname = "";
        do {
            System.out.println("Press 1 for Monday");
            System.out.println("Press 2 for Tuesday");
            System.out.println("Press 3 for Wednesday");
            System.out.println("Press 4 for Thursday");
            System.out.println("Press 5 for Friday");
            System.out.println("Press 6 for Saturday");
            System.out.println("Press 7 for Sunday");
            n = sc.nextInt();
            dayname = "";
            switch (n) {
                case 1:
                    dayname = "Monday";
                    break;
                case 2:
                    dayname = "Tuesday";
                    break;
                case 3:
                    dayname = "Wednesday";
                    break;
                case 4:
                    dayname = "Thursday";
                    break;

                case 5:
                    dayname = "Friday";
                    break;
                case 6:
                    dayname = "Saturday";
                    break;
                case 7:
                    dayname = "Sunday";
                    break;

                default:
                    System.out.println("Enter Valid Number.........");
            }
        } while ((n < 1) || (n > 7));

        do {
            System.out.println("Press 1 for January");
            System.out.println("Press 2 for Feburary");
            System.out.println("Press 3 for March");
            System.out.println("Press 4 for April");
            System.out.println("Press 5 for May");
            System.out.println("Press 6 for June");
            System.out.println("Press 7 for July");
            System.out.println("Press 8 for August");
            System.out.println("Press 9 for September");
            System.out.println("Press 10 for October");
            System.out.println("Press 11 for November");
            System.out.println("Press 12 for December");

            n = sc.nextInt();
            if (n < 1 || n > 12) {
                System.out.println("Enter Valid Number.........");
            }

        } while ((n < 1) || (n > 12));

        int year = 0;
        do {
            System.out.println("Enter Year(1924-3000):");
            year = sc.nextInt();
        } while (year < 1924 || year > 3000);

        int[] ds = new int[3];
        ds[0] = 1;
        ds[1] = n;
        ds[2] = year;

        int countdays = 0;
        String name = "";
        boolean b = true;

        do {
            countdays = this.dateday(ds);
            name = this.dayname(countdays);
            b = name.equalsIgnoreCase(dayname);
            if (b == false) {
                ds[0]++;
            }

        } while (b == false);

        int m = 0;
        if (n == 1 || n == 3 || n == 5 || n == 7 || n == 8 || n == 10 || n == 12) {
            m = 31;
        } else if (n == 2) {
            if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
                m = 29;
            } else {
                m = 28;
            }
        } else {
            m = 30;
        }

        countdays--;
        System.out.println("Dates on " + dayname);
        for (; ds[0] < m; ds[0] += 7, countdays += 7) {
            name = this.daydate(countdays);
            System.out.println(name);
        }

    }

    void calender(int month, int year) {

        int days[] = new int[3];
        days[0] = 1;
        days[1] = month;
        days[2] = year;
        System.out.println(month);
        String monthname = this.monthname(month);
        int countdays = this.dateday(days);
        String dayname = this.dayname(countdays);

        int n = 0;
        switch (dayname) {
            case "Monday":
                n = 0;
                break;
            case "Tuesday":
                n = 1;
                break;
            case "Wednesday":
                n = 2;
                break;
            case "Thursday":
                n = 3;
                break;
            case "Friday":
                n = 4;
                break;
            case "Saturday":
                n = 5;
                break;
            case "Sunday":
                n = 6;
                break;
        }

        int i = 0;
        for (; i < n; i++) {
            System.out.print(" \t");
        }

        int m = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                m = 31;
                break;

            case 2:
                m = (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0)) ? 29 : 28;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                m = 30;
                break;
        }

        System.out.println("\n\tMonth: " + monthname);
        System.out.println("\tYear: " + year);
        System.out.println();
        System.out.println("Mo\tTu\tWe\tTh\tFr\tSa\tSu");

        for (int a = 0; a < n; a++) {
            System.out.print("\t");
        }

        for (; days[0] <= m; days[0]++) {

            if ((days[0] + n) % 7 == 0) {
                System.out.print(days[0] + "\t");
                System.out.println();
            } else {
                System.out.print(days[0] + "\t");
            }
        }
        System.out.println();
        System.out.println();

        this.displayEvents(month, year);

    }

    String monthname(int month) {
        String s = "";
        switch (month) {
            case 1:
                s = "January";
                break;
            case 2:
                s = "Feburary";
                break;
            case 3:
                s = "March";
                break;
            case 4:
                s = "April";
                break;
            case 5:
                s = "May";
                break;
            case 6:
                s = "June";
                break;
            case 7:
                s = "July";
                break;
            case 8:
                s = "August";
                break;
            case 9:
                s = "September";
                break;
            case 10:
                s = "October";
                break;
            case 11:
                s = "November";
                break;
            case 12:
                s = "December";
                break;
        }

        return s;
    }

}

class Event {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        EventManager e1 = new EventManager();

        int n = 0;
        do {
            System.out.println("Press 1 to Input Events");
            System.out.println("Press 2 To See All Event Dates");
            System.out.println("Press 3 To View Calander");
            System.out.println("Press 4 To Miscellaneous");
            System.out.println("Press 5 To EXIT");
            n = sc.nextInt();

            switch (n) {

                case 1: {
                    e1.input();
                    break;
                }
                case 2: {
                    e1.displaydates();
                    break;
                }
                case 3: {
                    int month = 0;
                    do {
                        System.out.println("Press 1 for January");
                        System.out.println("Press 2 for Feburary");
                        System.out.println("Press 3 for March");
                        System.out.println("Press 4 for April");
                        System.out.println("Press 5 for May");
                        System.out.println("Press 6 for June");
                        System.out.println("Press 7 for July");
                        System.out.println("Press 8 for August");
                        System.out.println("Press 9 for September");
                        System.out.println("Press 10 for October");
                        System.out.println("Press 11 for November");
                        System.out.println("Press 12 for December");

                        month = sc.nextInt();
                        if (month < 1 && month >= 12) {
                            System.out.println("Enter Valid Number.........");
                        }
                    } while (month < 1 || month > 12);

                    int year = 0;

                    do {
                        System.out.println("Enter Year(1924-3000):");
                        year = sc.nextInt();
                    } while (year < 1924 || year > 3000);

                    e1.calender(month, year);

                    break;
                }
                case 4: {
                    int m;
                    do {
                        System.out.println("Press 1 To Find Dates by Day");
                        System.out.println("Press 2 For Duration Finder ");
                        System.out.println("Press 3 To Palindrome Dates");
                        System.out.println("Press 4 To Add Days To Events");
                        System.out.println("Press 5 To EXIT");
                        m = sc.nextInt();

                        switch (m) {
                            case 1: {
                                e1.dayselector();
                                break;
                            }
                            case 2: {
                                String[] dates = new String[2];
                                dates = e1.enterDates();
                                int[][] date = new int[2][3];
                                date[0] = e1.seprate(dates[0]);
                                date[1] = e1.seprate(dates[1]);
                                int start = e1.dateday(date[0]);
                                int end = e1.dateday(date[1]);
                                System.out.println("Number of Days Between Dates: " + dates[0] + " to " + dates[1]
                                        + " are: " + (Math.abs(end - start)));

                                break;
                            }
                            case 3: {
                                e1.Palindrome();
                                break;
                            }
                            case 4: {
                                e1.dayadder();
                                break;
                            }
                            case 5: {
                                System.out.println("Exitting SubMenu.................");
                                break;
                            }
                            default:
                                System.out.println("ERROR:ENTER VALID NUMBER");
                                break;
                        }

                    } while (m != 5);

                    break;
                }
                case 5: {
                    System.out.println("Exitting System.................");
                    break;
                }

                default:
                    System.out.println("ERROR:ENTER VALID NUMBER");
                    break;
            }

        } while (n != 5);

        sc.close();
    }
}
