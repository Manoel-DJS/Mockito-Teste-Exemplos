import me.org.mockito.exemplos.ApiDosCorreios;
import me.org.mockito.exemplos.CadastrarPessoa;
import me.org.mockito.exemplos.DadosLocalizacao;
import me.org.mockito.exemplos.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CadrastarPessoaTest {
    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;
    @Test
    void validarDadosDeCadrasto(){
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Patos", "Rua 3", "Casa", "Centro");
        Mockito.when(apiDosCorreios.buscaDadpsComBaseNoCep("101101")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Sombra", "123456", LocalDate.now(), "101101");

        assertEquals("Sombra", pessoa.getNome());
        assertEquals("123456", pessoa.getDocumento());
        assertEquals("MG", pessoa.getEndereco().getUf());
        assertEquals("Casa", pessoa.getEndereco().getComplemento());
    }
}
