/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alecsiikaluoma
 */
public class KassaPaateTest {
    
    Kassapaate kassa = new Kassapaate();
    Maksukortti kortti = new Maksukortti(1000);
    
    @Test
    public void oikeaAlkuRaha() {
        assertEquals(kassa.kassassaRahaa(), 100000);
    }
    
    @Test
    public void oikeaAlkuLukema() {
        assertEquals(kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty(), 0);
    }
    
    @Test
    public void edullisenOstoToimii() {
        Integer rahaa = kassa.kassassaRahaa();
        assertEquals(kassa.syoEdullisesti(300), 60);
        assertEquals(kassa.kassassaRahaa(), rahaa + 240);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 1);
    }
    
    @Test
    public void maukasOstoToimii() {
        assertEquals(kassa.syoMaukkaasti(500), 100);
        assertEquals(kassa.kassassaRahaa(), 100000 + 400);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
    }
    
    @Test
    public void riittamatonMaksuEdullisesti() {
        assertEquals(kassa.syoEdullisesti(100), 100);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 0);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }
    
    @Test
    public void riittamatonMaksuMaukkaasti() {
        assertEquals(kassa.syoMaukkaasti(300), 300);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 0);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }
    
    
    
    @Test
    public void riittavastiSaldoaEdullisesti() {
        assertEquals(kassa.syoEdullisesti(kortti), true);
        assertEquals(kortti.saldo(), 1000-240);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }
    
    @Test
    public void riittavastiSaldoaMaukkaasti() {
        assertEquals(kassa.syoMaukkaasti(kortti), true);
        assertEquals(kortti.saldo(), 1000-400);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }
    
    @Test
    public void eiRiittavastiSaldoaEdullisesti() {
        kortti = new Maksukortti(230);
        assertEquals(kassa.syoEdullisesti(kortti), false);
        assertEquals(kortti.saldo(), 230);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 0);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }
    
    @Test
    public void eiRiittavastiSaldoaMaukkaasti() {
        kortti = new Maksukortti(350);
        assertEquals(kassa.syoMaukkaasti(kortti), false);
        assertEquals(kortti.saldo(), 350);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 0);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }
    
    @Test
    public void lataaRahaaKortille() {
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(kortti.saldo(), 1500);
        
    }
    
    @Test
    public void lataaRahaaKortilleNegatiivisesti() {
        kassa.lataaRahaaKortille(kortti, -500);
        assertEquals(kortti.saldo(), 1000);
        
    }
    
}
