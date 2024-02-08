package med.voll.api.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if (dados.idPaciente() == null) {
            return;
        }
        var estaAtivo = repository.findAtivoById(dados.idPaciente());
        if(!estaAtivo){
            throw new ValidacaoException("O paciente não está ativo.null");
        }
    }
}
