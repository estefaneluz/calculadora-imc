package modelo;

/**
 *
 * @author Estef
 */
public class Imc {
    private double peso;
    private double altura;

    public double calcular() {
        return (this.peso/(this.altura*this.altura));
    }
    
    public String classificacao() {
        double imc = calcular();
        if(imc <= 18.5) {
            return "Abaixo do peso";
        } else if(imc > 18.5 && imc <= 24.9 ) {
            return "Saudável";
        } else if(imc > 24.9 && imc <= 29.9 ) {
            return "Peso em excesso";
        } else if(imc > 29.9 && imc <= 34.9 ) {
            return "Obesidade grau I";
        } else if(imc > 34.9 && imc <= 39.9) {
            return "Obesidade grau II";
        } else {
            return "Obesidade Grau III";
        }
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }
}
