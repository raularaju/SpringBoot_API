package med.voll.api.domain.consulta.validacoes.agendamento;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;


@Component
public class ValidadorMedicoInativo implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if (dados.idMedico() == null) {
            return;
        }
        var estaAtivo = repository.findAtivoById(dados.idMedico());
        if(!estaAtivo){
            throw new ValidacaoException("O médico não está ativo.");
        }
    }
}
