package br.ufpe.cin.vjsl.vanhackchallenge.shortener;

import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, String>{}
