package ru.imit.omsu;

public class FinanceReportProcessor
{
    public static FinanceReport CharReport(FinanceReport reports, char a)
    {

        FinanceReport n = new FinanceReport(reports.Reportlength());
        for(int i = 0; i < reports.Reportlength(); i++)
        {
            int j = 0;
            if(Character.toLowerCase((char) reports.getReports(i).getFio().charAt(0)) == Character.toLowerCase((char)a))
            {
                n.setReport(reports.getReports(i), j);
                j++;
            }
        }
        return n;

    }
    public static FinanceReport DimensionReports(FinanceReport reports, double a)
    {
        FinanceReport n = new FinanceReport(reports.Reportlength());
        for(int i = 0; i < reports.Reportlength(); i++)
        {
            if(Double.compare(a,reports.getReports(i).getPaysum()) > 0)
            {
                n.setReport(reports.getReports(i), i);
            }
        }
        return n;
    }

}
