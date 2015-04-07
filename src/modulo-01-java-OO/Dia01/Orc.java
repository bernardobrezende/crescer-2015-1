/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110, experiencia;
    private Status status = Status.VIVO;
    private String nome;
    
    // C#:
    //public Status StatusOrc { get; set; }

    {
        //vida = 110;
    }
    
    /**
     * Construtor para objetos da classe Orc
     */
    public Orc()
    {
    }    
    
    /**
     * Cria um orc informando um nome.
     * 
     * @param nome Nome a ser dado para o Orc.
     */
    public Orc(String nome) {
        this.nome = nome;
    }
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        
        // Caso o resultado seja menor que 0, o Orc não deverá receber a flecha e ainda
        // ganhará 2 pontos de experiência.
        // Senão se o número estiver entre 0 e 100 o Orc não recebe flechas e não recebe experiência. Caso contrário o Orc
        // receberá a flechada (como está hoje). 
        if (vida > 0) {
            
            double numero = gerarNumero();
            
            if (numero < 0) {
                this.experiencia += 2;
                return;
            } else if (numero > 100) {
                // FLUXO ATUAL:
            
                int danoVida = 10;
                
                if (this.vida >= danoVida) {
                    this.vida -= danoVida;
                    // this.vida = this.vida - 10;
                    this.status = Status.FERIDO;
                }
            }
        }
        else {
            this.status = Status.MORTO;
        }       
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setExperiencia(int novaExperiencia) {
        this.experiencia = novaExperiencia;
    }
    
    /**
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc. Ex:
     * 
     * "Vida atual: 110"
     */
    public String toString() {
        return "Vida atual: " + this.vida;
    }
    
    private double gerarNumero() {
        
        double numeroGerado = 0.0;
        
        // A. Se o orc possuir nome e o mesmo tiver mais de 5 letras, some 65 ao número.
        // Caso contrário, subtraia 60.
        boolean possuiNomeComMaisDe5Caracteres =
            this.nome != null && this.nome.length() > 5;
            
        if (possuiNomeComMaisDe5Caracteres) {
            numeroGerado += 65;
        } else {
            numeroGerado -= 60;
        }
        
        // B. Se o orc possuir vida entre 30 e 60, multiple o número por dois, 
        // senão se a vida for menor que 20 multiplique por 3. 
        boolean possuiVidaEntre30e60 =
            this.vida >= 30 && this.vida <= 60;
        //boolean vidaMenorQue20 = this.vida < 20;
            
        if (possuiVidaEntre30e60) {
            numeroGerado *= 2;
        } else if (this.vida < 20) {
            numeroGerado *= 3;
        }
        
        // Se o orc estiver fugindo, divida o número por 2.
        // Senão se o orc estiver caçando ou dormindo adicione 1 ao número. 
        boolean estaFugindo = this.status == Status.FUGINDO;
        boolean estaCaçandoOuDormindo =
            this.status == Status.CAÇANDO || this.status == Status.DORMINDO;
        
        if (estaFugindo) {
            numeroGerado /= 2;
            // #xatiado
        } else if (estaCaçandoOuDormindo) {
            numeroGerado += 1;
        }
        
        // Se a experiência do orc for par, eleve o número ao cubo.
        // Se for ímpar e o orc tiver mais que 2 de experiência, eleve o número ao quadrado.
        boolean experienciaÉPar = this.experiencia % 2 == 0;
        
        if (experienciaÉPar) {
            numeroGerado = numeroGerado * numeroGerado * numeroGerado;
            // numeroGerado = Math.pow(numeroGerado, 3);
        } else if (this.experiencia > 2) {
            numeroGerado = Math.pow(numeroGerado, 2);
        }
        
        return numeroGerado;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}