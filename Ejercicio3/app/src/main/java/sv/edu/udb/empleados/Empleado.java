package sv.edu.udb.empleados;

import android.os.Parcel;
import android.os.Parcelable;

public class Empleado implements Parcelable {
    public String Nombre;
    public String Apellido;
    public String Cargo;
    public Integer Horas;
    public double SueldoBase;
    public double ISSS;
    public double AFP;
    public double RENTA;
    public double Sueldo_Liquido;

    public Empleado(String nombre, String apellido, String cargo, int horas) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Cargo = cargo;
        this.Horas = horas;
    }


    protected Empleado(Parcel in) {
        Nombre = in.readString();
        Apellido = in.readString();
        Cargo = in.readString();
        if (in.readByte() == 0) {
            Horas = null;
        } else {
            Horas = in.readInt();
        }
        SueldoBase = in.readDouble();
        ISSS = in.readDouble();
        AFP = in.readDouble();
        RENTA = in.readDouble();
        Sueldo_Liquido = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Nombre);
        dest.writeString(Apellido);
        dest.writeString(Cargo);
        if (Horas == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(Horas);
        }
        dest.writeDouble(SueldoBase);
        dest.writeDouble(ISSS);
        dest.writeDouble(AFP);
        dest.writeDouble(RENTA);
        dest.writeDouble(Sueldo_Liquido);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Empleado> CREATOR = new Creator<Empleado>() {
        @Override
        public Empleado createFromParcel(Parcel in) {
            return new Empleado(in);
        }

        @Override
        public Empleado[] newArray(int size) {
            return new Empleado[size];
        }
    };

    public double seldom_liquid()
    {
        this.Sueldo_Liquido = (SueldoBase-ISSS-RENTA-AFP);
        return (SueldoBase-ISSS-RENTA-AFP);
    }

    public void setSueldoBase(int horas) {
        this.SueldoBase =  CalcularSueldo(horas);
    }

    public void setISSS(int horas) {
        this.ISSS = desc_ISSS();
    }
    public void setAFP(int horas) {
        this.AFP = desc_AFP();
    }
    public void setRENTA(int horas) {
        this.RENTA = desc_RENTA();
    }

    public double CalcularSueldo(int horas) {
        double sueldo_base = 9.75;
        double sueldo_extras = 11.50;
        int horas_extras = 0;
        double total = 0.0;

        if (horas <= 160) {
            return (sueldo_base * horas);
        } else {
            horas_extras = (horas - 160);
            total = (sueldo_base * 160) + (horas_extras * sueldo_extras);
            return (total);
        }
    }

    public double bonoGerente(){
        return  Sueldo_Liquido*0.10;
    }
    public double bonoSecretaria(){
        return  Sueldo_Liquido*0.02;
    }
    public double bonoAsistente(){
        return  Sueldo_Liquido*0.03;
    }


    public double desc_ISSS() {
        double isss=0.0;
        isss = SueldoBase* 0.0525;
        return  isss;
    }

    public double desc_AFP() {
        double afp=0.0;
        afp = SueldoBase* 0.0688;
        return  afp;
    }
    public double desc_RENTA() {
        double renta=0.0;
        renta = SueldoBase* 0.10;
        return  renta;
    }




}
