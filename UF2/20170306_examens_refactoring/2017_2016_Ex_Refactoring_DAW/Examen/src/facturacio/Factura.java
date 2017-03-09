package facturacio;

import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Representació d'una Factura. Les factures s'identifiquen amb un número, es
 * fan en una data concreta, i a mÃ©s, contenen una llista ordenada de linies de
 * factura.
 * @author bernat
 * @version 1.0
 * @updated 13-mar-2012 18:26:16
 */
public class Factura {

    private ArrayList<LiniaFactura> linies;
    private long numero;
    private Date data;
    
    public Factura(int unNumero) {
        this.numero = unNumero;
        this.linies = new ArrayList<LiniaFactura>();
        this.data = new Date();
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void afegirLinia(LiniaFactura l) {
        if (l != null) {
            linies.add(l);
        }
    }

    public void eliminarLinia(int num) {
        if (num >= 0 && num < linies.size()) {
            linies.remove(num);
        }
    }

    public String toXML() {
        
        int numLinia=1;
        
        String xml="";         
        NumberFormat nf = DecimalFormat.getNumberInstance( new Locale("ca", "es"));
        nf.setMaximumFractionDigits(2);
        
        
        
        double baseImposableTotal = 0, ivaAcumulatTotal = 0, total=0;
        xml += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        xml += "<factura numero=\""+this.numero+"\" >\n";
        xml += "<linies>\n";
        
        //int liniesEnLiquidacio=0, liniesNovetat=0, liniesNormals=0, linies2x1=0;
        // Recorregut per totes les línies de la factura
        
        
        
        
        int comptadorsTotals[] = new int[4];
        
        
        for (LiniaFactura lin : linies) {
            // Càlculs dels imports de la línia
            Producte p = lin.getProd();
            double preuProducte = p.getPreuBase();
 
            double baseImposableLinia, ivaLinia;
            String tipusDesc;
            // segons el tipus de producte, el preu es pot modificar
            
            preuProducte = p.getPreuFinal(lin.getNumeroUnitats());
            tipusDesc = p.getTipusDesc();
            
            comptadorsTotals[p.getTipus()]++;
            
            /*switch(p.getTipus()) {
                case Producte.EN_LIQUIDACIO:
                {
                    liniesEnLiquidacio++;    
                    break;
                }
                case Producte.EN_PROMOCIO_2X1:  
                {
                    linies2x1++;                    
                    break;
                }
                case Producte.NOVETAT:
                {
                    liniesNovetat++;
                    break;
                } 
                case Producte.NORMAL: 
                {
                    liniesNormals++;                   
                    break;
                }
                default: throw new RuntimeException("Tipus desconegut");
            }//final switch
            */
            baseImposableTotal +=  lin.getBaseImposable();//baseImposableLinia;
            ivaAcumulatTotal += lin.getIva();
            
            
            xml += "\t<linia tip=\""+tipusDesc+"\" num=\""+numLinia+"\">\n";
            xml += "\t\t<bi>"+nf.format(lin.getBaseImposable())+"</bi>\n";
            xml += "\t\t<iva>"+nf.format(lin.getIva())+"</iva>\n";
            xml += "\t\t<total>"+nf.format(lin.getTotal())+"</total>\n";
            xml += "\t</linia>\n"; 
            numLinia++;
        }
        
        total = baseImposableTotal+ ivaAcumulatTotal;
        
        xml += "</linies>\n";
        xml += "<base_imposable>"+nf.format(baseImposableTotal)+"</base_imposable>\n";
        xml += "<iva>"+nf.format(ivaAcumulatTotal)+"</iva>\n";
        xml += "<total>"+nf.format(total)+"</total>\n";
        xml += "<resum>\n";
        xml += "\t<numero_linies tip=\"LIQUIDACIO\">"+comptadorsTotals[Producte.EN_LIQUIDACIO]+"</total>\n";
        xml += "\t<numero_linies tip=\"2x1\">"+comptadorsTotals[Producte.EN_PROMOCIO_2X1]+"</total>\n";
        xml += "\t<numero_linies tip=\"NORMAL\">"+comptadorsTotals[Producte.NORMAL]+"</total>\n";
        xml += "\t<numero_linies tip=\"NOVETAT\">"+comptadorsTotals[Producte.NOVETAT]+"</total>\n";
        xml += "</resum>\n";
        xml += "</factura>\n";
        return xml;
    }
}


