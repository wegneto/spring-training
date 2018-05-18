create function `funcConcatAddress` (ID_IN long)
  returns varchar(255)
  begin
    declare result, _city, _street varchar(255);

    select
      city,
      street
    into _city, _street
    from address
    where id = ID_IN;

    set result = CONCAT(_city, ' - ', _street);

    return result;
  end;