package BackEnd;

import Validadores.ValidarObjetos;

/*
 * Esta clase se encargara de validar los valores
 */
public class Usuarios implements Validaciones {
    private String nombre;
    private String apellido;
    private String correo;
    private char[] psswd;
    private boolean esActivo;

    public Usuarios(String nombre, String apellido, String correo, char[] psswd) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setpsswd(psswd);
        this.esActivo = true;
    }

    public Usuarios(String nombre, String apellido, String correo, char[] psswd, boolean esActivo) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setpsswd(psswd);
        this.esActivo = esActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre.length() > 0 && nombre.length() <= 240) ? nombre : null;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = (apellido.length() > 0 && apellido.length() <= 35) ? apellido : null;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = (correo.length() > 0 && correo.length() <= 40 && ValidarObjetos.isEmail(correo.toString()) ? correo : null);
    }

    public char[] getpsswd() {
        return psswd;
    }

    public void setpsswd(char[] psswd) {
        this.psswd = (psswd.length > 0 && psswd.length <= 25 ? psswd : null);
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    @Override
    public String findError() {
        if (this.nombre == null) {
            return "nombre";
        } else if (this.apellido == null) {
            return "apellido";
        } else if (this.correo == null) {
            return "correo";
        } else if (this.psswd == null) {
            return "contraseña";
        } else {
            return null;
        }
    }

    @Override
    public String toSql() {
        return String.format("INSERT INTO USUARIOS(NOMBRE, APELLIDO, CORREO, PASSWORD, ES_ACTIVO) values('%s', '%s','%s', '%s', '%s')", this.nombre, this.apellido, this.correo, String.valueOf(this.psswd), (this.esActivo ? "1" : "0"));
    }
}
