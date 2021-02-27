package sv.edu.udb.empleados;

import android.os.Parcel;
import android.os.Parcelable;

public class Empleado implements Parcelable {
    public String Nombre;
    public String Apellido;
    public String Cargo;
    public Integer Horas;
    public double SueldoBase;
    public double ISSS=0.0;
    public double AFP;
    public double RENTA;
    public double SueldoLiquido;

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
    }


    public int getHoras()
    {
        return Horas;
    }

    public double seldom_liquid()
    {
        return (SueldoBase-ISSS-RENTA-AFP);
    }

    public void setSueldoBase(int horas) {
        this.SueldoBase =  CalcularSueldo(horas);
    }

    public void setISSS(int horas) {
        this.ISSS = desc_ISSS(horas);
    }
    public void setAFP(int horas) {
        this.AFP = desc_AFP(horas);
    }
    public void setRENTA(int horas) {
        this.RENTA = desc_RENTA(horas);
    }

    public double CalcularSueldo(int horas) {
        double sueldo_base = 9.75;
        double sueldo_extras = 11.75;
        int horas_extras = 0;
        double total = 0.0;


        if (horas <= 160) {
            return (sueldo_base * horas);
        } else {
            horas_extras = (horas - 160);
            total = (sueldo_base * horas) + (horas_extras * sueldo_extras);
            SueldoBase = total;
            return (total);
        }
    }

    public double desc_ISSS(int horas) {
        double isss=0.0;
        isss = SueldoBase* 0.0525;
        return  isss;
    }

    public double desc_AFP(int horas) {
        double afp=0.0;
        afp =  CalcularSueldo(horas)* 0.0688;
        return  afp;
    }
    public double desc_RENTA(int horas) {
        double renta=0.0;
        renta =  CalcularSueldo(horas)* 0.10;
        return  renta;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Nombre);
        parcel.writeString(Apellido);
        parcel.writeString(Cargo);
        if (Horas == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(Horas);
        }
        parcel.writeDouble(SueldoBase);
    }
}
