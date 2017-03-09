package solucio;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Professor
 */
public class ColeccioFormes {

    private Vector<Forma> formes;

    public ColeccioFormes() {
        formes = new Vector<Forma>();
    }

    public void addForma(Forma f) {
        formes.add(f);
    }

    public static void main(String args[]) {
        ColeccioFormes c = new ColeccioFormes();
        c.addForma(new Triangle(2));
        c.addForma(new Cercle(2));
        c.addForma(new Cercle(3));
        c.addForma(new Quadrat(3));
        c.addForma(new Triangle(4));
        c.addForma(new Quadrat(3));
        c.addForma(new Quadrat(1));

        System.out.println(c.informeFormes());
    }

    public String informeFormes() {
        //int quadrats = 0, cercles = 0, triangles = 0, 
        int total = 0;
        //double areaQuadrats = 0, areaCercles = 0, areaTriangles = 0;
        double areaAcumulada = 0, mida;
        int tipus, numFig = 1;
        String informe = "";
        NumberFormat nf = DecimalFormat.getNumberInstance(new Locale("ca", "es"));
        nf.setMaximumFractionDigits(2);
        
        int comptadorFigures[] = new int[3];
        double comptadorArees[] = new double[3];
        
        informe += "========================\n";
        for (Forma f : formes) {
            mida = f.getMida();
            tipus = f.getTipusForma();
            total++;
            numFig++;
            informe += "- Figura <" + numFig + ">: ";            
            informe += f.getNom();
            double area = f.getArea();
            informe += "\t mida - "+mida+" - area " + nf.format(area) + "\n";
            areaAcumulada +=area;      
            
            
            comptadorFigures[tipus]++;
            comptadorArees[tipus]+= area;
            /*
            switch (tipus) {
                case Forma.QUADRAT:
                    areaQuadrats += area;
                    quadrats++;
                    break;
                case Forma.CERCLE:  
                    areaCercles += area;
                    cercles++;
                    break;
                case Forma.TRIANGLE_RECTANGLE_ISOSCELES:    
                    areaTriangles += area;
                    triangles++;
                    break;
            }*/
        } // end foreach forma
        // ---------------------- totalitzacions --------------------------
        informe += "========================\n";
        informe += "Total figures:" + total + ", area total:" + nf.format(areaAcumulada) + "\n";
        informe += "========================\n";
        for (int n = 1; n <= Forma.TOTAL_TIPUS_FORMES; n++) {
            switch (n) {

                case Forma.QUADRAT:
                    informe += "Total Quadrats:" + comptadorFigures[n] + ", area final:" + nf.format(comptadorArees[n]) + "\n";
                    break;
                case Forma.CERCLE:
                    informe += "Total Cercles:" + comptadorFigures[n] + ", area final:" + nf.format(comptadorArees[n]) + "\n";
                    break;
                case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                    informe += "Total triangles:" + comptadorFigures[n] + ", area final:" + nf.format(comptadorArees[n]) + "\n";
                    break;
            }
            informe += "========================\n";
        }//end for       
        return informe;
    }
}