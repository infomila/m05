package apptesting;

/**
 * Una reunió té una hora d'inici i una hora de finalització ( hores senceres
 * i no fraccions ! )
 * @author BERNAT
 */
public class Reunio {
    int horaInici, horaFi;
    int dia;

    public Reunio(int horaInici, int horaFi, int dia) {
        this.horaInici = horaInici;
        this.horaFi = horaFi;
        this.dia = dia;
    }

    public int getHoraInici() {
        return horaInici;
    }

    public int getHoraFi() {
        return horaFi;
    }

    public int getDia() {
        return dia;
    }      



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reunio other = (Reunio) obj;
        if (this.horaInici != other.horaInici) {
            return false;
        }
        if (this.horaFi != other.horaFi) {
            return false;
        }
        if (this.dia != other.dia) {
            return false;
        }
        return true;
    }
    
    
}
