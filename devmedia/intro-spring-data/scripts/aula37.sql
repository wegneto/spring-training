CREATE PROCEDURE procReplaceCPF(IN ID_IN long, OUT CPF_OUT varchar(15))
  BEGIN
    select replace(replace(cpf, '.', ''), '-', '')
    into CPF_OUT
    from documents
    where id = ID_IN;
  END;