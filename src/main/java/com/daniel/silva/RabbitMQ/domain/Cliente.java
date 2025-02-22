package com.daniel.silva.RabbitMQ.domain;
import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private String id ;
    private String nome;
    private Double peso;
    private Double altura;
    private Double imc;

    /**
     * @return metodo que retorna o valor do imc
     */
    public Double imcCalculator(){
        imc = ( peso / (Math.pow(altura ,2)));
        return imc;

    }

}


