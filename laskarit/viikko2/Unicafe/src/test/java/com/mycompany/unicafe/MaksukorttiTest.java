package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void latausToimii() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }
    
    @Test
    public void saldoVahenee() {
        kortti.lataaRahaa(10);
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void saldoEiVaheneJosEiTarpeeksi() {
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void palauttaaOikeanArvon() {
        assertEquals(kortti.otaRahaa(10), true);
        kortti.lataaRahaa(10);
        assertEquals(kortti.otaRahaa(20), false);
    }
    
}
