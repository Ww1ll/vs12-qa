package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private String nome;
    private Integer preco;
    private String descricao;
    private Integer quantidade;
    @JsonIgnore
    private String _id;
}
