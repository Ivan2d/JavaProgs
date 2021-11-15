import org.junit.Test;

import static org.junit.Assert.*;

public class TestOfEconomicsProblemsInTheWorld {
    /*@DataProvider
    public static Object[][] PaymentsObjects()
    {
        Payment a = new Payment("Романовский Иван Владимирович", 23, 12, 1231, 123.1);
        Payment b = new Payment("Романовский Иван Владимирович", 23, 12, 1231, 123.1);
    }*/

    @Test
    public void testCopy() throws IllegalArgumentException {
        Payment a = new Payment("Романовский Иван Владимирович", 23, 12, 1231, 123.1);
        Payment b = new Payment("Романовский Иван Владимирович", 22, 12, 1231, 123.1);
        assertEquals(a.equals(b), true);

    }

    @Test
    public void testToString()
    {
        Payment a = new Payment("Романовский Иван Владимирович", 23, 12, 1231, 123.1);
        assertEquals("Payment{fio='Романовский Иван Владимирович', day=23, month=12, year=1231, sumPayment=123.1}", a.toString());

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
        FinanceReport b = new FinanceReport(n);
        Payment a1 = new Payment("Романовский Иван Владимирович", 22, 12, 1231, 123.1);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 23, 11, 1231, 123.1);
        Payment a3 = new Payment("Раховецкий Андрей ...", 23, 12, 1234, 123.1);
        b.setReports(a1, 0);
        b.setReports(a2, 1);
        b.setReports(a3, 2);
        assertEquals(b.toString(), "Фио = Романовский Иван Владимирович, day = 22, Mounth = 12, year = 1231, sumPayment = 123,100000 Фио = Асаевич Никита Сергеевич, day = 23, Mounth = 11, year = 1231, sumPayment = 123,100000 Фио = Раховецкий Андрей ..., day = 23, Mounth = 12, year = 1234, sumPayment = 123,100000");
    }
    @Test
    public void testFinanceReportProcessor()
    {
        FinanceReportProcessor n = new FinanceReportProcessor();
        FinanceReport b = new FinanceReport(3);
        Payment a1 = new Payment("Романовский Иван Владимирович", 22, 12, 1231, 123.1);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 23, 11, 1231, 123.1);
        Payment a3 = new Payment("Раховецкий Андрей ...", 23, 12, 1234, 123.1);
        b.setReports(a1, 0);
        b.setReports(a2, 1);
        b.setReports(a3, 2);
        char a = 'А';
        Payment a4 = n.CharReport(b, a).getReports(0);
        assertEquals(a4, a2);
    }
    @Test
    public  void testDemension()
    {
        FinanceReportProcessor n = new FinanceReportProcessor();
        FinanceReport b = new FinanceReport(3);
        Payment a1 = new Payment("Романовский Иван Владимирович", 22, 12, 1231, 122.1);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 23, 11, 1231, 123.1);
        Payment a3 = new Payment("Раховецкий Андрей ...", 23, 12, 1234, 123.1);
        b.setReports(a1, 0);
        b.setReports(a2, 1);
        b.setReports(a3, 2);
        Payment a4 = n.DemensionReports(b, 122.2).getReports(0);
        assertEquals(a4.equals(a1), true);
    }


}
}
