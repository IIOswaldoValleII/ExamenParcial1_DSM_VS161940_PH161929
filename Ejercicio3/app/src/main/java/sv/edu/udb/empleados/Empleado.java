package sv.edu.udb.empleados;

class Empleado {
    public String Nombre;
    public String Apellido;
    public String Cargo;
    public Integer Horas;
    private double SueldoBase = 0.0;


    public Empleado(String nombre, String apellido, String cargo, int horas) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Cargo = cargo;
        this.Horas = horas;
    }

    public int getHoras()
    {
        return Horas;
    }


    public double CalcularSueldo(int horas) {
        double sueldo_base = 9.75;
        double sueldo_extras = 11.75;
        int horas_extras = 0;
        double total = 0.0;
        if (horas <= 160) {
            return (sueldo_base * horas);
        } else
            total = sueldo_base * horas;
        horas_extras = (horas - 160);
        total = total + (horas_extras * sueldo_extras);
        SueldoBase = total;
        return (total);
    }

    public double desc_ISSS(int horas) {
        double isss=0.0;
        isss = CalcularSueldo(horas)* 0.0525;
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


}
