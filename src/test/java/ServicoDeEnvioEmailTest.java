import me.org.mockito.exemplos.Email;
import me.org.mockito.exemplos.PlataformaDeEnvio;
import me.org.mockito.exemplos.ServicoDeEnvioEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoDeEnvioEmailTest {
    @Mock
    private PlataformaDeEnvio plataforma;

    @InjectMocks
    private ServicoDeEnvioEmail servico;

    @Captor
    private ArgumentCaptor<Email> captor;

    void validarDadosEnviadosParaPlataforma(){
        String enderecoDeEmail = "usuario@test.com.br";
        String mensagem = "Olá mundo teste mensagem";
        boolean ehFormatoHtml = false;

        servico.enviaEmail(enderecoDeEmail, mensagem, ehFormatoHtml);

        Mockito.verify(plataforma).enviaEmail(captor.capture());
        Email emailCapturado = captor.getValue();
        Assertions.assertEquals(enderecoDeEmail, emailCapturado.getEnderecoEmail());
    }
}
