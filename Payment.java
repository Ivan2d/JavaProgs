import java.util.Objects;

public class Payment
{
    private String fio;
    private int day;
    private int month;
    private int year;
    private double paysum;

    public Payment(String fio, int a, int b, int c, double sum)
    {
        boolean fourthyear;
        this.fio = fio;
        if (((year % 4 == 0) && (year % 100) != 0) || (year % 400 == 0))
        {
            year = c;
            fourthyear = false;
        }
        else
        {
            year = c;
            fourthyear = true;
        }
        if (1 <= b && b <= 12) {
            month = b;
        } else {
            throw new IllegalArgumentException("Некорректный месяц");
        }
        if (month == 2 && fourthyear == true) {
            if (1 <= a && a <= 29) {
                day = a;
            } else {
                throw new IllegalArgumentException("Некорректный день");
            }
        } else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (1 <= a && a <= 31) {
                    day = a;
                } else {
                    throw new IllegalArgumentException("Некорректный день");
                }
            } else {
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (1 <= a && a <= 30) {
                        day = a;
                    } else {
                        throw new IllegalArgumentException("Некорректный день");
                    }
                }
            }
        }
        if (Double.compare(sum, 0) > 0 || Double.compare(sum, 0) == 0)
        {
            paysum = sum;
        } else
        {
            throw new IllegalArgumentException("Некорректно введена сумма");
        }
    }

    public Payment(final Payment payment)
    {
        if (payment == null) {
            throw new IllegalArgumentException("The payment is null");
        }
        this.fio = payment.fio;
        this.day = payment.day;
        this.month = payment.month;
        this.year = payment.year;
        this.paysum = payment.paysum;
    }

    public String getFio() {
        return fio;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getPaysum() {
        return paysum;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPaysum(double paysum) {
        this.paysum = paysum;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return day == payment.day && month == payment.month && year == payment.year && Double.compare(payment.paysum, paysum) == 0 && fio.equals(payment.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, day, month, year, paysum);
    }


    @Override
    public String toString()
    {
        return "Payment{" +
                "fio='" + fio + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", paysum=" + paysum +
                '}';
    }
}

