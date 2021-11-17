package ru.imit.omsu;

import org.junit.Test;

import static org.junit.Assert.*;

public class FinanceReportProcessorTest
{
    @Test
    public void testofcopy() throws IllegalArgumentException
    {
        Payment x = new Payment("Романовский Иван Владимирович", 1, 2, 3, 6);
        Payment y = new Payment("Романовский Иван Владимирович", 1, 2, 3, 6);
        assertEquals(x.equals(y), true);

    }

    @Test
    public void testToString()
    {
        Payment a = new Payment("Романовский Иван Владимирович", 1, 12, 1231, 123.1);
        assertEquals("Payment{fio='Романовский Иван Владимирович', day=1, month=12, year=1231, paysum=123.1}", a.toString());

    }
    @Test
    public void testHashCode()
    {
        Payment a = new Payment("Романовский Иван Владимирович", 23, 12, 1231, 123.1);
        assertEquals(a.hashCode(), 1602225011);
    }
    @Test
    public void testFinanceReportToString()
    {
        int n = 3;
        FinanceReport y = new FinanceReport(n);
        Payment x1 = new Payment("Романовский Иван Владимирович", 22, 12, 1231, 123.1);
        Payment x2 = new Payment("Асаевич Никита Сергеевич", 23, 11, 1231, 123.1);
        Payment x3 = new Payment("Раховецкий Андрей Олегович", 23, 12, 1234, 123.1);
        y.setReport(x1, 0);
        y.setReport(x2, 1);
        y.setReport(x3, 2);
        assertEquals(y.toString(), "ФИО = Романовский Иван Владимирович, day = 22, Mounth = 12, year = 1231, sumPayment = 123,100000 ФИО = Асаевич Никита Сергеевич, day = 23, Mounth = 11, year = 1231, sumPayment = 123,100000 ФИО = Раховецкий Андрей Олегович, day = 23, Mounth = 12, year = 1234, sumPayment = 123,100000");
    }
    @Test
    public void testFinanceReportProcessor()
    {
        FinanceReportProcessor n = new FinanceReportProcessor();
        FinanceReport c = new FinanceReport(3);
        Payment x1 = new Payment("Романовский Иван Владимирович", 22, 12, 1231, 123.1);
        Payment x2 = new Payment("Асаевич Никита Сергеевич", 23, 11, 1231, 123.1);
        Payment x3 = new Payment("Раховецкий Андрей Олегович", 23, 12, 1234, 123.1);
        c.setReport(x1, 0);
        c.setReport(x2, 1);
        c.setReport(x3, 2);
        char a = 'А';
        Payment y = n.CharReport(c, a).getReports(0);
        assertEquals(y, x2);
    }
    @Test
    public  void testDimension()
    {
        FinanceReportProcessor n = new FinanceReportProcessor();
        FinanceReport d = new FinanceReport(3);
        Payment x1 = new Payment("Романовский Иван Владимирович", 22, 12, 1231, 122.1);
        Payment x2 = new Payment("Асаевич Никита Сергеевич", 23, 11, 1231, 123.1);
        Payment x3 = new Payment("Раховецкий Андрей Олегович", 23, 12, 1234, 123.1);
        d.setReport(x1, 0); d.setReport(x2, 1); d.setReport(x3, 2);
        Payment a4 = n.DimensionReports(d, 122.2).getReports(0);
        assertEquals(a4.equals(x1), true);
    }


}
