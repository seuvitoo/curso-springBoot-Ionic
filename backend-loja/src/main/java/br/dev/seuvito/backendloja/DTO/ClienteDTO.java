package br.dev.seuvito.backendloja.DTO;

import br.dev.seuvito.backendloja.entities.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O nome do cliente é obrigatório")
    @Length(min = 5, max = 120, message = "O nome do cliente deve ter entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "O email do cliente é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;


    public ClienteDTO() {
    }

    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
