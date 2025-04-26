package com.senai.escola.Controller;

import com.senai.escola.Service.AlunoService;
import com.senai.escola.model.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService _alunoService;

    public AlunoController(AlunoService service) {
        this._alunoService = service;
    }

    @GetMapping
    public List<Aluno> listar() {
        return _alunoService.listarTodos();
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return _alunoService.salvar(aluno);
    }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) {
        return _alunoService.buscarPorid(id);
    }

    @GetMapping("/{id}")
    public Aluno Atualizar(@PathVariable Long id, @RequestBody Aluno novoAluno) {
        Aluno alunoExistente = _alunoService.buscarPorid(id);
        if (alunoExistente ==  null) return null;

        alunoExistente.setNomeAluno(novoAluno.getNomeAluno());
        alunoExistente.setEmailAluno(novoAluno.getEmailAluno());
        alunoExistente.setTelefoneAluno(novoAluno.getTelefoneAluno());
        return _alunoService.salvar(alunoExistente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        _alunoService.deletar(id);
    }

}
