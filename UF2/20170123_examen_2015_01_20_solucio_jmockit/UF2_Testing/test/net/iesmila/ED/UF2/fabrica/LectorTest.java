package net.iesmila.ED.UF2.fabrica;

 
import java.util.HashMap;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Test;
import static org.junit.Assert.*;


public class LectorTest {
    
    public LectorTest() {
    }
    
    /**
     * Test of extreuParaulesAmbDefinicio method, of class Lector.
     */
    
    @Mocked
    DiccionariOnline mDiccionariOnline;
    
    @Test
    public void testInformeText() {
        
//        
//        //--------------------------------------------------
//        //   Bloc MockUp 
//        //--------------------------------------------------        
//        new MockUp<DiccionariOnline>(){
//
//            /**
//             * donada una paraula en retorna el tipus ( nom, adjectiu, verb...)
//             */
//            @Mock
//            public TipusParaula getTipusParaula(String paraula) {
//
//                if(paraula.equals("gos")||paraula.equals("gat")||paraula.equals("casa")) {
//                    return TipusParaula.NOM;
//                }
//                return TipusParaula.ARTICLE;
//            }
//
//            @Mock
//            public String getDescripcio(String paraula) {        
//
//                HashMap<String, String> definicions = new HashMap<String, String>();
//                definicions.put("gos","mamifer cannid");
//                definicions.put("gat","mamifer feli");
//                definicions.put("casa","llar dolça llar");
//
//               return definicions.get(paraula);
//
//            }            
//        };
        
        
        //--------------------------------------------------
        //   Bloc d'expectations ( respostes pregravades ) 
        //--------------------------------------------------
        new NonStrictExpectations(){{
            
//            mDiccionariOnline.getTipusParaula(anyString);
//            returns ( TipusParaula.ARTICLE,     // el 
//                      TipusParaula.NOM,         // gos
//                      TipusParaula.CONJUNCIO,   // i
//                      TipusParaula.ARTICLE,     //el
//                      TipusParaula.NOM,         //gat
//                      TipusParaula.VERB     ,   // viuen
//                      TipusParaula.CONJUNCIO     ,// a
//                      TipusParaula.NOM             // casa
//                    ); 
            
            mDiccionariOnline.getTipusParaula("gos");
            returns ( TipusParaula.NOM);
            mDiccionariOnline.getTipusParaula("gat");
            returns ( TipusParaula.NOM);
            mDiccionariOnline.getTipusParaula("casa");
            returns ( TipusParaula.NOM);
            mDiccionariOnline.getTipusParaula(anyString);
            returns ( TipusParaula.ARTICLE);
            
            
//            mDiccionariOnline.getDescripcio(anyString);
//            returns (   "mamifer cannid",
//                        "mamifer feli",
//                        "llar dolça llar");
            mDiccionariOnline.getDescripcio("gos");
            returns (   "mamifer cannid" );
            mDiccionariOnline.getDescripcio("gat");
            returns (   "mamifer feli" );
            mDiccionariOnline.getDescripcio("casa");
            returns (   "llar dolça llar" );
        }};
        
        //----------------------------------------------------
        // Cos del test
        //----------------------------------------------------             
        Lector l = new Lector();
        String informeObtingut = l.extreuParaulesAmbDefinicio("El gos i el gat viuen a casa");
        String informeEsperat = "gos: mamifer cannid,gat: mamifer feli,casa: llar dolça llar";
        assertEquals(informeEsperat, informeObtingut );
        
    }
}
