/*
Clase que resuelve una ecuacion de 2 grado.
 */
package modeloEcuacion;

/**
 *
 * @author usuario
 */
public class Ecuacion2Grado {
    public double[] resolver(double a, double b, double c) {
        double[] soluciones;
        //Calculamos el discriminante
        double discriminante = b * b - (4 * a * c);
        //Si es >= 0 hay soluciones reales
        if (discriminante >= 0) {
            soluciones = new double[2];
            soluciones[0] = (-b + Math.sqrt(discriminante)) / (2*a);          
            soluciones[1] = (-b - Math.sqrt(discriminante)) / (2*a);

        } else {
            soluciones = new double[0];
        }
        return soluciones;
    }
}
