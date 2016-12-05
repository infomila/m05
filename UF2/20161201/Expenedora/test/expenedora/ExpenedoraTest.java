/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expenedora;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class ExpenedoraTest {
    
    public ExpenedoraTest() {
    }

    
    @Test
    public void testPagarMetalic() {
        
        prova(       100,	2,	0,	0,	0	,0,	0,	Expenedora.TipusCanvi.VENDA_OK_CANVI_EXACTE	,0,	0,	0,	2,	0,	0                );

        
        
        
        
        
    }

    private void prova(int i, byte i0, byte i1, byte i2, byte i3, byte i4, byte i5,  Expenedora.TipusCanvi tipusCanvi, byte i9, byte i10, byte i11, byte i12, byte i13, byte i14) {

         Expenedora e = new Expenedora();
        int preuEnCentims=i;
        byte[] monedesClient = new byte[]{i0,i1,i2};
        byte[] monedesCaixa = new byte[]{i3,i4,i5};
        Expenedora.TipusCanvi t = e.pagarMetalic(preuEnCentims, monedesClient, monedesCaixa);

        assertEquals(tipusCanvi, t);
        assertArrayEquals( new byte[] {i9,i10,i11}, monedesClient);
        assertArrayEquals( new byte[] {i12,i13,i14}, monedesCaixa);
    }
    
}
