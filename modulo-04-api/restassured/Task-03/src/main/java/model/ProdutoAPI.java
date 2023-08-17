package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoAPI {

    private String _id;
    private String nome;
    private Integer preco;
    private String descricao;
    private Integer quantidade;

    private List<ProdutoAPI> produtos;

}
