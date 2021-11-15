package ru.imit.omsu;

public class FinanceReport
{
    private Payment[] report;

    public FinanceReport(int n)
    {
        report = new Payment[n];
    }

    public FinanceReport(final FinanceReport o)
    {
        if (o == null) {
            throw new IllegalArgumentException("The report is null");
        }
        this.report = new Payment[o.report.length];
        for (int i = 0; i < o.report.length; i++) {
            if (o.report[i] == null) {
                throw new IllegalArgumentException("Some of payments is null");
            }
            report[i] = new Payment(o.report[i]);
        }
    }

public Payment getReports(int i)
    {
        return report[i];
    }

    public void setReport(Payment report, int i)
    {
        this.report[i] = report;
    }

    public Payment[] getReports()
    {
        return report;
    }


    public int Reportlength()
    {
        return report.length;
    }


    @Override
    public String toString()
    {
        StringBuilder l = new StringBuilder();
        String t = "ФИО = %s, day = %d, Mounth = %d, year = %d, sumPayment = %f ";
        String t_last = "ФИО = %s, day = %d, Mounth = %d, year = %d, sumPayment = %f";
        for(int i = 0; i < Reportlength(); i++)
        {
            if(i == Reportlength()-1)
            {
                l.append(String.format(t_last, report[i].getFio(), report[i].getDay(), report[i].getMonth(), report[i].getYear(), report[i].getPaysum()));
            }
            else
            {
                l.append(String.format(t, report[i].getFio(), report[i].getDay(), report[i].getMonth(), report[i].getYear(), report[i].getPaysum()));
            }
        }
        return l.toString();
    }


}
