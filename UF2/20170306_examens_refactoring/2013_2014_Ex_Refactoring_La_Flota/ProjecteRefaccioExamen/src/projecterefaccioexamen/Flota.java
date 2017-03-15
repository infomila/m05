package projecterefaccioexamen;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Flota {
    
    private ArrayList<Vehicle> vehicles;

    public Flota( ) {
        this.vehicles = new ArrayList<Vehicle>();
    }
    
    
    public void addVehicle(Vehicle nou){
        if(nou==null) {
            throw new RuntimeException("El vehicle no pot ser null");
        }
        for(Vehicle v: vehicles){
            if(v.getMatricula().equals(nou.getMatricula())) throw new RuntimeException("Element repetit");
        }
        vehicles.add(nou);
    }
    
    public String getInformeFlota(){
        int totalCotxes=0, totalMotos=0, totalCamions=0;
        float totalConsumsEur100KmCotxes=0, totalConsumsEur100KmMotos=0, totalConsumsEur100KmCamions=0;
        String resultat =   "========================================\n";
        resultat +=         "===   Informe de la flota de vehicles  =\n";
        resultat +=         "========================================\n";
        int consumL100Km;
        double consumEur100Km=0;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        String descTipus;
        
        // -------------------------------------------------------------
        //       Taules de totals
        int totalPerVehicle[] = new int[3];
        float consumsPerVehicle[] = new float[3];
        // -------------------------------------------------------------
        for(Vehicle vehicleActual: vehicles){
            descTipus = vehicleActual.getDescripcioTipus();
            
            resultat += descTipus  + " amb matricula "+vehicleActual.getMatricula()+"\n";
            consumL100Km = vehicleActual.getConsum();
            resultat += "Consum: "+consumL100Km+" l/100Km\n";
            
            consumEur100Km = consumL100Km * TarifesBenzina.getPreuLitre(vehicleActual.getTipusBenzina());
            resultat += "        "+nf.format(consumEur100Km)+" €/100Km\n";
            
            //Actualització de totals
            totalPerVehicle[vehicleActual.getTipus().ordinal()]++;
            consumsPerVehicle[vehicleActual.getTipus().ordinal()] += consumEur100Km;
                  
            resultat +=         "----------------------------------------\n";

        }
        resultat +=     "========================================\n";
        resultat +=     "===    Resum de consums per tipus    ===\n";
        resultat +=     "========================================\n";
        TipusVehicle tipusVehicOrdre[] = {TipusVehicle.CAMIO, TipusVehicle.COTXE, TipusVehicle.MOTO};
        for(int i=0;i<3;i++) {
            resultat +=   tipusVehicOrdre[i].getDescPlural()+":"+nf.format(consumsPerVehicle[tipusVehicOrdre[i].ordinal()])+" €/100Km\n";
        }
        return resultat;
    }
    public static void main(String [] args){
     
        Flota f = new Flota();
        f.addVehicle(new Camio(10000,   "3423-VFC", TipusBenzina.GASOIL, 800));
        f.addVehicle(new Camio(20000,   "3643-FCV", TipusBenzina.GASOIL, 900));
        f.addVehicle(new Cotxe(2000,   "3333-DDR", TipusBenzina.GASOLINA_95, 60));
        f.addVehicle(new Cotxe(2500,  "5555-DDR", TipusBenzina.GASOIL, 80));
        f.addVehicle(new Moto(120,   "3423-XXX", TipusBenzina.GASOLINA_95, 20));
        System.out.println(f.getInformeFlota());
    }
    
}
