package ru.imit.omsu;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringProcessorTest
{
    @Test
    public void testcopystring()
    {
        StringProcessor j = new StringProcessor();
        String a = j.copystring("123", 2);
        assertEquals("123123", a);
    }

    @Test
    public void testcopystringNiszero()
    {
        StringProcessor j = new StringProcessor();
        String a = j.copystring("123", 0);
        assertEquals("", a);
    }

    @Test
    public void testcopystringNlowerthatzero()
    {
        StringProcessor j = new StringProcessor();
        try{
            j.copystring("123", -1);
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("Отрицательный параметр N");
        }
    }

    @Test
    public void stringinsideanother()
    {
        StringProcessor j = new StringProcessor();
        int a = j.stringinsideanother("123123", "3");
        assertEquals(2, a);
    }

    @Test
    public void stringinsideanotherEmpty() {
        StringProcessor j = new StringProcessor();
        try {
            j.stringinsideanother("123", "");
        } catch (IllegalArgumentException e) {
            System.err.println("second string is empty");
        }
    }

    @Test
    public void stringinsideanotherNull()
    {
        StringProcessor j = new StringProcessor();
        try{
            j.stringinsideanother("123", "");
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("second string is null");
        }
    }

    @Test
    public void stringrecreatetest()
    {
        StringProcessor j = new StringProcessor();
        String a = j.stringrecreatenumbers("123123");
        assertEquals("одиндватриодиндватри", a);
    }

    @Test
    public void deletechartest()
    {
        StringBuilder a = new StringBuilder("123456");
        StringProcessor j = new StringProcessor();
        String b = j.deletesymbol2(a);
        assertEquals("135", b);
    }

    @Test
    public void testreplaceHexNum() {
        StringProcessor j = new StringProcessor();
        String str = "На часах 0x00000010:0x000000000x00000005";
        String expected = "На часах 16:05";

        assertEquals(j.replaceHexadecimalNumbers(str), expected);
    }

    @Test
    public void swapwordsstr() {
        StringProcessor j = new StringProcessor();
        String str = " aaa bbb cc dd ";
        assertEquals(" dd cc bbb aaa ", j.swapWordsstring(str));
    }
}
